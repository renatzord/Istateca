package com.istateca.app.istateca.tareas;

import com.istateca.app.istateca.models.Prestamo;
import com.istateca.app.istateca.services.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;

@Component
public class Tareas {

    @Autowired
    private PrestamoService prestamoService;

    // Tarea para el cambio de estado en caso de sobrepasar fecha maxima del prestamo
    @Scheduled(cron = "0 00 00 * * *")
    public void ejecutarTarea() {
        LocalDate localDate = LocalDate.now();
        Date date = java.sql.Date.valueOf(localDate);
        System.out.println("Fechitaaa: "+date);
        for (Prestamo prestamo: prestamoService.prestamopasados(date)) {
            System.out.println("Prestamo inicial:"+ prestamo.getEstadoPrestamo());
            prestamo.setEstadoPrestamo(5);
            System.out.println("Prestamo final:"+ prestamo.getEstadoPrestamo());
            prestamoService.update(prestamo, prestamo.getId());
        }
    }

}

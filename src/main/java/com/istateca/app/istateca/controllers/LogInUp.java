package com.istateca.app.istateca.controllers;

import com.istateca.app.constant.Validate;
import com.istateca.app.istateca.daos.AuthorityRepository;
import com.istateca.app.istateca.models.Authority;
import com.istateca.app.istateca.models.Persona;
import com.istateca.app.istateca.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
public class LogInUp {

    @Autowired
    PersonaService personaService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthorityRepository authorityRepository;

    @Value("${secretPsw}")
    String secretPsw;

    @PostMapping("/credentials")
    public ResponseEntity<?> verificar(@RequestParam String email) {
        if(!Validate.verifyEmail(email)) {
            return ResponseEntity.badRequest().body("No estas ligado al ISTA");
        }
        if (!personaService.existsByCorreo(email)) {
            logUp(email);
            return ResponseEntity.ok().body("Persona autorizada");
        }
        return ResponseEntity.ok().body("Pesona registrada");
    }

    @RequestMapping("/ingresar")
    public Persona getUserDetailsAfterLogin(Authentication authentication) {
        return personaService.findByCorreo(authentication.getName());
    }

    public void logUp(String email) {
        Persona fenix = new Persona();
        String hashPwd = passwordEncoder.encode(secretPsw);
        fenix.setCorreo(email);
        fenix.setPassword(hashPwd);
        fenix.setApellidos("Zuin Malla");
        fenix.setNombres("Andres Zuin");
        fenix.setDireccion("CUENCA");
        fenix.setCedula("1724455223");
        Persona persona = personaService.save(fenix);
        Authority role = new Authority();
        role.setName("ROLE_ESTUD");
        role.setPersona(persona);
        authorityRepository.save(role);
    }

}

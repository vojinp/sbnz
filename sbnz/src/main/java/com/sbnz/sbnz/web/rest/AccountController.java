package com.sbnz.sbnz.web.rest;

import com.sbnz.sbnz.domain.JWTUser;
import com.sbnz.sbnz.domain.User;
import com.sbnz.sbnz.domain.enumeration.Authority;
import com.sbnz.sbnz.service.JWTService;
import com.sbnz.sbnz.service.KieService;
import com.sbnz.sbnz.service.UserService;
import com.sbnz.sbnz.service.dto.LoginDTO;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AccountController {

    @Autowired
    UserService userService;

    @Autowired
    JWTService jwtService;

    @Autowired
    KieService kieService;

    @RequestMapping(method= RequestMethod.POST, value = "/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        User user = userService.validateUser(loginDTO.getUsername(), loginDTO.getPassword());

        HttpHeaders headers = new HttpHeaders();

        if (user == null)
            return new ResponseEntity<>(headers, HttpStatus.UNAUTHORIZED);
        JWTUser jwtUser = new JWTUser(user.getUsername());
        String token = jwtService.getToken(jwtUser);
        headers.add("Authorization", token);
        KieSession session = kieService.kieContainer.newKieSession();
        kieService.kieSessions.put(token, session);
        kieService.fillKieSession(session);
        //kieService.startMonitoringSimulation();
        return ResponseEntity.ok().headers(headers).body(user.getAuthority());
    }
}

package crisci.caterina.gestione_eventi.controllers;

import crisci.caterina.gestione_eventi.DTO.LoginDTO;
import crisci.caterina.gestione_eventi.DTO.UserDTO;
import crisci.caterina.gestione_eventi.models.User;
import crisci.caterina.gestione_eventi.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public LoginDTO login(@RequestBody UserDTO payload) {
        return new LoginDTO(authService.authenticateUserAndGenerateToken(payload));
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody UserDTO newUser) {
        return this.authService.saveUser(newUser);
    }
}

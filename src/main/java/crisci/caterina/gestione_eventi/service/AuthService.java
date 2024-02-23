package crisci.caterina.gestione_eventi.service;

import crisci.caterina.gestione_eventi.DTO.UserDTO;
import crisci.caterina.gestione_eventi.exceptions.UnauthorizedException;
import crisci.caterina.gestione_eventi.models.User;
import crisci.caterina.gestione_eventi.repository.UserRepository;
import crisci.caterina.gestione_eventi.exceptions.BadRequestException;
import crisci.caterina.gestione_eventi.security.JWTTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder bcrypt;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JWTTools jwtTools;

    public String authenticateUserAndGenerateToken(UserDTO payload) {
        User user = userService.findByEmail(payload.email());
        if (bcrypt.matches(payload.password(), user.getPassword())) {
            return jwtTools.createToken(user);
        } else {
            throw new UnauthorizedException("Invalid credentials");
        }
    }
    public User saveUser(UserDTO payload) {
        userRepository.findByEmail(payload.email()).ifPresent(user -> {
            throw new BadRequestException("Email " + user.getEmail() + " taken!");
        });

        User newUser =  User.fromUserDto(payload);

        User savedUser = userRepository.save(newUser);
        return savedUser;
    }
}

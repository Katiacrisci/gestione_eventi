package crisci.caterina.gestione_eventi.models;

import crisci.caterina.gestione_eventi.DTO.UserDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String fullName;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    @ManyToMany
    private List<Event> events;

    public static User fromUserDto(UserDTO userDTO) {
        User user = new User();
        user.fullName = userDTO.fullName();
        user.email = userDTO.email();
        user.password = userDTO.password();
        user.role = userDTO.role();
        return user;
    }



}

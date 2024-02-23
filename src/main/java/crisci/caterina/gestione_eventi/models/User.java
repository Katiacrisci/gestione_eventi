package crisci.caterina.gestione_eventi.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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



}

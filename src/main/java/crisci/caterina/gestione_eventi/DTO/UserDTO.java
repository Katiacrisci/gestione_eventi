package crisci.caterina.gestione_eventi.DTO;

import crisci.caterina.gestione_eventi.models.Role;

public record UserDTO(String fullName, String email, String password, Role role) {

}

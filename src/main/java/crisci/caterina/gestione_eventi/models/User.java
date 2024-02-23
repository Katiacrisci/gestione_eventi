package crisci.caterina.gestione_eventi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import crisci.caterina.gestione_eventi.DTO.UserDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@JsonIgnoreProperties({"password", "credentialsNonExpired", "accountNonExpired", "authorities", "username", "accountNonLocked", "enabled"})
public class User  implements UserDetails {
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


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of((new SimpleGrantedAuthority(this.role.name())));
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }


}

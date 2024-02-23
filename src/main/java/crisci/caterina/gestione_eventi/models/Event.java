package crisci.caterina.gestione_eventi.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class Event {
    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String place;
    private LocalDate date;
    @ManyToMany
    private List<User> attendees;
    private Integer capacity;

}

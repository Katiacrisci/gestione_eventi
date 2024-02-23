package crisci.caterina.gestione_eventi.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.List;

public class Event {
    @Id
    @GeneratedValue
    private Long id;

    private String place;
    private LocalDate date;
    private List<User> attendees;
}

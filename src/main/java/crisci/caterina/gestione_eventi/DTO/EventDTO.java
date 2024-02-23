package crisci.caterina.gestione_eventi.DTO;

import java.time.LocalDate;

public record EventDTO(LocalDate date, String title,
                       String place, Integer capacity) {


}

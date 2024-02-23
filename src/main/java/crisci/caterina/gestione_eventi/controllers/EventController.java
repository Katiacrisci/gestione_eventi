package crisci.caterina.gestione_eventi.controllers;

import crisci.caterina.gestione_eventi.DTO.EventDTO;
import crisci.caterina.gestione_eventi.models.Event;
import crisci.caterina.gestione_eventi.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/events")
public class EventController {



    @Autowired
    private EventService eventService;

    @GetMapping
    public Page<Event> getAllEvents(@RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "10") int size,
                                   @RequestParam(defaultValue = "id") String orderBy
    ) {
        return this.eventService.getEvents(page, size, orderBy);
    }

    @PostMapping("/")
    public Event create(EventDTO eventDTO) {
        return eventService.create(eventDTO);
    }


}


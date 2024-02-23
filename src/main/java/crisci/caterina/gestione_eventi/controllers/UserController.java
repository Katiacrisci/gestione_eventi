package crisci.caterina.gestione_eventi.controllers;

import crisci.caterina.gestione_eventi.models.Event;
import crisci.caterina.gestione_eventi.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private EventService eventService;

    @PostMapping("/{userId}/{eventId}")
    public Event participate(@PathVariable Long userId, @PathVariable Long eventId) {
        return eventService.addParticipant(userId, eventId);
    }

}

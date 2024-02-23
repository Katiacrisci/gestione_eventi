package crisci.caterina.gestione_eventi.service;

import crisci.caterina.gestione_eventi.models.Event;
import crisci.caterina.gestione_eventi.models.User;
import crisci.caterina.gestione_eventi.repository.EventRepository;
import crisci.caterina.gestione_eventi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    public Event create(Event event) {
        return eventRepository.save(event);
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    public Event edit(Event event, Long id) {
        if (!eventRepository.existsById(id)) {
            return null;
        }
        if(!id.equals(event.getId())) {
            return null;
        }
        return eventRepository.save(event);
    }

    public Event addParticipant(Long userId, Event event) {
        if (event.getCapacity().equals(event.getAttendees().size())) {
            return null;
        }
        User user = userService.getById(userId);
        event.getAttendees().add(user);
        user.getEvents().add(event);
        userService.save(user);
       return eventRepository.save(event);

    }
}

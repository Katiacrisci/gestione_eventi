package crisci.caterina.gestione_eventi.service;

import crisci.caterina.gestione_eventi.DTO.EventDTO;
import crisci.caterina.gestione_eventi.models.Event;
import crisci.caterina.gestione_eventi.models.User;
import crisci.caterina.gestione_eventi.repository.EventRepository;
import crisci.caterina.gestione_eventi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    public Page<Event> getEvents(int pageNumber, int size, String orderBy) {
        if (size > 100) size = 100;
        Pageable pageable = PageRequest.of(pageNumber, size, Sort.by(orderBy));
        return eventRepository.findAll(pageable);
    }

    public Event create(EventDTO eventDTO) {
        return eventRepository.save(Event.fromDTO(eventDTO));
    }
    public Event getById(Long id) {
        return eventRepository.findById(id).orElseThrow();
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

    public Event addParticipant(Long userId, Long eventId) {
        Event event = getById(eventId);
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

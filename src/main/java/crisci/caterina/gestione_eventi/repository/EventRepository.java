package crisci.caterina.gestione_eventi.repository;

import crisci.caterina.gestione_eventi.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
}

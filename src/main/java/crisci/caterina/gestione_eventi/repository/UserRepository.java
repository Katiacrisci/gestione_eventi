package crisci.caterina.gestione_eventi.repository;

import crisci.caterina.gestione_eventi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


}

package crisci.caterina.gestione_eventi.service;

import crisci.caterina.gestione_eventi.models.User;
import crisci.caterina.gestione_eventi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
       return userRepository.save(user);
    }

    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

}

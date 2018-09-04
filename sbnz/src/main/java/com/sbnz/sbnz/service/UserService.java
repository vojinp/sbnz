package com.sbnz.sbnz.service;

import com.sbnz.sbnz.domain.User;
import com.sbnz.sbnz.repository.UserRepository;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        log.debug("Request to save User : {}", user);
        user = userRepository.save(user);
        return user;
    }

    @Transactional(readOnly = true)
    public List<User> findAll() {
        log.debug("Request to get all Diagnoses");
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<User> findOne(Long id) {
        log.debug("Request to get User : {}", id);
        return userRepository.findById(id);
    }

    public void delete(Long id) {
        log.debug("Request to delete User : {}", id);
        userRepository.deleteById(id);
    }

    public User validateUser(String username, String password) {
        return userRepository.findByUsername(username);
    }
}

package com.example.springtest.repository;

import com.example.springtest.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void testSaveUser() {

        User user = new User();
        user.setName("Raji");

        User saved = userRepository.save(user);

        assertNotNull(saved);
        assertNotNull(saved.getId());
    }
}
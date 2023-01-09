package com.levelup.library.dataseed;

import com.levelup.library.entities.UserEntity;
import com.levelup.library.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class UserDataLoader implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;

    public void run(String ...args) throws Exception {
        loadUserData();
    }

    private void loadUserData() {
        if(userRepository.count() == 0) {
            UserEntity user1 = new UserEntity("Renan Dorneles", "renas", "04174928045", "2000-03-23", "+5551998691353", "rdorneles64@gmail.com", "46070d4bf934fb0d4b06d9e2c46e346944e322444900a435d7d9a95e6d7435f5");
            userRepository.save(user1);
        }
    }
}

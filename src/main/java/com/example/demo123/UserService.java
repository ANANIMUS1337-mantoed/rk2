package com.example.demo123;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Page<User> getUsers(int page, int size) {
        return userRepository.findAll(PageRequest.of(page, size));
    }

    public void saveUser(String name) {
        userRepository.save(new User(name));
    }

    public void saveUsers(List<String> names) {
        List<User> users = names.stream().map(User::new).toList();
        userRepository.saveAll(users);
    }

    public long countUsers() {
        return userRepository.count();
    }
}

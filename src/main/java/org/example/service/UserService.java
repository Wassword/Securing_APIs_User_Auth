package org.example.service;

import org.example.dto.RegistrationDto;
import org.example.dto.CredentialsDto;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public org.example.entity.User login(CredentialsDto credentials) {
        org.example.entity.User user = userRepository.findByUsername(credentials.getUsername());
        if (user == null || !user.getPassword().equals(credentials.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
        return user;
    }

    public org.example.entity.User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public org.example.entity.User register(RegistrationDto registration) {
        if (userRepository.findByUsername(registration.getUsername()) != null) {
            throw new RuntimeException("Username already exists");
        }

        // Convert String[] to Collection<GrantedAuthority>
        Collection<GrantedAuthority> authorities = Arrays.stream(registration.getRoles())
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        // Assuming org.example.entity.User constructor matches these parameters
        org.example.entity.User user = new org.example.entity.User(registration.getUsername(), registration.getPassword(), authorities);

        userRepository.addUser(user);
        return user;
    }
}
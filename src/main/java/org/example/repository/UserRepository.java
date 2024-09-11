package org.example.repository;

import org.example.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.GrantedAuthority;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    // Changed from array to List for easier manipulation
    private List<User> users = new ArrayList<>(Arrays.asList(
            new User("admin", "admin", getAuthorities(new String[]{"USER", "ADMIN"})),
            new User("user", "user", getAuthorities(new String[]{"USER"}))
    ));

    public User findByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    // Method to add a user to the repository
    public void addUser(User user) {
        users.add(user);
    }

    // Helper method to convert String[] roles to Collection<GrantedAuthority>
    private static Collection<GrantedAuthority> getAuthorities(String[] roles) {
        return Arrays.stream(roles)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}

package com.example.diploma;

import com.example.diploma.model.User;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class AuthUser extends org.springframework.security.core.userdetails.User {
    @NonNull
    private User user;

    public AuthUser(User user) {
        super(user.getEmail(), user.getPassword(), user.getRoles());
        this.user = user;
    }

    public int id() {
        return user.id();
    }
}

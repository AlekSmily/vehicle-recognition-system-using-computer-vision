package com.example.diploma;

import com.example.diploma.model.Role;
import com.example.diploma.model.User;
import com.example.diploma.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
@AllArgsConstructor
public class Main implements ApplicationRunner {
	private final UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		userRepository.save(new User("user@gmail.com", "User", "First", "qwerty", Set.of(Role.ROLE_USER)));
		userRepository.save(new User("admin@gmail.com", "Admin", "First", "qwerty", Set.of(Role.ROLE_USER, Role.ROLE_ADMIN)));
		System.out.println(userRepository.findAll());
	}
}

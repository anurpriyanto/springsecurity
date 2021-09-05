package com.example.springsecurity;

import com.example.springsecurity.domain.AppUser;
import com.example.springsecurity.domain.Role;
import com.example.springsecurity.service.AppUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SpringsecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringsecurityApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(AppUserService appUserService){
		return  args -> {
			appUserService.saveRole(new Role(null,"ROLE_USER"));
			appUserService.saveRole(new Role(null,"ROLE_MANAGER"));
			appUserService.saveRole(new Role(null,"ROLE_ADMIN"));
			appUserService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));

			appUserService.saveUser(new AppUser(null,"Adiba Zayna","adiba","1234",new ArrayList<>()));
			appUserService.saveUser(new AppUser(null,"Anur Priyanto","anur","1234",new ArrayList<>()));
			appUserService.saveUser(new AppUser(null,"Gadis Permata","permata","1234",new ArrayList<>()));

			appUserService.addRoleToUser("adiba","ROLE_USER");
			appUserService.addRoleToUser("adiba","ROLE_MANAGER");
			appUserService.addRoleToUser("anur","ROLE_MANAGER");
			appUserService.addRoleToUser("permata","ROLE_ADMIN");
			appUserService.addRoleToUser("permata","ROLE_SUPER_ADMIN");
		};
	}
}

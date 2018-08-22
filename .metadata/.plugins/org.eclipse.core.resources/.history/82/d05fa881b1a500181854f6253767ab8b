package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringBootDataJpaApplication implements CommandLineRunner{
    @Autowired
    private BCryptPasswordEncoder passwordEnoder;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataJpaApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		
		String password = "12345";
		
		for(int i=0;i<2;i++){
			String bcryptPassword = passwordEnoder.encode(password);
			System.out.println(bcryptPassword);
		}
	}
}

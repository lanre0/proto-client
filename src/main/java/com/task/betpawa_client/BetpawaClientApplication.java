package com.task.betpawa_client;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.task.betpawa_client.services.AsynchronousService; 

import io.grpc.Server;
import io.grpc.ServerBuilder;

@SpringBootApplication
public class BetpawaClientApplication {

	
	@Autowired
	AsynchronousService asynchronousService;
	
	public static void main(String[] args) {
		SpringApplication.run(BetpawaClientApplication.class, args);
		 
	}

	
	@Bean
	public CommandLineRunner buildData() {
	
		return (args) -> {
		 
		//	asynchronousService.executeAsynchronouslyC(3l);
	 
			
		};
	}
}

package com.task.betpawa_client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.betpawa_client.dto.ClientRequest;
import com.task.betpawa_client.services.AsynchronousService;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/client")
public class MultiClientController {
	
	private static final Logger logger = LoggerFactory.getLogger(MultiClientController.class);
	
	@Autowired
	AsynchronousService asynchronousService;
	

	@PostMapping
	public String execute(@RequestBody ClientRequest clientRequest) 	throws InterruptedException {
		 
		long time = System.currentTimeMillis();
		 
		Long userId=0l;
		  for(int a=0;a<=clientRequest.getTotalUsers();a++) {
			  System.out.println("---number of concurrent users emulated---"+a);
			  userId=  new Long(a+1);
		      for(int x=0;x<=clientRequest.getTotalRounds();x++) {
		    	  System.out.println("---number of rounds each thread is executing)---");
			    	  
			    	  int randomNum = ThreadLocalRandom.current().nextInt(1, 3 + 1);
			    	  switch (randomNum) {
			    	  case 1:
			    		  asynchronousService.executeAsynchronouslyA(userId);
			    	    break;
			    	  case 2:
			    		  asynchronousService.executeAsynchronouslyB(userId);
			    	    break;
			    	  case 3:
			    		  asynchronousService.executeAsynchronouslyC(userId);
			    	    break;
			    	  
			    	}
				      System.out.println(randomNum);  
			      } 
		      }
	     
		    long timeTaken = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - time);
			logger.info("Excecution done time taken: {} {}", timeTaken, TimeUnit.SECONDS.name());
			 
			return "Excecution done time taken: "+ timeTaken+" "+ TimeUnit.SECONDS.name();
	}
}

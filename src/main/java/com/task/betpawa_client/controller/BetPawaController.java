package com.task.betpawa_client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.task.betpawa_proto.CURRENCY;
import com.task.betpawa_proto.Request;
import com.task.betpawa_client.services.GrpcCallService;

@RestController
@RequestMapping("/client")
public class BetPawaController {

	
	@Autowired
	GrpcCallService grpcCallService;
	
	
	@GetMapping(path = "/balance")
	public String balance(@RequestParam(value = "userid") Long userID)throws InterruptedException
	{
		  Request request = Request.newBuilder()
	    		  .setUserID(userID)  
		          .build();
	      return	grpcCallService.balance(request);
    }
	
	
	@GetMapping(path = "/withdraw")
	public String withdraw(@RequestParam(value = "userid") Long userID, @RequestParam(value = "amount") String amount,
			@RequestParam(value = "currency") CURRENCY currency) throws InterruptedException
	{
		  Request request = Request.newBuilder()
	    		  .setUserID(userID).setAmount(amount).setCurrency(currency)  
		          .build();
	      return	grpcCallService.withdraw(request);
    }
	
	
	@GetMapping(path = "/deposit")
	public String deposit(@RequestParam(value = "userid") Long userID, @RequestParam(value = "amount") String amount,
			@RequestParam(value = "currency") CURRENCY currency)throws InterruptedException
	{
		  Request request = Request.newBuilder()
	    		  .setUserID(userID).setAmount(amount).setCurrency(currency)  
		          .build();
	      return	grpcCallService.deposit(request);
    }
}

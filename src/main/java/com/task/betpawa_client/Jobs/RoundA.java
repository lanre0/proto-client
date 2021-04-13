package com.task.betpawa_client.Jobs;


import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.task.betpawa_proto.Request;
import com.task.betpawa_proto.CURRENCY;
import org.springframework.context.annotation.Scope;

import com.task.betpawa_client.services.GrpcCallService;
 
@Component
@Scope("prototype")
public class RoundA implements   Runnable  {
	
	@Autowired
	GrpcCallService grpcCallService;
	
    Long userId;
	
	public void setName(Long userId){
		this.userId = userId;
	}
	
	  private static final Logger LOGGER = LoggerFactory.getLogger(RoundA.class);
	  @Override
	    public void run() {
	        LOGGER.info("Called from thread  A");
	        System.out.println(userId);
	      //  long time = System.currentTimeMillis();
	        //	Deposit 100 USD
	        Request request1 = Request.newBuilder()
	        		.setUserID(userId).setAmount("100").setCurrency(CURRENCY.USD)  
			          .build();
		    grpcCallService.deposit(request1);
		    
	        //	Withdraw 200 USD
		    Request request2 = Request.newBuilder()
		    		.setUserID(userId).setAmount("200").setCurrency(CURRENCY.USD)  
	        		.build();
		    grpcCallService.withdraw(request2);
		    
	        //	Deposit 100 EUR
		    Request request3 = Request.newBuilder()
	        		.setUserID(userId).setAmount("100").setCurrency(CURRENCY.EUR)  
			          .build();
		    grpcCallService.deposit(request3);
		    
	        //	Get Balance
		    Request request4 = Request.newBuilder()
	        		.setUserID(userId)
	        		.build();
		    grpcCallService.balance(request4);
		    
	        //	Withdraw 100 USD
		    Request request5 = Request.newBuilder()
		    		.setUserID(userId).setAmount("100").setCurrency(CURRENCY.USD)  
	        		.build();
		    grpcCallService.withdraw(request5);
		    
	        //	Get Balance
		    Request request6 = Request.newBuilder()
	        		.setUserID(userId)
	        		.build();
		    grpcCallService.balance(request6);
		    
	        //	Withdraw 100 USD
		    Request request7 = Request.newBuilder()
		    		.setUserID(userId).setAmount("100").setCurrency(CURRENCY.USD)  
	        		.build();
		    grpcCallService.withdraw(request7);
		  //  long timeTaken = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - time);
		  // LOGGER.info("Excecution ----- done time taken: {} {}", timeTaken, TimeUnit.SECONDS.name());
	       
	    }
}

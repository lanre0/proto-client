package com.task.betpawa_client.Jobs;


import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.task.betpawa_client.services.GrpcCallService;
import com.task.betpawa_proto.CURRENCY;
import com.task.betpawa_proto.Request;
 
@Component
@Scope("prototype")
public class RoundC implements   Runnable  {
	
	@Autowired
	GrpcCallService grpcCallService;
	
	 Long userId;
		
		public void setName(Long userId){
			this.userId = userId;
		}
	  private static final Logger LOGGER = LoggerFactory.getLogger(RoundC.class);
	  @Override
	    public void run() {
	        LOGGER.info("Called from thread C");
	     //   long time = System.currentTimeMillis();
	        //	Get Balance
	        Request request1 = Request.newBuilder()
	        		.setUserID(userId)
	        		.build();
		    grpcCallService.balance(request1);
		    
	        //	Deposit 100 USD
		    Request request2 = Request.newBuilder()
	        		.setUserID(userId).setAmount("100").setCurrency(CURRENCY.USD)  
			          .build();
		    grpcCallService.deposit(request2);
		    
	        //	Deposit 100 USD
		    Request request3 = Request.newBuilder()
	        		.setUserID(userId).setAmount("100").setCurrency(CURRENCY.USD)  
			          .build();
		    grpcCallService.deposit(request3);
		    
	        //	Withdraw 100 USD
		    Request request4 = Request.newBuilder()
		    		.setUserID(userId).setAmount("100").setCurrency(CURRENCY.USD)  
	        		.build();
		    grpcCallService.withdraw(request4);
		    
	        //	Depsoit 100 USD
		    Request request5 = Request.newBuilder()
	        		.setUserID(userId).setAmount("100").setCurrency(CURRENCY.USD)  
			          .build();
		    grpcCallService.deposit(request5);
		    
	        //	Get Balance
		    Request request6 = Request.newBuilder()
	        		.setUserID(userId)
	        		.build();
		    grpcCallService.balance(request6);
		    
	        //	Withdraw 200 USD
		    Request request7 = Request.newBuilder()
	        		.setUserID(userId).setAmount("200").setCurrency(CURRENCY.USD)  
			          .build();
		    grpcCallService.deposit(request7);
		    
	        //	Get Balance
		    Request request8 = Request.newBuilder()
	        		.setUserID(userId)
	        		.build();
		    grpcCallService.balance(request8);
		 //   long timeTaken = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - time);
		 //   LOGGER.info("Excecution done time taken: {} {}", timeTaken, TimeUnit.SECONDS.name());
	       
	    }
}

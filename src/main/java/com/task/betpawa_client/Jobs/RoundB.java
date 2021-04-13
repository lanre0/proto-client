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
public class RoundB implements   Runnable  {
	
	@Autowired
	GrpcCallService grpcCallService;
	
	 Long userId;
		
		public void setName(Long userId){
			this.userId = userId;
		}
	  private static final Logger LOGGER = LoggerFactory.getLogger(RoundB.class);
	  @Override
	    public void run() {
	        LOGGER.info("Called from thread B");
	        System.out.println(userId);
	      //  long time = System.currentTimeMillis();
	        //	Withdraw 100 GBP
	        Request request1 = Request.newBuilder()
		    		.setUserID(userId).setAmount("100").setCurrency(CURRENCY.GBP)  
	        		.build();
		    grpcCallService.withdraw(request1);
		    
	        //	Deposit 300 GPB
		    Request request2 = Request.newBuilder()
	        		.setUserID(userId).setAmount("300").setCurrency(CURRENCY.GBP)  
			          .build();
		    grpcCallService.deposit(request2);
		    
	        //	Withdraw 100 GBP
		    Request request3 = Request.newBuilder()
		    		.setUserID(userId).setAmount("100").setCurrency(CURRENCY.GBP)  
	        		.build();
		    grpcCallService.withdraw(request3);
		    
	        //	Withdraw 100 GBP
		    Request request4 = Request.newBuilder()
		    		.setUserID(userId).setAmount("100").setCurrency(CURRENCY.GBP)  
	        		.build();
		    grpcCallService.withdraw(request4);
		    
	        //	Withdraw 100 GBP
		    Request request5 = Request.newBuilder()
		    		.setUserID(userId).setAmount("100").setCurrency(CURRENCY.GBP)  
	        		.build();
		    grpcCallService.withdraw(request5);
		 //   long timeTaken = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - time);
		 //   LOGGER.info("Excecution done time taken: {} {}", timeTaken, TimeUnit.SECONDS.name());
	      
	    }
}

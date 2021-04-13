package com.task.betpawa_client.services;



import com.task.betpawa_client.Jobs.RoundA; 
import com.task.betpawa_client.Jobs.RoundB; 
import com.task.betpawa_client.Jobs.RoundC;
import com.task.betpawa_client.config.ThreadConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Service
public class AsynchronousService {

	
	    @Autowired
	    private TaskExecutor taskExecutor;
	    @Autowired
	    private ApplicationContext applicationContext;
	    
	    public void executeAsynchronouslyA(Long userId) {
	    	 
	    	RoundA myThread = applicationContext.getBean(RoundA.class);
	    	 myThread.setName(userId);  
	        taskExecutor.execute(myThread);
	        
	    }
	    
	    public void executeAsynchronouslyB(Long userId) {
	    	 
	    	RoundB myThread = applicationContext.getBean(RoundB.class);
	    	 myThread.setName(userId); 
	         taskExecutor.execute(myThread);
	         
	    }
	    
	    public void executeAsynchronouslyC(Long userId) {
	    	
	    	RoundC myThread = applicationContext.getBean(RoundC.class);
	    	 myThread.setName(userId); 
	        taskExecutor.execute(myThread);
	    }
}

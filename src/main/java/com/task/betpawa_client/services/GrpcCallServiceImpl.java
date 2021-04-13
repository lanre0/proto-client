package com.task.betpawa_client.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.betpawa_proto.CURRENCY;
import com.task.betpawa_proto.OperationServiceGrpc;
import com.task.betpawa_proto.Request;
import com.task.betpawa_proto.Response;
import com.task.betpawa_client.util.EnvironmentProperties;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

@Service
public class GrpcCallServiceImpl implements GrpcCallService {
	@Autowired
	private EnvironmentProperties environmentProperties;

	@Override
	public String balance(Request request) {
		
		 String port = environmentProperties.getPort();
		 String localhost =	 environmentProperties.getServerlocation();
		 
		 final ManagedChannel channel = ManagedChannelBuilder.forTarget(localhost+":"+port)    
			        .usePlaintext(true)
			        .build();  

			      OperationServiceGrpc.OperationServiceBlockingStub stub =   OperationServiceGrpc.newBlockingStub(channel);
			        request = Request.newBuilder()
			    		  .setUserID(request.getUserID())  
				          .build();
			       
			      Response response =   stub.balance(request);        
			      channel.shutdownNow();
			      
		return response.toString();
	}

	@Override
	public String deposit(Request request) {
	 String port = environmentProperties.getPort();
	 String localhost =	 environmentProperties.getServerlocation();
	 
	 final ManagedChannel channel = ManagedChannelBuilder.forTarget(localhost+":"+port)       
			        .usePlaintext(true)
			        .build();  

			      OperationServiceGrpc.OperationServiceBlockingStub stub =   OperationServiceGrpc.newBlockingStub(channel);
			        request = Request.newBuilder()
			    		  .setAmount(request.getAmount()).setUserID(request.getUserID()).setCurrency(request.getCurrency())  
				          .build();
			       
			      
			      Response response =   stub.deposit (request);      
			               
			      channel.shutdownNow();
			      
		return response.toString();
	}

	@Override
	public String withdraw(Request request) {
	 String port = environmentProperties.getPort();
	 String localhost =	 environmentProperties.getServerlocation();
 
		 final ManagedChannel channel = ManagedChannelBuilder.forTarget(localhost+":"+port)   
			        .usePlaintext(true)
			        .build();  

			      OperationServiceGrpc.OperationServiceBlockingStub stub =   OperationServiceGrpc.newBlockingStub(channel);
			        request = Request.newBuilder()
			    		  .setAmount(request.getAmount()).setUserID(request.getUserID()).setCurrency(request.getCurrency())  
				          .build();
			           
			        
			      Response response =   stub.withdraw(request);        
			      channel.shutdownNow();
			      
		return response.toString();
	}

}

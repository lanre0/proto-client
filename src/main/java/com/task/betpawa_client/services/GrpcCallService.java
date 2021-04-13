package com.task.betpawa_client.services;

import org.springframework.stereotype.Service;

import com.task.betpawa_proto.Request;

@Service
public interface GrpcCallService {
  public String balance(Request request);
  
  public String deposit(Request request);
  
  public String withdraw(Request request);
  
}

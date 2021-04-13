package com.task.betpawa_client.dto;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class FetchUser {
String userId;
	
	public void setName(String userId){
		this.userId = userId;
	}
}

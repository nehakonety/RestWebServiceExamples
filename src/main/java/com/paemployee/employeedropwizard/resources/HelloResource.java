package com.paemployee.employeedropwizard.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloResource {
	
	private String message;
	
	public HelloResource(String msg){
		this.message = msg;
	}
	
	@GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getGreeting() {
        return message;
    }

}

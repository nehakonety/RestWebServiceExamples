package com.paemployee.employeedropwizard;

import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.*;

import javax.validation.Valid;
import javax.validation.constraints.*;

public class EmployeeDropwizardConfiguration extends Configuration {
    // TODO: implement service configuration
	@NotEmpty	
	private String message;
	
	@JsonProperty
	public String getMessage() {
		return message;
	}	
	
	@NotNull
	@Valid
	@JsonProperty("database")
	private DataSourceFactory database = new DataSourceFactory();
	
	@JsonProperty("url")
	private String url = new String();
	@JsonProperty("username")
	private String username = new String();
	@JsonProperty("password")
	private String password = new String();
	
		
	
	public DataSourceFactory getDataSourceFactory() {
        return database;
    }


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	
	
}

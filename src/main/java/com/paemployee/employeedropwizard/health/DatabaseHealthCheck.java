package com.paemployee.employeedropwizard.health;

import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.util.IntegerMapper;

import com.codahale.metrics.health.HealthCheck;

public class DatabaseHealthCheck extends HealthCheck{

	private DBI dbi;
	
	
	public DatabaseHealthCheck( DBI dbi){		
		this.dbi = dbi;		
	}
	 
	@Override
	protected Result check() throws Exception {
		try{
			final Handle handle = dbi.open();		
			handle.createQuery("select 1 from EMPLOYEE").map(IntegerMapper.FIRST).first();
			handle.close();
		}catch( Exception e ){
			return Result.unhealthy("Database is not running!");
		}		
		return Result.healthy();
	}

}

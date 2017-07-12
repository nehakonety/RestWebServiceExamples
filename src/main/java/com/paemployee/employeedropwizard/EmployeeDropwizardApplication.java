package com.paemployee.employeedropwizard;

import org.flywaydb.core.Flyway;
import org.skife.jdbi.v2.DBI;

import com.paemployee.employeedropwizard.db.dao.EmployeeDAO;
import com.paemployee.employeedropwizard.health.DatabaseHealthCheck;
import com.paemployee.employeedropwizard.resources.EmployeeResource;
import com.paemployee.employeedropwizard.resources.HelloResource;

import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.flyway.FlywayBundle;
import io.dropwizard.flyway.FlywayFactory;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class EmployeeDropwizardApplication extends Application<EmployeeDropwizardConfiguration> {
	
	 DBI jdbi=null;

    public static void main(final String[] args) throws Exception {
        new EmployeeDropwizardApplication().run(args);
    }

    @Override
    public String getName() {
        return "EmployeeDropwizard";
    }

    @Override
    public void initialize(final Bootstrap<EmployeeDropwizardConfiguration> bootstrap) {
        // TODO: application initialization
    	  	
    	
    }

    @Override
    public void run(final EmployeeDropwizardConfiguration configuration,
                    final Environment environment) {	
    	
        // TODO: implement application
    		Flyway flyway = new Flyway();
    		flyway.setDataSource(configuration.getDataSourceFactory().getUrl(),
                    configuration.getDataSourceFactory().getUser(),
                    configuration.getDataSourceFactory().getPassword());
    		flyway.migrate();
    	
    	
    	 final DBIFactory factory = new DBIFactory();
    	 jdbi = factory.build(environment, configuration.getDataSourceFactory(), "h2");
    	 
    	 EmployeeDAO employeedao =  jdbi.onDemand(EmployeeDAO.class);
    	 EmployeeResource employeeresource = new EmployeeResource(employeedao);
    	 
    	 environment.jersey().register(employeeresource);
    	 
    	 environment.jersey().register(new HelloResource(configuration.getMessage()));
    	 environment.healthChecks().register("database", new DatabaseHealthCheck(jdbi));
    	
    }

}

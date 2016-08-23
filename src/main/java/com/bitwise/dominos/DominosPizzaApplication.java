package com.bitwise.dominos;

import com.bitwise.dominos.resource.ingredients.CrustRepository;
import com.bitwise.dominos.resource.ingredients.CrustResource;
import com.bitwise.dominos.resource.ingredients.ToppingsRepository;
import com.bitwise.dominos.resource.ingredients.ToppingsResource;
import com.bitwise.dominos.resource.pizza.PizzasRepository;
import com.bitwise.dominos.resource.pizza.PizzasResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;
import static org.eclipse.jetty.servlets.CrossOriginFilter.*;

/**
 * Created by kirankumarbs on 8/16/2016.
 */
public class DominosPizzaApplication extends Application<AppConfiguration> {

    public static final Logger LOGGER = LoggerFactory.getLogger(DominosPizzaApplication.class);

    public static void main(String[] args) throws Exception {
        new DominosPizzaApplication().run(args);
    }

    @Override
    public void run(AppConfiguration configuration, Environment environment) throws Exception {
        LOGGER.info("Aplicatio Name: {}",configuration.getAppName());

        final FilterRegistration.Dynamic cors =
                environment.servlets().addFilter("CORS", CrossOriginFilter.class);

        // Configure CORS parameters
        cors.setInitParameter("allowedOrigins", "*");
        cors.setInitParameter("allowedHeaders", "*");
        cors.setInitParameter("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");

        // Add URL mapping
        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");


        final PizzasRepository pizzasRepository = new PizzasRepository();
        final PizzasResource pizzasResource = new PizzasResource(pizzasRepository);
        final CrustRepository crustRepository = new CrustRepository();
        final CrustResource crustResource = new CrustResource(crustRepository);
        final ToppingsRepository toppingsRepository = new ToppingsRepository();
        final ToppingsResource toppingsResource = new ToppingsResource(toppingsRepository);

        environment.jersey().register(pizzasResource);
        environment.jersey().register(crustResource);
        environment.jersey().register(toppingsResource);
    }

}


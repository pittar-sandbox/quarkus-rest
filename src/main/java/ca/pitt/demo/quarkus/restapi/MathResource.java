package ca.pitt.demo.quarkus.restapi;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.Body;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

import ca.pitt.demo.quarkus.restapi.model.Numbers;

import org.eclipse.microprofile.config.inject.ConfigProperty;


@Path("/")
public class MathResource {

    @ConfigProperty(name="math.operation")
    String operation;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String evaluate(@QueryParam("x") Double x, @QueryParam("y") Double y) {
        String response = "";
        if ("x".equals(operation)) {
            response += x + " x " + y + " = " + (x * y);
        } else {
            response += x + " + " + y + " = " + (x + y);
        }
        System.err.println(response);
        return response;
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public String evaluate(Numbers numbers) {
        String response = "";
        if ("x".equals(operation)) {
            response += numbers.getX() + " x " + numbers.getY() + " = " + (numbers.getX() * numbers.getY());
        } else {
            response += numbers.getX() + " + " + numbers.getY() + " = " + (numbers.getX() + numbers.getY());
        }
        System.err.println(response);
        return response;
    }
}
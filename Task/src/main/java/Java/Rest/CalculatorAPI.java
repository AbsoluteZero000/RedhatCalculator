package Java.Rest;

import java.util.*;
import javax.ejb.*;
import Java.models.Calculations;
import Java.Service.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Stateless
@ApplicationPath("/api")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CalculatorAPI extends Application{
    CalculationService calc = new CalculationService();

    @Path("/calc")
    @POST
    public Response createCalculation(int num1, int num2, String operation) {

    Response.ResponseBuilder builder = null;
    Calculations calculation = new Calculations(num1,num2,operation);
    int result = calc.createCalculation(calculation);

    if(result == Integer.MIN_VALUE)
    	return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("the operation you sent doesn't exist").build();

    builder = Response.ok("result = " + result);
    return builder.build();
    }

    @Path("/calculations")
    @GET
    public List<Calculations> getCalculations(){
    	return calc.getCalculations();
    }

}

package Java.Rest;

import java.util.*;
import javax.ejb.*;
import Java.models.Calculations;
import Java.Service.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;


@Stateless
@Path("/")
public class CalculatorAPI{
    CalculationService calc = new CalculationService();

    @Path("calc")
    @POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response createCalculation(Calculations calculation) {

    Response.ResponseBuilder builder = null;
    int result = calc.createCalculation(calculation);

    if(result == Integer.MIN_VALUE)
    	return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("the operation you sent doesn't exist").build();

    builder = Response.ok("result = " + result);
    return builder.build();
    }

    @Path("calculations")
    @GET
    @Produces({"application/json"})
    public List<Calculations> getCalculations(){
    	return calc.getCalculations();
    }

}

package Java.Rest;

import java.util.*;
import javax.ejb.*;
import javax.inject.Inject;
import Java.Models.Calculations;
import Java.Service.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/")
public class CalculatorAPI {
    @Inject
    CalculationService calc = new CalculationService();

    @GET
    @Path("test")
    public String hey() {
        return "Running";
    }

    @Path("calc")
    @POST
    public Object createCalculation(Calculations calculation) throws Exception {
    	System.out.println(calculation.getNumber1());
    	System.out.println(calculation.getNumber2());
    	System.out.println(calculation.getOperation());
        Result result;
        try {
            result = calc.createCalculation(calculation);
        } catch (Exception e) {
            return (e.getMessage());
        }
        return result;
    }

    @Path("calculations")
    @GET
    public List<Calculations> getCalculations() {
        return calc.getCalculations();
    }

}

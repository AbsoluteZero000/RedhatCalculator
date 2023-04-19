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
        return "test";
    }

    @Path("calc")
    @POST
    public Object createCalculation(Calculations calculation) throws Exception {

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

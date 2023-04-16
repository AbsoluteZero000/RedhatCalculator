package Java.Rest;

import java.util.*;
import javax.ejb.*;
import Java.models.Calculations;
import Java.Service.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Stateless
@Path("/")
public class CalculatorAPI {
    CalculationService calc = new CalculationService();

    @Path("calc/{num1}/{num2}/{operation}")
    @POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public String createCalculation(Calculations calculation) {

        int result = calc.createCalculation(calculation);
        return ("Result = " + result);
    }

    @Path("calculations")
    @GET
    @Produces({ "application/json" })
    public List<Calculations> getCalculations() {
        return calc.getCalculations();
    }

}

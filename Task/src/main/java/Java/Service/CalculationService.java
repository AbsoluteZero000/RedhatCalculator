package Java.Service;
import Java.models.Calculations;
import java.util.*;

import javax.persistence.*;

public class CalculationService {

    @PersistenceContext
    private EntityManager em;

    public int createCalculation(Calculations calculation)
    {
        int result = 0;

        if (calculation.getOperation().equals("+")){
            result = calculation.getFirstArgument() + calculation.getSecondArgument();
        }
        else if(calculation.getOperation().equals("-")){
            result = calculation.getFirstArgument() - calculation.getSecondArgument();
        }
        else if(calculation.getOperation().equals("*")){
            result = calculation.getFirstArgument() * calculation.getSecondArgument();
        }
        else if(calculation.getOperation().equals("/")){
            result = calculation.getFirstArgument() / calculation.getSecondArgument();
        }
        else{
            return Integer.MIN_VALUE;
        }

        em.persist(calculation);
        return result;
    }


    public List<Calculations> getCalculations()
    {
        TypedQuery<Calculations> query = em.createQuery("select * from Calculations", Calculations.class);
        return query.getResultList();
    }
}

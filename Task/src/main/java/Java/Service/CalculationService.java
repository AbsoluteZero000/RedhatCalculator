package Java.Service;
import Java.Models.Calculations;
import java.util.*;

import javax.persistence.*;

public class CalculationService {

    @PersistenceContext
    private EntityManager em;

    public CalculationService(){}

    public float createCalculation(Calculations calculation) throws Exception
    {
        float result = 0;

        if (calculation.getOperation().equals("+")){
            result = calculation.getNumber1() + calculation.getNumber2();
        }
        else if(calculation.getOperation().equals("-")){
            result = calculation.getNumber1() - calculation.getNumber2();
        }
        else if(calculation.getOperation().equals("*")){
            result = calculation.getNumber1() * calculation.getNumber2();
        }
        else if(calculation.getOperation().equals("/")){
            result = calculation.getNumber1() / calculation.getNumber2();
        }
        else{
            throw new IllegalArgumentException("Failed Operation");
        }

        //em.persist(calculation);
        return result;
    }


    public List<Calculations> getCalculations()
    {
        TypedQuery<Calculations> query = em.createQuery("select c from Calculations c", Calculations.class);
        return query.getResultList();
    }
}

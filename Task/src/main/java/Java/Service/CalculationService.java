package Java.Service;

import Java.Models.Calculations;
import java.util.*;

import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless
public class CalculationService {

    @PersistenceContext
    private EntityManager em;

    public CalculationService() {
    }

    public Result createCalculation(Calculations calculation) throws Exception {
        double result = 0;

        if (calculation.getOperation().equals("+")) {
            result = calculation.getNumber1() + calculation.getNumber2();
        } else if (calculation.getOperation().equals("-")) {
            result = calculation.getNumber1() - calculation.getNumber2();
        } else if (calculation.getOperation().equals("*")) {
            result = calculation.getNumber1() * calculation.getNumber2();
        } else if (calculation.getOperation().equals("/")) {
            result = (double)calculation.getNumber1() / calculation.getNumber2();
        } else {
            throw new IllegalArgumentException("Failed Operation");
        }

        em.persist(calculation);
        return new Result(result);
    }

    public List<Calculations> getCalculations() {
        TypedQuery<Calculations> query = em.createQuery("select c from Calculations c", Calculations.class);
        return query.getResultList();
    }
}

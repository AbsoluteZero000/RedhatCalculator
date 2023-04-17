package Java.Models;
import javax.persistence.*;

@Entity
public class Calculations {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private int number1;
    private int number2;
    private String operation;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getNumber1() {
        return number1;
    }
    public void setNumber1(int number1) {
        this.number1 = number1;
    }
    public int getNumber2() {
        return number2;
    }
    public void setNumber2(int number2) {
        this.number2 = number2;
    }
    public String getOperation() {
        return operation;
    }
    public void setOperation(String operation) {
        this.operation = operation;
	}
}

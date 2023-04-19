package Java.Models;
import javax.persistence.*;

@Entity
public class Calculations {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private int Number1;
    private int Number2;
    private String Operation;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getNumber1() {
        return Number1;
    }
    public void setNumber1(int Number1) {
        this.Number1 = Number1;
    }
    public int getNumber2() {
        return Number2;
    }
    public void setNumber2(int Number2) {
        this.Number2 = Number2;
    }
    public String getOperation() {
        return Operation;
    }
    public void setOperation(String Operation) {
        this.Operation = Operation;
	}
}

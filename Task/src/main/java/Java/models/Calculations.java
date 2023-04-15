package Java.models;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Calculations {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotNull
	private int Number1;
	@NotNull
	private int Number2;
	@NotNull
	private String Operation;

	public Calculations(int num1, int num2, String op) {
		Number1 = num1;
		Number2 = num2;
		Operation = op;
	}

	public int getFirstArgument(){
		return Number1;
	}

	public int getSecondArgument(){
		return Number2;
	}

	public String getOperation(){
		return Operation;
	}

	public void setFirstArgument(int num1){
		Number1 = num1;
	}

	public void setSecondArgument(int num2){
		Number2 = num2;
	}

	public void setOperation(String op){
		Operation = op;
	}
}

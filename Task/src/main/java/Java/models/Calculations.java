package Java.models;
import javax.persistence.*;

@Entity
public class Calculations {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int Number1;
	private int Number2;
	private String Operation;

	public Calculations(int Number1, int Number2, String Operation){
		this.Number1 = Number1;
		this.Number2 = Number2;
		this.Operation = Operation;
	}
	public Calculations(){}
	public int getFirstArgument(){
		return this.Number1;
	}

	public int getSecondArgument(){
		return this.Number2;
	}

	public String getOperation(){
		return this.Operation;
	}

	public void setFirstArgument(int Number1){
		this.Number1 = Number1;
	}

	public void setSecondArgument(int Number2){
		this.Number2 = Number2;
	}

	public void setOperation(String Operation){
		this.Operation = Operation;
	}
}

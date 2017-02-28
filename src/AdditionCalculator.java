/**
 * Basic Calculator having add functionality.
 * 
 * @author Shahbaz.Alam
 *
 */
public class AdditionCalculator {
	private int num1;
	private int num2;
	
	public AdditionCalculator(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
	
	public int add(){
		return num1 + num2;
	}

}

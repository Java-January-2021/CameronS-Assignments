
public class Calculator {
	private double input1;
	private double input2;
	private char operator;
	private double output;
	
	@SuppressWarnings("unused")
	private Calculator(double input1,char operator, double input2) {
		this.input1 = input1;
		this.input2 = input2;
		this.operator = operator;
	}
	public Calculator() {
	}
	public double getInput1() {
		return this.input1;
	}
	public void setInput1(double input1) {
		this.input1 = input1;
	}
	public double getInput2() {
		return this.input2;
	}
	public void setInput2(double input2) {
		this.input2 = input2;
	}
	public Character getOperator() {
		return this.operator;
	}
	public void setOperator(char operator) {
		this.operator = operator;
	}
	
	public void performOperation() {
		if(this.operator == '+') {
			this.output = this.getInput1() + this.getInput2();
		}
		else if(this.operator == '-') {
			this.output = this.getInput1() - this.getInput2();
		}
		else {
			System.out.println("Calculator only performs addition and subtraction");
		}
		
	}
	
	public void getOutput() {
		System.out.println(this.output);
	}
}

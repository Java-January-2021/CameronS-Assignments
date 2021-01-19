
public class CalculatorController {
 public static void main(String[] args) {
	 Calculator c = new Calculator();
	    c.setInput1(10.5);
	    c.setInput2(5.2);
	    c.setOperator('*');
	    c.performOperation();
	    c.getOutput();
	    c.setOperator('+');
	    c.performOperation();
	    c.getOutput();
	    c.setOperator('-');
	    c.performOperation();
	    c.getOutput();
}
}

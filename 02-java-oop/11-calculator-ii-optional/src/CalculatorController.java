
public class CalculatorController {

	public static void main(String[] args) {
		Calculator calc = new Calculator();
		calc.performOperation(10.5);
		calc.performOperation("+");
		calc.performOperation(5.2);
		calc.performOperation("*");
		calc.performOperation(10);
		calc.performOperation("=");
		calc.getOutput();
	}
}

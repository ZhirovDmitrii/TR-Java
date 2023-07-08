import java.util.Arrays;
import java.util.List;

import telran.view.InputOutput;
import telran.view.Item;

public class CalculatorItem implements Item{
	protected InputOutput inOut;
	protected CalculatorClient calcClient;
	
	public CalculatorItem(InputOutput inOut, CalculatorClient calcClient) {
		super();
		this.inOut = inOut;
		this.calcClient = calcClient;
	}

	@Override
	public String displayedName() {
		return "Arithmatic calculator";
	}

	@Override
	public void perform() {
		List<String> operators = Arrays.asList("+", "-", "*", "/");
		
		String operation = inOut.inputString("Enter the operator from " + operators, operators);
		if(operation == null)
			return;
		
		Integer operand01 = inOut.inputInteger("First operand");
		if(operand01 == null)
			return;
		
		Integer operand02 = inOut.inputInteger("Second operand");
		if(operand02 == null)
			return;
		
		inOut.outputLine(calcClient.calculate(operand01, operand02, operation));
	}

}

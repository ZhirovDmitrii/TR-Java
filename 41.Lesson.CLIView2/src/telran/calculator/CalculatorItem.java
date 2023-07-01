package telran.calculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

import telran.view.InputOutput;
import telran.view.Item;

public class CalculatorItem implements Item{

	static Map<String, BinaryOperator<Integer>> mapOperations;
	static
	{
		mapOperations = new HashMap<>();
		mapOperations.put("+", (o1, o2) -> o1 + o2);
		mapOperations.put("*", (o1, o2) -> o1 * o2);
		mapOperations.put("-", (o1, o2) -> o1 - o2);
		mapOperations.put("/", (o1, o2) -> o2 == 0 ? null : o1 / o2);
	}
	
	// for perform()
	InputOutput inOut;
	public CalculatorItem(InputOutput inOut) {
		super();
		this.inOut = inOut;
	}

//	=============================================
	
	@Override
	public String displayedName() {
		return "Integer numbers calculator";
	}

	@Override
	public void perform() {
		Integer op1 = inOut.inputInteger("Enter first operand");
		if(op1 == null)
			return;
		
		Integer op2 = inOut.inputInteger("Enter second operand");
		if(op2 == null)
			return;
		
		String operator = inOut.inputString("Enter operator from " + mapOperations.keySet(),
				new ArrayList<>(mapOperations.keySet())); 	// there is work String inputString(String prompt, List<String> options);
		if(operator == null)
			return;
		
		inOut.outputLine(mapOperations.get(operator).apply(op1, op2));
	}

}

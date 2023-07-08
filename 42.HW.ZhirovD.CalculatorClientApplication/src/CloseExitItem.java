
import telran.view.InputOutput;

public class CloseExitItem extends CalculatorItem{

	public CloseExitItem(InputOutput inOut, CalculatorClient calcClient) {
		super(inOut, calcClient);
	}
	
	@Override
	public String displayedName() {
		return "Close/Exit";
	}
	
	@Override
	public void perform() {
		try {
			calcClient.close();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	@Override
	public boolean isExit() {
		return true;
	}
}

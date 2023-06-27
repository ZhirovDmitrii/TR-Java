package telran.view;

public class ExitItem implements Item{

	@Override
	public String displayedName() {
		return "Exit";
	}

	@Override
	public void perform() {
	}
	
	// need for exit (overwrite)
	public boolean isExit() {
		return true;
	}

}

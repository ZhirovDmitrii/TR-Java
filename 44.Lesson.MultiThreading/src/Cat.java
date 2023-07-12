
public class Cat implements Runnable{

	String name;
	char gender;
	int nMeow;
	
	public Cat(String name, char gender, int nMeow) {
		super();
		this.name = name;
		this.gender = gender;
		this.nMeow = nMeow;
	}

	@Override
	public void run() {
		for(int i = 0; i < nMeow; i++) {
			if(gender == 'm') {
				System.out.println("Cat " + name + " say meow");
			} else {
				System.out.println("Pussy cat " + name + " say meow");
			}
			
			try {
				Thread.sleep(1000);	// 1 sec
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
		
	}

}

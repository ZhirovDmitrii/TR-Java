
public class FPVariables {
	static int x = 10;
	static int y = 20;
	
	public static void main(String[] args) {
		Operation op = () -> x+y;
		System.out.println(op.calculate());	// 30
		
		op = () -> {
			x = 30;
			return x+y;
		};
		System.out.println(op.calculate());	// 50
		
		int num = 100;
		int num01 = 500;
		op = () -> num01 + num;
		System.out.println(op.calculate());	// 600
		
		op = () -> {
//			num = 30;	// WRONG!!! num is final (auto final)
			return num+num01;
		};
//		num01 = 10000;	// ---||---
		System.out.println(op.calculate());
	}
	
	
}

interface Operation{
	int calculate();
}
package machine;

public class MachineAppl {

	public static void main(String[] args) {
		Machine[] array = 
			{
					new Computer(),
					new Laptop(),
					new Phone()
			};
		
		for(int i=0; i<array.length; i++)
		{
			if(array[i] instanceof Laptop)
				((Laptop)array[i]).office();
			if(array[i] instanceof IGame)
				((IGame)array[i]).games();
		}
		
		System.out.println(IOffice.str);
		System.out.println(IOffice.str1);
	}

}
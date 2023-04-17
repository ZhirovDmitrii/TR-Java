
public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person pers1 = new Person("Dima", 28, true);
		Employee pers2 = new Employee("Dima", 20, false, "Red", 300);
		Person pers3 = new Person("Mitya", 27, true);
		Child pers4 = new Child("Eugeniya", 12, false, "Yeah");
		Employee pers5 = new Employee("Dima", 20, false, "Red Bull", 300);
		
		System.out.println(pers4);
		
		Person[] array = {pers1, pers2, pers3, pers4, pers5};
		for(int i =0; i < array.length; i++)
		{
			System.out.println(array[i]);
			
			int days = 31;
			if(array[i] instanceof Employee)
			{
				System.out.println(((Employee)array[i]).computeSalary(days));
			}
		}	
	}
}
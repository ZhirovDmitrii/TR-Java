package repeat;


public class PersonAppl {
	public static void main(String[] args) {
		int res = 0;
		
		Person p1 = new Person("Dima", 28, true);
		Child c1 = new Child("Kirill", 10, false, "#1");
		Employee e1 = new Employee("Gleb", 30, true, "LTD", 30);
		Employee e2 = new Employee("Oleg", 31, false, "LTD", 31);
		Employee e3 = new Employee("Alex", 32, false, "DTL", 40);	
		
		Person[] array = {p1, c1, e1, e2, e3};
		
		for(int i = 0; i < array.length; i++) {
			if(array[i] instanceof Employee)
				res += ((Employee)array[i]).computeSalary(i);
		}
		
		System.out.println("the total salary of all employeers = " + res);
	}
}

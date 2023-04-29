package telran.employees.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import telran.employees.dto.Programmer;

public class ProgrammersMaps implements IProgrammer {
	private HashMap<Integer, Programmer> programmers;

	public ProgrammersMaps() {
		this.programmers = new HashMap<>();
	}

	@Override
	public boolean addProgrammer(Programmer programmer) {
		if (programmer != null)
			// if == null - added
			// if != null - not added
			return programmers.putIfAbsent(programmer.getId(), programmer) == null;
		throw new IllegalArgumentException("Argument cannot be null");
	}

	@Override
	public boolean removeProgrammer(int id) {
		// if id == null - not removed - FALSE
		// if id != null - return value, value != null - TRUE
		return programmers.remove(id) != null;
	}

	@Override
	public Programmer getProgrammerData(int id) {
		return programmers.get(id);
	}

	@Override
	public boolean addNewTechnology(int id, String technology) {
		if (technology == null || technology.isBlank())
			throw new IllegalArgumentException("Argument cannot be null or blank");

//		if(programmers.get(id) != null) {
//			programmers.get(id).getTechnologies().add(technology);
//			return true;
//		}
//		else
//			return false;

		Programmer programmer = programmers.get(id); // take id
		if (programmer != null)
			// take technology by ID and check if exist technology
			return programmer.getTechnologies().add(technology);
		return false;
	}

	@Override
	public boolean removeTechnology(int id, String technology) {
		if (technology == null || technology.isBlank())
			throw new IllegalArgumentException("Argument cannot be null or blank");
		
		Programmer programmer = programmers.get(id);
		if(programmer != null)
			return programmer.getTechnologies().remove(technology);
		return false;
	}
	
	@Override
	public boolean updateSalary(int id, int salary) {
		if(salary <= 0)
			throw new IllegalArgumentException("Salary must be more 0");
		
		Programmer programmer = programmers.get(id);
		if(programmer != null)
			programmer.setSalary(salary);
		return true;
	}

	@Override
	public List<Programmer> getProgrammersWithTechnology(String technology) {
		if (technology == null || technology.isBlank())
			throw new IllegalArgumentException("Argument cannot be nullor blank");
		
		List<Programmer> res = new ArrayList<>();	// empty List
		for(Programmer programmer: programmers.values()) {
			// values() - return array exists all values
			// take technology from array technologies, check if exist, and add in LIST 
			if(programmer.getTechnologies().contains(technology))
				res.add(programmer);
		}
		return res;
	}

	@Override
	public List<Programmer> getProgrammersWithSalaries(int salaryFrom, int salaryTo) {
		int min = Math.min(salaryFrom, salaryTo);
		int max = Math.max(salaryTo, salaryFrom);
		
		List<Programmer> res = new ArrayList<>();
		for(Programmer programmer: programmers.values()) {
			int salary = programmer.getSalary();
			if(salary >= min && salary < max)
				res.add(programmer);
		}
		return res;
	}

}

package repeat2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import repeat1.Programmer;

public class ProgrammersMaps implements IProgrammer {
	HashMap<Integer, Programmer> programmers;

	public ProgrammersMaps(HashMap<Integer, Programmer> programmers) {
		super();
		this.programmers = new HashMap<>();
	}

	@SuppressWarnings("null")
	@Override
	public boolean addProgrammer(Programmer programmer) {
		return programmers.putIfAbsent(programmer.getId(), programmer) == null;
	}

	@Override
	public boolean removeProgrammer(int id) {
		return programmers.remove(id) != null;
	}

	@Override
	public Programmer getProgrammerData(int id) {
		return programmers.get(id);
	}

	@Override
	public boolean addNewTechnology(int id, String technology) {
		Programmer p = programmers.get(id);
		return p.getTechnology().add(technology);
	}

	@Override
	public boolean removeTechnology(int id, String technology) {
		Programmer p = programmers.get(id);
		return p.getTechnology().remove(technology);
	}

	@Override
	public List<Programmer> getProgrammersWithTechnology(String technology) {
		List<Programmer> l = new ArrayList<>();
		for (Programmer p : programmers.values()) {
			if (p.getTechnology().contains(technology))
				l.add(p);
		}
		return l;
	}

	@Override
	public List<Programmer> getProgrammersWithSalaries(int salaryFrom, int salaryTo) {
		int min = Math.min(salaryFrom, salaryTo);
		int max = Math.max(salaryTo, salaryFrom);
		
		List<Programmer> l = new ArrayList<>();
		for(Programmer programmer: programmers.values()) {
			int salary = programmer.getSalary();
			if(salary >= min && salary < max)
				l.add(programmer);
		}
		return l;
	}

	@Override
	public boolean updateSalary(int id, int salary) {
		Programmer p = programmers.get(id);
		p.setSalary(salary);
		return true;
	}

}

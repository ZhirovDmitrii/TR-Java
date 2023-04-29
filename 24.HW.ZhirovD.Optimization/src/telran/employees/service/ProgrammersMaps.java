package telran.employees.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import telran.employees.dto.Programmer;

public class ProgrammersMaps implements IProgrammer {
	private HashMap<Integer, Programmer> programmers;
	private HashMap<String, List<Programmer>> techProgrammers; // key - technology, value - list of programmers
	private TreeMap<Integer, List<Programmer>> salaryProgrammers; // key - salary, value - list of programmers

	public ProgrammersMaps() {
		this.programmers = new HashMap<>();
		this.techProgrammers = new HashMap<>();
		this.salaryProgrammers = new TreeMap<>();
	}

//	===== Work with add to SALARY MAP =====
	private void addSalaryProgrammers(Programmer programmer) {
		int salary = programmer.getSalary();
		List<Programmer> list = salaryProgrammers.getOrDefault(salary, new ArrayList<>());
		list.add(programmer);
		salaryProgrammers.putIfAbsent(salary, list);
	}

	private void removeSalaryProgrammers(Programmer programmer) {
		salaryProgrammers.get(programmer.getSalary()).remove(programmer);
	}

//	===== Work with add to TECHNOLOGY MAP =====
	private void addTechProgrammers(Programmer programmer) {
		// take technology and iterate over each of them
		for (String technology : programmer.getTechnologies()) {
			addTechToMap(programmer, technology);
		}
	}

	private void addTechToMap(Programmer programmer, String technology) {
		// get value by tech, if not exist - give empty list
		List<Programmer> list = techProgrammers.getOrDefault(technology, new ArrayList<>());
		list.add(programmer);
		techProgrammers.putIfAbsent(technology, list);
	}

	private void removeTechProgrammers(Programmer programmer) {
		for (String technology : programmer.getTechnologies()) {
			techProgrammers.get(technology).remove(programmer);
		}
	}

	private void removeTechnologyFromMap(Programmer programmer, String tech) {
		techProgrammers.get(tech).remove(programmer);
	}
//	============================================================

	@Override
	public boolean addProgrammer(Programmer programmer) {
		if (programmer == null)
			throw new IllegalArgumentException("Argument cannot be null");
		// if == null - added
		// if != null - not added
		boolean res = programmers.putIfAbsent(programmer.getId(), programmer) == null;
		if (res) {
			addTechProgrammers(programmer); // add to technology map
			addSalaryProgrammers(programmer); // add to salary map
		}
		return res;
	}

	@Override
	public boolean removeProgrammer(int id) {
		// if id == null - not removed - FALSE
		// if id != null - return value, value != null - TRUE
		Programmer programmer = programmers.remove(id);
		boolean res = programmer != null;
		if (res) {
			removeTechProgrammers(programmer);
			removeSalaryProgrammers(programmer);
		}
		return res;
	}

	@Override
	public Programmer getProgrammerData(int id) {
		return programmers.get(id);
	}

	@Override
	public boolean addNewTechnology(int id, String technology) {
		if (technology == null || technology.isBlank())
			throw new IllegalArgumentException("Argument cannot be null or blank");

		Programmer programmer = programmers.get(id); // take id
		boolean res = programmer != null;
		if (res) {
			// take technology by ID and check if exist technology
			programmer.getTechnologies().add(technology);
			addTechToMap(programmer, technology);
		}
		return res;
	}

	@Override
	public boolean removeTechnology(int id, String technology) {
		if (technology == null || technology.isBlank())
			throw new IllegalArgumentException("Argument cannot be null or blank");

		Programmer programmer = programmers.get(id);
		boolean res = programmer != null;
		if (res) {
			programmer.getTechnologies().remove(technology);
			removeTechnologyFromMap(programmer, technology);
		}
		return res;
	}

	@Override
	public boolean updateSalary(int id, int salary) {
		if (salary <= 0)
			throw new IllegalArgumentException("Salary must be more 0");

		Programmer programmer = programmers.get(id);
		if (programmer == null || salary <= 0)
			return false;
		
		removeSalaryProgrammers(programmer);
		programmer.setSalary(salary);
		addSalaryProgrammers(programmer);
		return true;
	}

	@Override
	public List<Programmer> getProgrammersWithTechnology(String technology) {
		if (technology == null || technology.isBlank())
			throw new IllegalArgumentException("Argument cannot be nullor blank");

		return techProgrammers.getOrDefault(technology, new ArrayList<>());

	}

	@Override
	public List<Programmer> getProgrammersWithSalaries(int salaryFrom, int salaryTo) {
		int min = Math.min(salaryFrom, salaryTo);
		int max = Math.max(salaryTo, salaryFrom);

		List<Programmer> res = new ArrayList<>();
		Collection<List<Programmer>> list = salaryProgrammers.subMap(min, max).values();

		if (list != null) {
			for (List<Programmer> lists : list)
				res.addAll(lists);
		}
		return res;
	}
}

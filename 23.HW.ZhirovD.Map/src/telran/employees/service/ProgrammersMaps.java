package telran.employees.service;

import java.util.HashMap;
import java.util.List;

import telran.employees.dto.Programmer;

public class ProgrammersMaps implements IProgrammer{
	private HashMap<Integer, Programmer> programmers;
	public ProgrammersMaps(HashMap<Integer, Programmer> programmers) {
		super();
		this.programmers = programmers;
	}

	@Override
	public boolean addProgrammer(Programmer programmer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeProgrammer(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Programmer getProgrammerData(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addNewTechnology(int id, String technology) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeTechnology(int id, String technology) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Programmer> getProgrammersWithTechnology(String technology) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Programmer> getProgrammersWithSalaries(int salaryFrom, int salaryTo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateSalary(int id, int salary) {
		// TODO Auto-generated method stub
		return false;
	}
	
}

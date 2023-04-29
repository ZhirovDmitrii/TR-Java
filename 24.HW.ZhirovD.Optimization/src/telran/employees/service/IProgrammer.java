package telran.employees.service;

import java.util.List;

import telran.employees.dto.Programmer;

public interface IProgrammer {
	public boolean addProgrammer(Programmer programmer);	// if added - true, if already exist - false
	public boolean removeProgrammer(int id);	// true removed, if no employee - false
	public Programmer getProgrammerData(int id);
	public boolean addNewTechnology(int id, String technology);	// technology - regular string such as "java, web, c++"
	public boolean removeTechnology(int id, String technology);	
	public List<Programmer> getProgrammersWithTechnology(String technology);	// returns list of programmers using the given technology
	public List<Programmer> getProgrammersWithSalaries(int salaryFrom, int salaryTo);	// return list of Programmers with salary in the given range
	public boolean updateSalary(int id, int salary);
}

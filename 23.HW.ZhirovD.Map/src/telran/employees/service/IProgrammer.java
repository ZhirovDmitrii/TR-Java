package telran.employees.service;

import java.util.List;

import telran.employees.dto.Programmer;

public interface IProgrammer {
	public boolean addProgrammer(Programmer programmer);
	public boolean removeProgrammer(int id);
	public Programmer getProgrammerData(int id);
	public boolean addNewTechnology(int id, String technology);
	public boolean removeTechnology(int id, String technology);
	public List<Programmer> getProgrammersWithTechnology(String technology);
	public List<Programmer> getProgrammersWithSalaries(int salaryFrom, int salaryTo);
	public boolean updateSalary(int id, int salary);
}

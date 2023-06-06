package repeat2;

import java.util.List;

import repeat1.Programmer;

public interface IProgrammer {
	boolean addProgrammer(Programmer programmer); // if add - true, if already exist - false

	boolean removeProgrammer(int id); // true - if removed, false - if no employee

	Programmer getProgrammerData(int id);

	boolean addNewTechnology(int id, String technology); // technology - regular string such as "java" "web" "c++"

	boolean removeTechnology(int id, String technology);

	List<Programmer> getProgrammersWithTechnology(String technology); // returns list of programmers using the given
																		// technology

	List<Programmer> getProgrammersWithSalaries(int salaryFrom, int salaryTo); // return list of programmers with salary
																				// in the given range

	boolean updateSalary(int id, int salary);

}

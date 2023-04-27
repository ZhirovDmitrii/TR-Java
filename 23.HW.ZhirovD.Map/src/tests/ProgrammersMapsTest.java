package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import telran.employees.dto.Programmer;
import telran.employees.service.IProgrammer;
import telran.employees.service.ProgrammersMaps;


class ProgrammersMapsTest {
	private static final String CPP = "c++";
	private static final String JAVA = "java";
	private static final String SQL = "SQL";
	private static final String WEB = "web";
	private static final String PYTHON = "python";
	private static final String ANDROID = "android";
	@SuppressWarnings("unused")
	private static final int ID_NEW = 11111;
	
	String[] tech1 = {CPP, JAVA, SQL};
	String[] tech2 = {CPP, WEB};
	String[] tech3 = {PYTHON, ANDROID, JAVA};
	
	int salary1 = 10000;
	int salary2 = 5000;
	int salary3 = 15000;
	
	Programmer progr1 = new Programmer(1, "name1", tech1, salary1);
	Programmer progr2 = new Programmer(2, "name2", tech2, salary2);
	Programmer progr3 = new Programmer(3, "name3", tech3, salary3);
	Programmer[] programmers = {progr1, progr2, progr3};
	
	IProgrammer programmerService;
	
//	===============================================================

	@BeforeEach
	void setUp() throws Exception {
		programmerService = new ProgrammersMaps();
		for(Programmer programmer : programmers)
			programmerService.addProgrammer(programmer);
	}

	@Test
	void testAddProgrammer() {
		assertTrue(programmerService.addProgrammer(
				new Programmer(ID_NEW, "name", new String[] {JAVA}, 2000)));
		assertFalse(programmerService.addProgrammer(progr1));
		assertNotNull(programmerService.getProgrammerData(ID_NEW));
		
		
	}

	@Test
	void testRemoveProgrammer() {
		assertTrue(programmerService.removeProgrammer(2)); // progr2
		assertNull(programmerService.getProgrammerData(2));
	}

	@Test
	void testAddNewTechnology() {
		assertFalse(progr1.getTechnologies().contains(WEB));
		programmerService.addNewTechnology(1, WEB);
		assertTrue(progr1.getTechnologies().contains(WEB));
	}

	@Test
	void testRemoveTechnology() {
		assertTrue(progr1.getTechnologies().contains(CPP));
		programmerService.removeTechnology(1, CPP);
		assertFalse(progr1.getTechnologies().contains(CPP));
	}

	@Test
	void testUpdateSalary() {
		Programmer programmer = programmerService.getProgrammerData(3);
		assertEquals(salary3, programmer.getSalary());
		programmerService.updateSalary(3, salary1);
		assertEquals(salary1, programmer.getSalary());
		
	}

	@Test
	void testGetProgrammersWithTechnology() {
		List<Programmer> programmer = programmerService.getProgrammersWithTechnology(PYTHON);
		assertTrue(programmer.contains(progr3));
		assertFalse(programmer.contains(progr1));
		assertFalse(programmer.contains(progr2));
	}

	@Test
	void testGetProgrammersWithSalaries() {
		List<Programmer> programmer = programmerService.getProgrammersWithSalaries(salary2, salary3);
		assertTrue(programmer.contains(progr1));
		assertTrue(programmer.contains(progr2));
		assertFalse(programmer.contains(progr3));
	}

}

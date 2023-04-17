import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MemoryServiceTest {
	byte[] array;

	@Test
	void test() {
		long m = System.currentTimeMillis();
		Runtime runtime = Runtime.getRuntime();
		System.out.printf("max free memory %d, max available memory %d, total memory %d", runtime.freeMemory(),
				runtime.maxMemory(), runtime.totalMemory());

		int max = MemoryService.getMaxAvailableMemory();
		array = new byte[max];

		array = null;
		boolean flag = false;

		try {
			array = new byte[max + 1];
		} catch (OutOfMemoryError e) {
			flag = true;
		}
		assertTrue(flag);
		System.out.println((double) (System.currentTimeMillis() - m));
	}
}

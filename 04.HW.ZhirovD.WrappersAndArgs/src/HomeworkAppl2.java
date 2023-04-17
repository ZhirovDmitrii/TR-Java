
public class HomeworkAppl2 {
	public static void main(String[] args) {
		// NOT USE SWITCH AND NO MORE 3 IF-ELSE

		// initialization arrays
		String[] array = { "byte", "short", "int", "double", "float", "long", "char" };

		String[] minValues = { String.valueOf(Byte.MAX_VALUE), String.valueOf(Short.MIN_VALUE),
				String.valueOf((int) Character.MIN_VALUE), String.valueOf(Integer.MIN_VALUE),
				String.valueOf(Long.MIN_VALUE), String.valueOf(Float.MIN_VALUE), String.valueOf(Double.MIN_VALUE) };

		String[] maxValues = { String.valueOf(Byte.MAX_VALUE), String.valueOf(Short.MAX_VALUE),
				String.valueOf((int) Character.MAX_VALUE), String.valueOf(Integer.MAX_VALUE),
				String.valueOf(Long.MAX_VALUE), String.valueOf(Float.MAX_VALUE), String.valueOf(Double.MAX_VALUE) };

		// Exception if don't send anything
		if (args.length == 0) {
			args = array;
		}

		// Exception if send anything
		for (int i = 0; i < args.length; i++) // into our array args
		{
			boolean flag = false; // not found arguments

			for (int j = 0; j < array.length; j++) // go into our 'array' and found needed name from 'args'
			{
				if (args[i].equals(array[j])) {
					System.out.println(array[j] + "\t" + minValues[j] + "\t" + maxValues[j]); // print information
					flag = true; // replace flag
					break; // not to go next element arrays
				}
			}

			// Exception if send information with wrong
			if (!flag)
				System.out.println(args[i] + " is Wrong type");
		}
	}
}
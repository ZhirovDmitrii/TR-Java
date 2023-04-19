package repeat;

public class MemoryService {
	public static int getMaxAvailableMemory() {
//		int res = Integer.MAX_VALUE;
//		while(true)
//		{
//			try
//			{
//				byte[] temp = new byte[res];
//				return res;
//			} catch (OutOfMemoryError e)
//			{
//				res--;
//			}
//		}

		int max = Integer.MAX_VALUE;
		int min = 0;
		int mid = 0;
		byte[] temp = null;

		while (min <= max) {
			mid = min + (max - min) / 2;
			try {
				temp = new byte[mid];
				min = mid + 1;
			} catch (OutOfMemoryError e) {
				max = mid - 1;
			}
			finally {
				if(temp != null)
					temp = null;
			}
		}
		return max;
	}
}
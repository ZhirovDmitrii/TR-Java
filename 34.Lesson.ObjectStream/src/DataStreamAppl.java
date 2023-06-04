import java.io.*;

public class DataStreamAppl {
	static final String fileName = "invoice.data";
	static final String[] goods = { "meat", "milk", "choko", "bread", "juice" };
	static final int[] counts = { 12, 8, 13, 1, 3 };
	static final double[] prices = { 69.90, 12.3, 22.5, 15, 5.9 };

	public static void main(String[] args) throws IOException {
		try(DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fileName))))
		{
			for(int i =0; i < prices.length; i++) {
				out.writeUTF(goods[i]);
				out.writeInt(counts[i]);
				out.writeDouble(prices[i]);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		@SuppressWarnings("resource")
		DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(fileName)));
		String good;
		int count;
		double price;
		double totalCost = 0;
		
		try {
			while(true) {
				good = in.readUTF();
				count = in.readInt();
				price = in.readDouble();
				
				System.out.printf("Your ordered %d units of %s at $%.2f\n", count, good, price);
				
				totalCost += count * price;
			}
		}catch (EOFException e) {
			// TODO: handle exception
		}
		System.out.println("Total sum is $" + totalCost);
	}

}

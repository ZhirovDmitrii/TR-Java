
public class StringBuilderAppl {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		System.out.println(sb.length());	// 0 - filled cells
		System.out.println(sb.capacity());	// 16 - array length
		
		StringBuilder sb1 = new StringBuilder(50);
		System.out.println(sb1.length());	// 0
		System.out.println(sb1.capacity());	// 50
		
		StringBuilder sb2 = new StringBuilder("Hello");
		System.out.println(sb2.length());	// 5
		System.out.println(sb2.capacity());	// 21 (5+16)
	
		//===//
		// append()
		sb = new StringBuilder(1);
		sb.append("He");
		System.out.println(sb.capacity());	// 2*2
		
		sb.append("Hello");
		System.out.println(sb.capacity());	// 5*2
		
		System.out.println(sb.toString());	// HeHello
	
		sb.append(true);					// HeHellotrue
		System.out.println(sb.length()); 	// 11
		System.out.println(sb.capacity());	// 11*2
	
		// ensureCapacity()
		sb.ensureCapacity(1000);			// capacity increase to 1000
		System.out.println(sb.capacity());	// 1000
		
		sb.ensureCapacity(5);				// NO
		System.out.println(sb.capacity());	// 1000
		
		// deleteCharAt()
		sb.deleteCharAt(0);			// eHellotrue (- H)
		System.out.println(sb);		
		System.out.println(sb.capacity());	// 1000
		
		// delete()
		sb.delete(1, 5);		//eotrue (- Hell)
		System.out.println(sb);
		
		// insert()
		sb.insert(3, 1);		// eot1rue
		System.out.println(sb);
	
		// reverse()
		System.out.println(sb.reverse());	// eur1toe
		
		// trimToSize()
		sb.trimToSize();
		System.out.println(sb.length());	// 7
		System.out.println(sb.capacity());	// 7
	
	}
}
import java.net.*;

import org.xbill.DNS.*;

public class EmailTester {
	
	public static void main(String[] args) throws TextParseException, UnknownHostException {
		InetAddress addr = Address.getByName("gmail.com");
		System.out.println("addr = "+addr);
		
		Record [] records = new Lookup("gmail.com", Type.ANY).run();
		System.out.println("println = "+records.length);
		for (int i = 0; i < records.length; i++) {
//			MXRecord mx = (MXRecord) records[i];
//			System.out.println("Host " + mx.getTarget() + " has preference " + mx.getPriority());
			System.out.println(" records[i] = "+ records[i]);
		}

	}

}

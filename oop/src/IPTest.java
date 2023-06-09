import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPTest {

	public static void main(String[] args) throws UnknownHostException {
		InetAddress localIP = InetAddress.getLocalHost(); //InetAddress.getByAddress(null)
		String localAddress = localIP.getHostAddress();
		System.out.println(localAddress);
		
		InetAddress ip = InetAddress.getByName("www.naver.com"); 
		System.out.println(ip.getHostAddress());
	}
}

package is.mynote.unit7;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author neal
 */
public class InetAddressTest {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getLocalHost();
            System.out.println(address);
            address = InetAddress.getByName("www.baidu.com");
            System.out.println(address);
            InetAddress[] sw = InetAddress.getAllByName("www.alibaba.com");
            for (InetAddress aSw : sw) {
                System.out.println(aSw);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}

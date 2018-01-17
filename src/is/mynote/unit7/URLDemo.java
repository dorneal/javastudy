package is.mynote.unit7;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author neal
 */
public class URLDemo {
    public static void main(String[] args) throws MalformedURLException {
        URL hp = new URL("http://www.HerbSchildt.com/");
        System.out.println("Protocol:"+hp.getProtocol());
        System.out.println("Port:"+hp.getPort());
        System.out.println("Host:"+hp.getHost());
        System.out.println("File:"+hp.getFile());
        System.out.println("Ext:"+hp.toExternalForm());
    }
}

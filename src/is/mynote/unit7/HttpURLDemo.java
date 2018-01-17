package is.mynote.unit7;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author neal
 */
public class HttpURLDemo {
    public static void main(String[] args) throws IOException {
        URL hp = new URL("http://www.baidu.com");

        HttpURLConnection conn = (HttpURLConnection) hp.openConnection();

        System.out.println("Request method is " + conn.getRequestMethod());
        System.out.println("Response code is " + conn.getResponseCode());
        System.out.println("Response Message is " + conn.getResponseMessage());

        // Get a list of the header fields and a set of the header keys.
        Map<String, List<String>> map = conn.getHeaderFields();
        Set<String> field = map.keySet();
        System.out.println("\n Here is the header:");
        for (String k : field) {
            System.out.println("Key: " + k +
                    " Value: " + map.get(k));
        }
    }
}

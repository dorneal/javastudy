package is.mynote.unit7;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

/**
 * @author neal
 */
public class UCDemo {
    public static void main(String[] args) throws IOException {
        int c;
        URL hp = new URL("0000");
        URLConnection conn = hp.openConnection();
        conn.setRequestProperty("User-Agent"
                , "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.108 Safari/537.36");
        //get Date
        long d = conn.getDate();
        System.out.println(d==0?"No date information.":"Date"+new Date(d));

        // get content type
        System.out.println("Content-Type: "+conn.getContentType());

        // get expiration date
        d = conn.getExpiration();
        System.out.println(d==0?"No expiration information.":"Expires "+new Date(d));

        // get last-modified date
        d = conn.getLastModified();
        System.out.println(d==0?"No last-modified information.":"Last-Modified "+new Date(d));

        // get content length
        long len = conn.getContentLength();
        System.out.println(len==-1?"Content-length unavailable.":"Content-length "+len);

        if (len!=0){
            System.out.println("====== Content ======");
            InputStream inputStream = conn.getInputStream();
            while ((c=inputStream.read())!=-1){
                System.out.print((char)c);
            }
            inputStream.close();
        }else {
            System.out.println("No content available");
        }
    }
}

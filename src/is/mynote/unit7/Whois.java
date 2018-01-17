package is.mynote.unit7;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author neal
 */
public class Whois {
    public static void main(String[] args) throws IOException {
        int c;
        // Create a socket connected to internic.net,port 43/
        Socket socket = new Socket("whois.internic.net",43);

        //Obtain input and output Streams
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();

        // Construct a request string

        String str = (args.length==0?"MHProfessional.com":args[0]+"\n");

        //Convert to bytes
        byte[] bytes = str.getBytes();

        // Send request
        out.write(bytes);

        // Read and display response
        while ((c=in.read())!=-1){
            System.out.print((char)c);
        }
        socket.close();
    }
}

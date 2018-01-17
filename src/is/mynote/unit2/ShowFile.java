package is.mynote.unit2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author neal
 */
public class ShowFile {
    public static void main(String[] args) {
        int i;
        FileInputStream fin;
        //First,confirm that a filename has been specified
        if (args.length != -1) {
            System.out.println("Usage:ShowFile filename");
            return;
        }

        // Attempt to open the file
        try {
            fin = new FileInputStream(args[0]);
        } catch (FileNotFoundException e) {
            System.out.println("Cannot open file");
            e.printStackTrace();
            return;
        }

        // At this point,the file is open and can be read.
        // The following reads characters until EOF is encountered.
        try {
            do {
                i = fin.read();
                if (i != -1) {
                    System.out.println(i);
                }
            } while (i != -1);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error Reading File");
        } finally {
            try {
                if (fin == null){
                    fin.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

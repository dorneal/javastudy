package is.mynote.unit4;

import java.io.*;

public class IOTest {
    public static void main(String[] args) throws IOException {
        String str = "中国人";
        /*
        FileOutputStream fos = new FileOutputStream("1.txt");
        fos.write(str.getBytes("UTF-8"));
        fos.close();
         */
        /*
        FileWriter fw = new FileWriter("1.txt");
        fw.write(str);
        fw.close();
        */

        PrintWriter pw = new PrintWriter("1.txt", "UTF-8");
        pw.write(str);
        pw.close();

       /* FileReader fr = new FileReader("1.txt");
        char[] buf = new char[1024];
        int len = fr.read(buf);
        String myStr = new String(buf, 0, len);
        System.out.println(myStr); */

        /*FileInputStream fis = new FileInputStream("1.txt");
        byte[] buf = new byte[1024];
        int len = fis.read(buf);
        String myStr = new String(buf, 0, len);
        System.out.println(myStr);*/

        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("1.txt"), "UTF-8"));
        String myStr = br.readLine();
        br.close();
        System.out.println(myStr);
    }
}

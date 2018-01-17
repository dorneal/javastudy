package is.mynote.unit1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BRReadlines {
    public static void main(String[] args) throws IOException {
        // create a bufferedReader using System in
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        do {
            str = br.readLine();
            System.out.println(str);
        } while (!"stop".equals(str));
    }
}

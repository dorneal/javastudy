package is.mynote.unit1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 简易文本编辑器
 *
 * @author neal
 */
public class TinyEdit {
    public static void main(String[] args) throws IOException {
        //create a bufferedReader using System in
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = new String[100];
        System.out.println("Enter lines of text");
        System.out.println("Enter 'stop' to quit");
        for (int i = 0; i < str.length; i++) {
            str[i] = br.readLine();
            if ("stop".equals(str[i])) {
                break;
            }
        }
        System.out.println("\nHere is your file:");
        for (String aStr : str) {
            if ("stop".equals(aStr)) {
                break;
            }
            System.out.println(aStr);
        }
    }
}

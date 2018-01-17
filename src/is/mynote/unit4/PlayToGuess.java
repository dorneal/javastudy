package is.mynote.unit4;

import java.util.Random;
        import java.util.Scanner;

/**
 * 猜字游戏
 *
 * @author neal
 */
public class PlayToGuess {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = new Random().nextInt(1000);
        int myNum;
        do {
            myNum = input.nextInt();
            if (myNum > num) {
                System.out.println("大了");
            } else if (myNum < num) {
                System.out.println("小了");
            } else if (myNum == num) {
                System.out.println("恭喜答对了！！");
                break;
            }
        } while (myNum != 0);
    }
}

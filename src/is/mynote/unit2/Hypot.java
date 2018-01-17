package is.mynote.unit2;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 * 计算三角形面积，使用静态导入，使用时，可不指定静态类名
 *
 * @author neal
 */
public class Hypot {
    public static void main(String[] args) {
        double side1, side2;
        double hypot;
        side1 = 3.0;
        side2 = 4.0;
        //Here ,sqrt() and pow() can be called by themselves,
        // without their class name.
        hypot = sqrt(pow(side1, side2) + pow(side2, 2));
        System.out.println("Given sides of lengths " +
                side1 + " and " + side2 + " the hypotenuse is " + hypot);
    }
}

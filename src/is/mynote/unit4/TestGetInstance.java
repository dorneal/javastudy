package is.mynote.unit4;

import sun.reflect.Reflection;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


/**
 * 创建对象的几种方式
 * 1.直接new
 * 2.通过反射newInstance()方法
 * 3.clone方法
 * 4.使用反序列化得到
 *
 * @author neal
 */
public class TestGetInstance {
    public static void main(String[] args) {
        Reflection reflection = new Reflection();
        try {
            //使用反射
            Reflection ob = reflection.getClass().newInstance();
            System.out.println(ob.getClass().getSimpleName());
            //使用反序列化
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(""));
            Reflection reflection2 = (Reflection) ois.readObject();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
}

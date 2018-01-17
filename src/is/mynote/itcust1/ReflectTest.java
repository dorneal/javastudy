package is.mynote.itcust1;

import java.lang.reflect.*;
import java.util.Arrays;

/**
 * @author neal
 */
public class ReflectTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        String str = "abc";
        Class cls1 = str.getClass();
        Class cls2 = String.class;
        Class cls3 = Class.forName("java.lang.String");
        System.out.println(cls1 == cls2);
        System.out.println(cls1 == cls3);
        System.out.println(cls3 == cls2);

        // 是否是基本类型
        System.out.println(cls1.isPrimitive());
        System.out.println(int.class.isPrimitive());
        System.out.println(int.class == Integer.class);
        System.out.println(int.class == Integer.TYPE);
        System.out.println(int[].class.isPrimitive());
        System.out.println(int[].class.isArray());

        //获取具体的构造方法
        Constructor constructor1 = String.class.getConstructor(StringBuffer.class);
        String str2 = (String) constructor1.newInstance(new StringBuffer("abc"));
        System.out.println(str2.charAt(2));

        ReflectPoint reflectPoint = new ReflectPoint(2, 4);
        Field fieldY = reflectPoint.getClass().getField("y");
        // x属于私有成员变量
        Field fieldX = reflectPoint.getClass().getDeclaredField("x");
        System.out.println(fieldY.get(reflectPoint));
        // 暴力反射
        fieldX.setAccessible(true);
        System.out.println(fieldX.get(reflectPoint));

        changeStrValue(reflectPoint);
        System.out.println(reflectPoint);

        //得到方法，调用
        Method methodCharAt = String.class.getMethod("charAt", int.class);
        System.out.println(methodCharAt.invoke(str, 1));

        //通过反射调用其他类的main方法
        TestArgument.main(new String[]{"23", "23425", "235"});

        String startingClassName = args[0];
        Method mainMethod = Class.forName(startingClassName).getMethod("main", String[].class);
        mainMethod.invoke(null, (Object) new String[]{"111", "222", "333"});


        //数组与Object的关系及其反射类型
        int[] a1 = new int[3];
        int[] a2 = new int[4];
        int[][] a3 = new int[2][3];
        String[] a4 = new String[]{"a", "b", "c"};
        System.out.println(a1.getClass() == a2.getClass());
        System.out.println(a1.getClass().getName());
        System.out.println(a1.getClass().getSuperclass().getName());
        System.out.println(a4.getClass().getName());
        System.out.println(a4.getClass().getSuperclass().getName());
        System.out.println(a3.getClass().getName());
        System.out.println(a3.getClass().getSuperclass().getName());

        Object object1 = a1;
        Object object2 = a2;
        Object object3 = a3;
        Object[] object4 = a3;
        Object[] object5 = a4;
        System.out.println(Arrays.asList(a3));
        System.out.println(Arrays.asList(a4));


        Object object = null;
        printObject("x,yx,x");
    }

    private static void printObject(Object object) {
        Class cls1 = object.getClass();
        if (cls1.isArray()) {
            int length = Array.getLength(object);
            for (int i = 0; i < length; i++) {
                System.out.println(Array.get(object, i));
            }
        } else {
            System.out.println(object);
        }
    }

    /**
     * 通过反射替换掉类成员变量的值
     *
     * @param obj 对象
     * @throws IllegalAccessException IllegalAccessException
     */
    private static void changeStrValue(Object obj) throws IllegalAccessException {
        Field[] fields = obj.getClass().getFields();
        for (Field f : fields) {
            // if(f.getType().equals(String.class))
            if (f.getType() == String.class) {
                String string = (String) f.get(obj);
                String newStr = string.replace("b", "a");
                f.set(obj, newStr);
            }
        }
    }
}

class TestArgument {
    public static void main(String[] args) {
        for (String s : args) {
            System.out.print(s + "\t");
        }
    }
}

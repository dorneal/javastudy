package is.mynote.itcust2;

import java.util.Date;

/**
 * 类加载机制
 *
 * @author Neal
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        System.out.println(
                ClassLoaderTest.class.getClassLoader().getClass().getName()
        );
        System.out.println("---------------------------");
        ClassLoader loader = ClassLoaderTest.class.getClassLoader();
        while (loader != null) {
            System.out.println(loader.getClass().getName());
            loader = loader.getParent();
        }
        System.out.println(loader);
        System.out.println(new ClassLoaderAttachment().toString());
        Class<?> classLoaderAttachment = new MyClassLoader("config").findClass("ClassLoaderAttachment");

        Date cla = (Date) classLoaderAttachment.newInstance();
        System.out.println(cla.toString());
    }
}

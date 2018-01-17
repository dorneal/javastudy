package is.mynote.itcust1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Properties;

/**
 * @author neal
 */
public class ReflectTest2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        // 一定要记住要用完整的路径
//        InputStream ips = new FileInputStream("config/config.properties");
        /* InputStream ips = ReflectPoint.class.getResourceAsStream("config.properties");*/
        
        // 使用类加载器加载classpath下面的文件
        InputStream ips = ReflectPoint.class.getClassLoader().getResourceAsStream("config.properties");
        Properties properties = new Properties();
        properties.load(ips);
        ips.close();


        String className = properties.getProperty("className");
        Collection collection = (Collection) Class.forName(className).newInstance();

//        Collection collection = new HashSet();
        ReflectPoint pt1 = new ReflectPoint(3, 3);
        ReflectPoint pt2 = new ReflectPoint(5, 5);
        ReflectPoint pt3 = new ReflectPoint(3, 3);
        collection.add(pt1);
        collection.add(pt1);
        collection.add(pt2);
        collection.add(pt3);
        System.out.println(collection.size());
    }
}

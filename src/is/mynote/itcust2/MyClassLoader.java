package is.mynote.itcust2;

import java.io.*;

/**
 * 自定义类加载器
 *
 * @author Neal
 */
public class MyClassLoader extends ClassLoader {
    private String classDir;

    public MyClassLoader() {

    }

    public MyClassLoader(String classDir) {
        this.classDir = classDir;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String srcPath = args[0];
        String destDir = args[1];
        FileInputStream fis = new FileInputStream(srcPath);
        String destFileName = srcPath.substring(srcPath.lastIndexOf('\\') + 1);
        String destPath = destDir + "\\" + destFileName;
        FileOutputStream fos = new FileOutputStream(destPath);
        try {
            cypher(fis, fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void cypher(InputStream is, OutputStream ops) throws IOException {
        int b;
        while ((b = is.read()) != -1) {
            ops.write(b ^ 0xff);
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String classFileName = classDir + "\\" + name + ".class";
        try {
            FileInputStream fis = new FileInputStream(classFileName);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            cypher(fis, baos);
            fis.close();
            byte[] bytes = baos.toByteArray();
            return defineClass(bytes, 0, bytes.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }
}

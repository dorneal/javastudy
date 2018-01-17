package is.mynote.unit1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public final class Session4 {

    /**
     * 工具类的方法都是静态方式访问的，因此构造器私有，不允许创建对象（）
     */
    private Session4() {
        throw new AssertionError();
    }

    /**
     * 统计字符在文件中出现的次数
     *
     * @param fileName 文件名
     * @param word     需要查找的字符名
     * @return 出现次数
     */
    public static int countWordFile(String fileName, String word) {
        int counter = 0;
        try (FileReader fr = new FileReader(fileName)) {
            try (BufferedReader br = new BufferedReader(fr)) {
                String line = null;
                while ((line = br.readLine()) != null) {
                    int index = -1;
                    while (line.length() >= word.length() && (index = line.indexOf(word)) >= 0) {
                        counter++;
                        line = line.substring(index + word.length());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return counter;
    }
}

package is.mynote.util;

import com.github.javafaker.Faker;

import java.util.Locale;

/**
 * 使用JavaFaker伪造假数据,用于测试网站表单等
 *
 * @author neal
 */
public class FakerTest {
    public static void main(String[] args) {
        //支持构造方法指定国家语言
        Faker faker = new Faker(new Locale("zh-cn"));
        String name = faker.name().fullName();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        System.out.println(faker.book().title());
        System.out.println(name);
        System.out.println(faker.cat().name());
        System.out.println(firstName);
        System.out.println(lastName);
        String streetAddress = faker.address().streetAddress();
        System.out.println(streetAddress);
    }
}

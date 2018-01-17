package is.mynote.itcust2;

/**
 * 注解测试类
 *
 * @author Neal
 */
@ItcustAnnotation
public class AnnotationTest {
    public static void main(String[] args) {
        if (AnnotationTest.class.isAnnotationPresent(ItcustAnnotation.class)) {
            ItcustAnnotation itcustAnnotation = AnnotationTest.class.getAnnotation(ItcustAnnotation.class);
            System.out.println(itcustAnnotation);
        }
    }
}

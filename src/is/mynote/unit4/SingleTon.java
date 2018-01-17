package is.mynote.unit4;

/**
 * 单例模式之饿汉模式
 *
 * @author neal
 */
public class SingleTon {
    private static SingleTon singleTon = new SingleTon();

    private SingleTon() {
    }

    public static SingleTon getObj() {
        return singleTon;
    }
}

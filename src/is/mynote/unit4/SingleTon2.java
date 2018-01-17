package is.mynote.unit4;

/**
 * 单例模式之懒汉模式
 *
 * @author neal
 */
public class SingleTon2 {
    private static SingleTon2 instance = null;

    private SingleTon2() {

    }

    public static SingleTon2 getIntance() {
        if (instance == null) {
            return new SingleTon2();
        }
        return instance;
    }
}

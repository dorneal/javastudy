package is.mynote.unit1;

/**
 * 动态方法调度
 * <p>
 * 原则：超类引用变量可以指向子类对象
 * 原理：java根据在调用时所引用对象的类型来判定调用哪个版本的方法,
 * 因此，这个决定是在运行时做出的，如果引用不同类型的对象，就会调用不同版本的
 * 重写方法，换句话说，是当前正在引用对象的类型（而不是引用变量的类型）决定了
 * 将要执行哪个版本的重写方法。
 * </p>
 *
 * @author neal
 */


class Session1 {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();

        A r;
        r = a;
        r.callme();

        r = b;
        r.callme();

        r = c;
        r.callme();
    }
}

class A {
    void callme() {
        System.out.println("Inside A's callme method");
    }
}

class B extends A {
    @Override
    void callme() {
        System.out.println("Inside B's callme method");
    }
}

class C extends A {
    @Override
    void callme() {
        System.out.println("Inside C's callme method");
    }
}

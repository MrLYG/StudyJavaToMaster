package phase1.module2;

public class AnonymousInterfaceTest {
    public static void test(AnonymousInterface ai){
        ai.show();
    }
    public static void main(String[] args) {
        AnonymousInterfaceTest.test(new AnonymousInterface() {
            public void show() {
                System.out.println("回调模式--匿名内部类1");
            }
        });

        AnonymousInterfaceTest.test(new AnonymousIntefaceImpl());

        AnonymousInterface ait = new AnonymousInterface() {
            public void show() {
                System.out.println("回调模式--匿名内部类2");
            }
        };
        AnonymousInterfaceTest.test(ait);

        //java8 lamda表达式
        AnonymousInterface aitL = () -> System.out.println("lamda表达式");
        AnonymousInterfaceTest.test(aitL);
    }
}

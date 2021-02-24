package phase1.module2.InnerClass;

/**
 * 编程实现普通内部类的定义和使用
 */
public class NormalOuter {
    private int cnt = 1;
    //定义普通内部类
    public class NormalInner{
        private int ia = 2;
        private int cnt = 3;
        public NormalInner(){
            System.out.println("普通内部类的构造方法");
        }
        public void show(){
            System.out.println("外部类的变量cnt为"+cnt);
            System.out.println("内部类的变量ia为"+ia);
        }
        public void show2(int cnt){
            System.out.println("局部变量cnt"+cnt);
            System.out.println("内部类变量cnt"+this.cnt);
            System.out.println("外部类变量cnt"+NormalOuter.this.cnt);
        }
    }
}

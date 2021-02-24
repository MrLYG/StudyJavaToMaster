package lagou.phase1.module2.InnerClass;

public class NormalOuterTest {
    public static void main(String[] args) {
        NormalOuter no = new NormalOuter();
        NormalOuter.NormalInner ni = no.new NormalInner();
        ni.show2(4);
    }
}

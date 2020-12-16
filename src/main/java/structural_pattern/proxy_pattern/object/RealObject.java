package structural_pattern.proxy_pattern.object;

public class RealObject implements Logic {
    @Override
    public void logic1() {
        System.out.println("Logic1 executed in RealObject");
    }

    @Override
    public void logic2() {
        System.out.println("Logic2 executed in RealObject");
    }
}

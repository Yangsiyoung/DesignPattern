package structural_pattern.proxy_pattern.object;

public class ProxyObject implements Logic {

    private Logic logic = null;

    @Override
    public void logic1() {
        checkInstance();
        // do Something
        logic.logic1();
        // do Something
    }

    @Override
    public void logic2() {
        checkInstance();
        // do Something
        logic.logic2();
        // do Something
    }

    // Laze Loading 을 위함
    private void checkInstance() {
        if(this.logic == null) {
            this.logic = new RealObject();
        }
    }
}

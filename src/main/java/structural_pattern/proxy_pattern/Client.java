package structural_pattern.proxy_pattern;

import structural_pattern.proxy_pattern.factory.ObjectFactory;
import structural_pattern.proxy_pattern.object.Logic;

public class Client {
    public void doSomethingWithObject() {
        // 사용하는 입장에서는 프록시인지 실제 클래스인지 몰라도 사용가능
        Logic logic = ObjectFactory.createObject();
        logic.logic1();
        logic.logic2();
    }
}

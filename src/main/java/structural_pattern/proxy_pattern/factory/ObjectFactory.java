package structural_pattern.proxy_pattern.factory;

import structural_pattern.proxy_pattern.object.Logic;
import structural_pattern.proxy_pattern.object.ProxyObject;

public class ObjectFactory {
    public static Logic createObject() {
        return new ProxyObject();
    }
}

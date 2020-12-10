package factory_pattern.chapter01.chapter1_5_1;

import factory_pattern.chapter01.Greeting;
import factory_pattern.chapter01.Korean;

public class Factory1_5_1 {
    public static Greeting getGreetingInstance() {
        return new Korean();
    }
}

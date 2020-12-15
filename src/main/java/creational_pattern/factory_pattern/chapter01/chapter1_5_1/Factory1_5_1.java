package creational_pattern.factory_pattern.chapter01.chapter1_5_1;

import creational_pattern.factory_pattern.chapter01.Greeting;
import creational_pattern.factory_pattern.chapter01.Korean;

public class Factory1_5_1 {
    public static Greeting getGreetingInstance() {
        return new Korean();
    }
}

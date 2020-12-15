package creational_pattern.factory_pattern.chapter01.chapter1_5_4;

import creational_pattern.factory_pattern.chapter01.Greeting;

public class English implements Greeting {
    @Override
    public String text() {
        return "Hello";
    }
}

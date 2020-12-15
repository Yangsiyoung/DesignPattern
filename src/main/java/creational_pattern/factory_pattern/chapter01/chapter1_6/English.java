package creational_pattern.factory_pattern.chapter01.chapter1_6;

import creational_pattern.factory_pattern.chapter01.Greeting;

public class English implements Greeting {
    @Override
    public String text() {
        return "Hello";
    }
}

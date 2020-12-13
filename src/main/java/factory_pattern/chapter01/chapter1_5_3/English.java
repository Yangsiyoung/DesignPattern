package factory_pattern.chapter01.chapter1_5_3;

import factory_pattern.chapter01.Greeting;

public class English implements Greeting {
    @Override
    public String text() {
        return "Hello";
    }
}

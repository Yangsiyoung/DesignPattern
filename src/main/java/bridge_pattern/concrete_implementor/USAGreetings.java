package bridge_pattern.concrete_implementor;

import bridge_pattern.implementor.Greetings;

public class USAGreetings implements Greetings {
    @Override
    public String greet() {
        return "Hello";
    }
}

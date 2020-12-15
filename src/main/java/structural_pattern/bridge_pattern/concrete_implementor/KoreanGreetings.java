package structural_pattern.bridge_pattern.concrete_implementor;

import structural_pattern.bridge_pattern.implementor.Greetings;

public class KoreanGreetings implements Greetings {
    @Override
    public String greet() {
        return "안녕하세요";
    }
}

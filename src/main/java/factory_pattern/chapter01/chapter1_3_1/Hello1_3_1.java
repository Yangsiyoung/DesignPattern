package factory_pattern.chapter01.chapter1_3_1;

import factory_pattern.chapter01.Greeting;
import factory_pattern.original.Korean;

public class Hello1_3_1 {
    private Greeting object;

    public Hello1_3_1(Greeting object) {
        this.object = object;
    }

    public String greeting() {
        return object.text();
    }
}

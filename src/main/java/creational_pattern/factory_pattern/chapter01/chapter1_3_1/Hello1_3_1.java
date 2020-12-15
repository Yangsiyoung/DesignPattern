package creational_pattern.factory_pattern.chapter01.chapter1_3_1;

import creational_pattern.factory_pattern.chapter01.Greeting;

public class Hello1_3_1 {
    private Greeting object;

    public Hello1_3_1(Greeting object) {
        this.object = object;
    }

    public String greeting() {
        return object.text();
    }
}

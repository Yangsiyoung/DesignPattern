package factory_pattern.chapter01.chapter1_5_2;

import factory_pattern.chapter01.chapter1_5_1.Factory1_5_1;

public class Hello1_5_2 {
    public String greeting() {
        return Factory1_5_1.getGreetingInstance().text();
    }
}

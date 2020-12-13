package factory_pattern.chapter01.chapter1_6;

import factory_pattern.chapter01.Greeting;
import factory_pattern.chapter01.Korean;

public class Hello {
    public static final String KOREAN = "ko";
    public static final String ENGLISH = "en";

    public String greeting(String type) {
        return factory(type).text();
    }

    public static Greeting factory(String type) {
        switch (type) {
            case KOREAN:
                return new Korean();
            case ENGLISH:
                return new English();
            default:
                return new Korean();
        }
    }
}

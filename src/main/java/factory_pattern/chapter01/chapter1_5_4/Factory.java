package factory_pattern.chapter01.chapter1_5_4;

import factory_pattern.chapter01.Greeting;
import factory_pattern.chapter01.Korean;

public class Factory {
    public static final String KOREAN = "ko";
    public static final String ENGLISH = "en";

    public static Greeting getGreetingInstance(String type) {
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

package creational_pattern.factory_pattern.chapter01.chapter1_5_3;

import creational_pattern.factory_pattern.chapter01.Greeting;
import creational_pattern.factory_pattern.chapter01.Korean;

public class Factory {
    public static Greeting getGreetingInstance(String type) {
        switch (type) {
            case "ko":
                return new Korean();
            case "en":
                return new English();
            default:
                return new Korean();
        }
    }
}

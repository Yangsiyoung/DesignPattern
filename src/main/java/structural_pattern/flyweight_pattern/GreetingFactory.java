package structural_pattern.flyweight_pattern;

import java.util.HashMap;
import java.util.Map;

public class GreetingFactory {
    public static Map<String, Greeting> greetingMap = new HashMap<>();

    public static Greeting createGreeting(String type) {
        Greeting greeting = null;
        if(!greetingMap.containsKey(type)) {
            greeting = findGreetingType(type);
            greetingMap.put(type, greeting);
        }else {
            greeting = greetingMap.get(type);
        }
        return greeting;
    }

    private static Greeting findGreetingType(String type) {
        Greeting greeting = null;
        switch (type) {
            case Greeting.KOREAN:
                greeting = new KoreanGreeting();
                break;
            case Greeting.ENGLISH:
                greeting = new EnglishGreeting();
                break;
            default:
                greeting = new KoreanGreeting();
                break;
        }
        return greeting;
    }
}

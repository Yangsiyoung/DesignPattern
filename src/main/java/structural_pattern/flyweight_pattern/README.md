플라이웨이트 패턴
===============
매번 객체를 생성해서 쓰는 것이 아닌 객체를 공유해서 사용하는 패턴  
어떤 로직을 실행하기 위한 팩토리 클래스가 있고, 그 클래스에디 관련 로직의 객체를  
Map, List 등의 변수에 값을 담아두고 재사용하는 것  

* Greeting.java
```
public interface Greeting {
    public static final String KOREAN = "ko";
    public static final String ENGLISH = "en";

    String greet();
}
```

* EnglishGreeting.java
```
public class EnglishGreeting implements Greeting{
    @Override
    public String greet() {
        return "Hello";
    }
}
```

* KoreanGreeting.java
```
public class KoreanGreeting implements Greeting{
    @Override
    public String greet() {
        return "안녕하세요";
    }
}
```

* GreetingFactory.java
```
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
```

* Unit Test
```
@Test
public void testFlyweightPattern() {
    assertEquals("안녕하세요", GreetingFactory.createGreeting(Greeting.KOREAN).greet());
    assertEquals("Hello", GreetingFactory.createGreeting(Greeting.ENGLISH).greet());
    assertSame(GreetingFactory.createGreeting(Greeting.KOREAN), GreetingFactory.greetingMap.get(Greeting.KOREAN));
    assertSame(GreetingFactory.createGreeting(Greeting.ENGLISH), GreetingFactory.greetingMap.get(Greeting.ENGLISH));
}
```
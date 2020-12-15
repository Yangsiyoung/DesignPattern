브리지 패턴
==========
브리지 패턴은 객체의 확장성을 향상하기 위한 패턴  
객체에서 동작관련 부분과 확장을 위한 부분을 분리 함  
다른 용어로는 핸들 패턴, 구현부 패턴으로 부르기도 함  

상속을 통해서 기능을 확장하게되면 결합이 강해지고 불필요한 메서드도 같이 상속되어 무거워진다.  
이럴때 브리지 패턴을 사용한다.  

그리고 브리지 패턴을 적용하려면 아래 4가지의 구성 요소가 필요하다. 
* Implementor : 확장할 기능의 인터페이스
* ConcreteImplementor : Implementor 를 구현한 기능들
* Abstract : 기능을 확장할 최상위 클래스
* RefinedAbstract : Abstract 를 상속하여 사용하는 자식 클래스

A 라는 클래스를 확장할 필요가 생겨서 브리지 패턴을 적용하게되면,  
A 라는 클래스의 기능을 정리해서 A 는 Abstract 가 되고
확장할 기능을 정리해 Interface 를 만들고  
A 를 확장한 클래스 B, C 에서는 A 에서 확장된 기능을 사용하므로,  
Interface 를 Implements 해서 확장된 기능을 구현하고  
따라서 A 의 기능의 추상화인 Interface 를 구현한 확장된 기능을 사용하는  
자식 클래스들이 생기게 된다.  

말이 어려우니까 코드로 보자.  

* GreetingsMessage.java (Abstract)
```
public abstract class GreetingsMessage {
    protected Greetings greetings;
    abstract public String greet();
}
```

* GlobalGreetingsMessage.java (RefinedAbstract)
```
public class GlobalGreetingsMessage extends GreetingsMessage {

    public GlobalGreetingsMessage(Greetings greetings) {
        this.greetings = greetings;
    }

    @Override
    public String greet() {
        return this.greetings.greet();
    }
}
```

* Greetings.java (Implementor)
```
public interface Greetings {
    public String greet();
}
```

* KoreanGreetings.java (ConcreteImplementor)
```
public class KoreanGreetings implements Greetings {
    @Override
    public String greet() {
        return "안녕하세요";
    }
}
```

* USAGreetings.java (ConcreteImplementor)
```
public class USAGreetings implements Greetings {
    @Override
    public String greet() {
        return "Hello";
    }
}
```

* Unit Test
```
@Test
public void testBridgePattern() {
    KoreanGreetings koreanGreetings = new KoreanGreetings();
    USAGreetings usaGreetings = new USAGreetings();

    GlobalGreetingsMessage koreanGreetingsMessage = new GlobalGreetingsMessage(koreanGreetings);
    GlobalGreetingsMessage usaGreetingsMessage = new GlobalGreetingsMessage(usaGreetings);

    assertEquals(koreanGreetings.greet(), koreanGreetingsMessage.greet());
    assertEquals(usaGreetings.greet(), usaGreetingsMessage.greet());

}
```



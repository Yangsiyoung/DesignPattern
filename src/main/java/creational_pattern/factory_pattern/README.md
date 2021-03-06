팩토리 패턴
===========
객체 생성 시 발생하는 강력한 의존 관계를 보다 느슨하게 하기 위함  

# 기존 코드

* Korean.java
```
public class Korean {
    public String text() {
        return "안녕하세요";
    }
}
```

* Hello.java
```
public class Hello {
    public String greeting() {
        Korean korean = new Korean();
        return korean.text();
    }
}
```

# 강력한 결합
위와 같은 코드는 메서드 내에서 직접 객체를 생성하므로 강력한 결합 관계가 발생한다.  
이렇게 되면 클래스 이름 등이 변경되면 관련 코드를 모두 직접 찾아서 수정해야한다.  
그래서 향후 유연한 코드 확장을 방해하고 변경에 용이하지 않게된다.  

# 의존성 주입
객체 의존성은 내부와 외부적 발생으로 구분한다.  
객체의 관계가 외부적 요인으로 결합되면 이를 의존성 주입이라고 한다.  

## 복합 객체
프로퍼티에 외부객체를 가리키고 있는 객체  
외부로부터 의존관계를 주입받음  
결합도를 낮추기위해 Interface 를 사용하여  
해당 Interface 를 implements 하여 사용하는 객체라면 어떤 객체던  
외부로부터 주입받아 사용할 수 있게 하였음  

* Greeting.java
```
public interface Greeting {
    public String text();
}

```

* Korean.java 
```
public class Korean implements Greeting{
    @Override
    public String text() {
        return "안녕하세요";
    }
}
```

* Hello.java
```
public class Hello1_3_1 {
    private Greeting object;

    public Hello1_3_1(Greeting object) {
        this.object = object;
    }

    public String greeting() {
        return object.text();
    }
}
```

## 생성 위임
객체 생성을 별도의 클래스에 위임하여, 생성 과정을 담당하는 별도의 클래스를 선언하는 것  
코드에서 new 키워드를 통해 직접적으로 객체를 생성함으로써 가지는 강력한 결합도를 낮추기 위함  
일반적으로 **클래스로 분리**하거나, **메서드로 분리**하는 두가지 방법이 있음

# 팩토리 패턴 역할
팩토리 패턴의 클래스는 객체 생성 담당 + 느슨한 결합 관계가 되도록 처리  

## 느슨한 결합
별도의 객체에 필요한 객체를 생성하도록 위임

* Factory.java
```
public class Factory1_5_1 {
    public static Greeting getGreetingInstance() {
        return new Korean();
    }
}
```

* Hello.java
```
public class Hello1_5_2 {
    public String greeting() {
        return Factory1_5_1.getGreetingInstance().text();
    }
}
```

## 클래스 선택

* English.java
```
public class English implements Greeting {
    @Override
    public String text() {
        return "Hello";
    }
}
```

* Korean.java
```
public class Korean implements Greeting{
    @Override
    public String text() {
        return "안녕하세요";
    }
}
```

* Factory.java
```
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
```

* Hello.java
```
public class Hello {
    public String greeting(String type) {
        return Factory.getGreetingInstance(type).text();
    }
}
```

* Unit Test
```
@Test
public void factoryTest() {
    assertEquals("안녕하세요", Factory.getGreetingInstance("ko").text());
    assertEquals("Hello", Factory.getGreetingInstance("en").text());
    assertEquals("안녕하세요", Factory.getGreetingInstance("unknownType").text());
}
```

아래와 같이 타입에 들어가는 문자열을 상수화 시키는 것도 좋은 방법이다.
* Factory.java

```
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
```

* Unit Test
```
@Test
public void factoryTest() {
    assertEquals("안녕하세요", Factory.getGreetingInstance(creational_pattern.factory_pattern.chapter01.chapter1_5_4.Factory.KOREAN).text());
    assertEquals("Hello", Factory.getGreetingInstance(creational_pattern.factory_pattern.chapter01.chapter1_5_4.Factory.ENGLISH).text());
    assertEquals("안녕하세요", Factory.getGreetingInstance("unknownType").text());
}
```

## 단순 팩토리
별도의 Factory 생성을 하지 않고, 자신의 객체에 필요한 객체를 생성하는 전용 메서드 추가하는 방법  
(정적 팩토리 패턴이라고도 부름)

* Hello.java

```
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
```
* Unit Test
```
@Test
public void testGreeting() {
    Hello hello = new Hello();
    assertEquals("안녕하세요", hello.greeting(Hello.KOREAN));
    assertEquals("Hello", hello.greeting(Hello.ENGLISH));
    assertEquals("안녕하세요", hello.greeting("unknown"));
}
```

# 팩토리 패턴의 장점  
1. 생성과 관련된 모든 처리를 별도의 클래스에 위임할 수 있다.  
2. 클래스 이름이 변경되어도 클래스가 생성되는 곳을 하나씩 찾아서 수정할 필요가 없기때문에  
   유연성과 확장성이 개선된다.  
3. 어떤 객체들이 생성될지 모르는 초기 단계 코드에 매우 유용하다.  

# 팩토리 패턴의 단점  
별도의 클래스가 생기기 때문에 관리할 클래스가 늘어난다는 단점이 있다.  


싱글턴 패턴
=========
하나의 객체만 생성하도록 제한하는 패턴  

* 공유 자원 접근
* 여러 시스템이 하나의 자원에 접근할 때
* 유일한 객체가 필요할 때
* 값의 캐시가 필요할 때

new 키워드를 이용해 객체를 생성하는 방법을 원칙적으로 금지함  
new 키워드 대신 객체 생성 메서드 호출로 객체를 생성함  

객체 내부에 참조체가 있어 자신의 객체를 보관하며, 내부적으로 중복 생성을 방지하는 로직(플라이웨이트 패턴)이 있음  
싱글턴은 하나의 객체만 갖도록 보증하지만, 클래스 상속과 복수 객체를 생성할 수 있는 객체지향의 장점을 포기해야 함

# 싱글턴 패턴 적용 예시

* Config.java
```
public class Config {
    private static Config instance = null;

    // 외부에서 new 키워드로 객체를 생성하지 못하게 막음
    protected Config() {
        System.out.println("Config 객체 생성");
    }

    public static Config getInstance() {
        if(instance == null) {
            instance = new Config();
        }
        return instance;
    }
}
```

* Unit Test
```
@Test
public void testSingletonEquality() {
    Config config01 = Config.getInstance();
    Config config02 = Config.getInstance();
    assertSame(config01, config02);
}
```

# 정적 클래스와 싱글턴 패턴 차이
정적 클래스의 경우 Util 클래스들처럼 static 멤버 변수 혹은 메서드로 이루어진 클래스이다. 
싱글턴 패턴은 인스턴스화 되어 메모리에 객체가 올라가지만, 정적 클래스의 경우 인스턴스화 없이 사용가능하다.  


# 싱글턴 패턴의 단점
싱글턴 패턴으로 생성한 자원은 프로그램이 종료될 때까지 메모리에 상주한다.  
따라서 안티 패턴으로 분류하기도 한다.  

# 주의할점
추가적으로 객체의 상태값이 요청마다 달라지는 경우 이를 공유하면 문제가 발생할 수 있다.  
따라서 상태가 없거나(메서드만 존재) 어떤 요청이던간에 동일한 상태를 지니는 경우(불변의 프로퍼티 + 메서드)에만 사용해야한다고 생각한다.  
(스프링에서 Controller, Service, Configuration 등 싱글턴으로 생성되는 빈들의 특징을 생각해보자.)  

아예 싱글턴 패턴으로 생성하는 객체의 프로퍼티는 동적으로 값이 정해지는 것이 아니라면 final 로 선언해버리는 것도 좋을 것 같다.    

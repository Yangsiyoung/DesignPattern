프록시 패턴
=========
실제 클래스에 바로 접근하는 것이 아닌 같은 대리수행 역할을 하는 프록시 클래스를 사용하는 것  
사용하는 클라이언트 입장에서는 실제 클래스를 사용하는 것과 같은 동작의 결과를 받지만  
실제론 프록시 객체(대리자 객체)를 통해 접근하는 것  

프록시는 로직을 직접 구현하여 사용하는 것이 아니라 실제 로직은 실제 클래스를 호출하여 진행하고,  
선처리나, 사용하지 않는 메서드를 알려주거나 혹은 실제로 해당 클래스가 사용될 때까지 객체 생성을 미뤄서  
Lazy Loading 할 때 사용할 수 있음  

실제 클래스의 기능을 사용하되 더 많은 작업을 할 수 있으니까 활용하기에 따라 매우 좋은 패턴이 될 수 있을 것 같다.  

나는 팩토리 패턴을 활용하여 객체를 사용하는 Client 입장에서는 실제 어떤 객체를 반환받아 사용하는지 몰라도  
추상화된 인터페이스를 통해서 사용하도록 예시를 만들어 볼 생각이다.  

* Logic.java
```
public interface Logic {
    void logic1();
    void logic2();
}
```

* RealObject.java
```
public class RealObject implements Logic {
    @Override
    public void logic1() {
        System.out.println("Logic1 executed in RealObject");
    }

    @Override
    public void logic2() {
        System.out.println("Logic2 executed in RealObject");
    }
}
```

* ProxyObject.java
```
public class ProxyObject implements Logic {

    private Logic logic = null;

    @Override
    public void logic1() {
        checkInstance();
        // do Something
        logic.logic1();
        // do Something
    }

    @Override
    public void logic2() {
        checkInstance();
        // do Something
        logic.logic2();
        // do Something
    }

    // Laze Loading 을 위함
    private void checkInstance() {
        if(this.logic == null) {
            this.logic = new RealObject();
        }
    }
}
```

* ObjectFactory.java
```
public class ObjectFactory {
    public static Logic createObject() {
        return new ProxyObject();
    }
}
```

* Client.java
```
public class Client {
    public void doSomethingWithObject() {
        // 사용하는 입장에서는 프록시인지 실제 클래스인지 몰라도 사용가능
        Logic logic = ObjectFactory.createObject();
        logic.logic1();
        logic.logic2();
    }
}
```
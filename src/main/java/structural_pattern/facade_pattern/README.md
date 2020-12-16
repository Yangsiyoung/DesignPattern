파사드 패턴
==========
여러 구현체들을 사용할 때 해당 코드들을 직접 사용하는 것이 아니라 추상화를 해두어  
추상화한 인터페이스를 통해서 구현체들을 사용하는 것  

우리가 자동차를 운전할때 내부 동작원리를 알필요 없이 조작법만 알면 되는 것 처럼    
인터페이스를 구현해두어 내부 구현체들이 바뀌더라도 사용법은 달라지지 않도록 하는  
추상화와 같은 개념이며 이를 위한 방법을 제시함  

예를들어 드라이브를 하는데 차가 있고 내부 엔진이나 핸들이 바뀌어도 조작법이 바뀌지않으므로  
드라이브하는 방법에는 변함이 없음  

* Drive.java
```
public class Drive {
    public static void main(String[] args) {
        Car car = new Car();
        car.goStraight();
        car.goLeft();
        car.goRight();
        car.stop();
    }
}
```

* Car.java
```
public class Car {

    private final Engine engine;
    private final Handle handle;

    public Car() {
        this.engine = new Engine(); // 엔진이 바뀌면 여기만 바꾸면 됨
        this.handle = new Handle(); // 핸들이 바뀌면 여기만 바꾸면 됨
    }

    // 나중에 팩토리 패턴 혹은 팩토리 메서드 패턴 등을 통해 확장할 경우를 대비해 남겨둠
    public Car(Engine engine, Handle handle) {
        this.engine = engine;
        this.handle = handle;
    }

    public void goStraight() {
        engine.run();
        handle.straight();
    }

    public void goLeft(){
        engine.run();
        handle.left();
    }

    public void goRight() {
        engine.run();
        handle.right();
    }

    public void stop() {
        engine.stop();
        handle.straight();
    }
}
```

* Engine.java
```
public class Engine {
    public void run() {
        System.out.println("run Engine");
    }

    public void stop() {
        System.out.println("stop engine");
    }
}
```

* Handle.java
```
public class Handle {

    public void straight() {
        System.out.println("handle straight");
    }

    public void left() {
        System.out.println("handle left");
    }

    public void right() {
        System.out.println("handle right");
    }
}
```
 
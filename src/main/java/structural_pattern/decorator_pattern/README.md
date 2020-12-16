장식자 패턴
=========
객체에 동적 기능을 추가하기위해 구조를 개선하는 패턴  
기존에 공통적인 기능을 뺴둔 인터페이스가 있는데, 거기에 특정 케이스에는 그 공통기능에 좀 더  
기능이 추가되어야할 때가 있다. 이럴때 데코레이터 패턴을 사용하면된다.  

일단 원리는 기존의 공통 기능이 있는 인터페이스가 있고, 여기에 기능을 확장하기위해  
해당 인터페이스를 상속하는 인터페이스를 하나 만들어서 확장된 인터페이스를 사용하는 것 이다.  

그래서 아래의 구성요소가 필요하다.  
* Component : 공통 기능을 정의해둔 인터페이스
* ConcreteComponent : Component 를 구현한 클래스
* Decorator : Component 를 상속한 인터페이스  
* ConcreteDecorator : Decorator 를 구현한 클래스  

코드로 살펴보기전에 예를들어 차가운 음료수에 대해서만 기능을 추상화하여 관리하고 있었는데  
뜨거운(따뜻한??) 음료수에 대한 기능도 제공하려고보니 차가운 음료수 공통 기능 + 추가 기능이 필요해졌다.  
따라서 차가운 음료수 공통 기능 인터페이스를 상속받은 새로운 인터페이스를 만들고 거기에 뜨거운 음료수 전용 공통 기능을  
추상화 했다. 이 인터페이스가 데코레이터가 되는 것 이다.  

* Beverage.java (Component)
```
public abstract class Beverage {
    public static final String LARGE = "L";
    public static final String MEDIUM = "M";
    public static final String SMALL = "S";
    public abstract int price();
    public abstract void orderSize(String size);
}
```

* Coke.java (Concrete Component)
```
public class Coke extends Beverage {

    private String size;

    @Override
    public int price() {
        int price = -1;
        switch (size) {
            case Beverage.LARGE:
                price = 2000;
                break;
            case Beverage.MEDIUM:
                price = 1500;
                break;
            case Beverage.SMALL:
                price = 1000;
                break;
        }
        return price;
    }

    @Override
    public void orderSize(String size) {
        this.size = size;
    }
}
```

* HotBeverage.java (Decorator)
```
public abstract class HotBeverage extends Beverage {
    protected int numberOfSticks;
    public int sticks() {
        return this.numberOfSticks;
    };
    public abstract void setSticks(int numberOfSticks);
}
```

* Americano.java (Concrete Decorator)
```
public class Americano extends HotBeverage {

    private String size;

    @Override
    public void setSticks(int numberOfSticks) {
        this.numberOfSticks = numberOfSticks;
    }

    @Override
    public int price() {
        int price = -1;
        switch (size) {
            case Beverage.LARGE:
                price = 3500;
                break;
            case Beverage.MEDIUM:
                price = 3000;
                break;
            case Beverage.SMALL:
                price = 2500;
                break;
        }
        return price;
    }

    @Override
    public void orderSize(String size) {
        this.size = size;
    }
}
```

* Unit Test
```
@Test
public void testDecoratorPattern() {
    Coke coke = new Coke();
    coke.orderSize(Beverage.MEDIUM);
    assertEquals(1500, coke.price());

    Americano americano = new Americano();
    americano.orderSize(Beverage.LARGE);
    americano.setSticks(5);
    assertEquals(3500, americano.price());
    assertEquals(5, americano.sticks());
}
```

추상 팩토리 패턴
==============
우선 팩토리 메서드 패턴과 추상 팩토리 패턴의 차이는 **추상화된 그룹**이다.  
팩토리 메서드 패턴은 추상 클래스와 하위 클래스 1개로 구성하지만,  
추상 팩토리 패턴은 다형성을 적극적으로 활용하기때문에 다수의 하위 클래스를 생성하고 관리한다.  

다양한 객체 생성 과정에 그룹화가 필요할 때 사용한다.  


# 팩토리 그룹
추상 팩토리 패턴의 특징은 추상화를 통해 그룹을 만들 수 있단 것.  
팩토리 메서드 패턴은 추상화 과정을 적용하지만 단일 그룹이다.  

* Factory.java
```
public abstract class Factory {
    abstract public TireProduct createTire();
    abstract public DoorProduct createDoor();
}
```
* KoreaFactory.java
```
public class KoreaFactory extends Factory {
    @Override
    public TireProduct createTire() {
        return new KoreaTireProduct();
    }

    @Override
    public DoorProduct createDoor() {
        return new KoreaDoorProduct();
    }
}
```
* USAFactory.java
```
public class USAFactory extends Factory{
    @Override
    public TireProduct createTire() {
        return new USATireProduct();
    }

    @Override
    public DoorProduct createDoor() {
        return new USADoorProduct();
    }
}
```
* TireProduct.java
```
public abstract class TireProduct {
    abstract public String makeAssemble();
}
```
* KoreaTireProduct.java
```
public class KoreaTireProduct extends TireProduct{
    @Override
    public String makeAssemble() {
        return "Set KoreaTire";
    }
}
```
* USATireProduct.java
```
public class USATireProduct extends TireProduct {
    @Override
    public String makeAssemble() {
        return "Set USATire";
    }
}
```
* DoorProduct.java
```
public abstract class DoorProduct {
    abstract public String makeAssemble();
}
```
* KoreaDoorProduct.java
```
public class KoreaDoorProduct extends DoorProduct {
    @Override
    public String makeAssemble() {
        return "Set KoreaDoor";
    }
}
```
* USADoorProduct.java
```
public class USADoorProduct extends DoorProduct {
    @Override
    public String makeAssemble() {
        return "Set USADoor";
    }
}
```
* Unit Test
```
@Test
public void testFactory() {
    KoreaFactory koreaFactory = new KoreaFactory();
    USAFactory usaFactory = new USAFactory();

    KoreaTireProduct koreaTireProduct = new KoreaTireProduct();
    KoreaDoorProduct koreaDoorProduct = new KoreaDoorProduct();

    USATireProduct usaTireProduct = new USATireProduct();
    USADoorProduct usaDoorProduct = new USADoorProduct();

    assertEquals(koreaTireProduct.makeAssemble(), koreaFactory.createTire().makeAssemble());
    assertEquals(koreaDoorProduct.makeAssemble(), koreaFactory.createDoor().makeAssemble());
    assertEquals(usaTireProduct.makeAssemble(), usaFactory.createTire().makeAssemble());
    assertEquals(usaDoorProduct.makeAssemble(), usaFactory.createDoor().makeAssemble());
    assertNotEquals(usaTireProduct.makeAssemble(), koreaFactory.createTire().makeAssemble());
    assertNotEquals(usaDoorProduct.makeAssemble(), koreaFactory.createDoor().makeAssemble());
}
```
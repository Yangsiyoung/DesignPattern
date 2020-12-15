팩토리 메서드 패턴
===============
팩토리 패턴과 템플릿 메서드 패턴이 결합된 패턴  
기본적인 기능 구현은 추상 클래스에서 구현하고, 핵심 기능에 대한 메서드를 추상 메서드로 남겨두어  
구현 클래스에 위임하는 템플릿 메서드 패턴과 유사하다.  
(템플릿 메서드 패턴은 공통기능과 핵심기능을 분리하는 즉, 기능에 초점을 두고있다면,  
팩토리 메서드 패턴은 구현 클래스에게 객체생성에 대한 핵심 로직을 위임하는데 초점을 두고 있는게 아닐까??... 아니면.. 말고
왜냐면 일단 팩토리 메서드 패턴은 생성 패턴이니까!!!)  

팩토리 메서드 패턴은 객체 **생성**을 담당하는 클래스를 **추상화** 하여 **선언**과 **구현**을 분리한 패턴  
잘 기억하자, 팩토리 패턴과 팩토리 메서드 패턴의 차이는 **추상화**이다.  


* Factory.java
```
public abstract class Factory {
    public static final String SAMSUNG = "samsung";
    public static final String LG = "lg";

    public final Product create(String modelType) {
        return createProduct(modelType);
    }

    public abstract Product createProduct(String modelType);
}
```

* ProductFactory.java
```
public class ProductFactory extends Factory{
    @Override
    public Product createProduct(String modelType) {
        switch (modelType) {
            case Factory.SAMSUNG:
                return new SamsungProduct();
            case Factory.LG:
                return new LGProduct();
            default:
                return new SamsungProduct();
        }
    }
}
```

* Product.java
```
public interface Product {
    public String name();
}
```

* SamsungProduct.java
```
public class SamsungProduct implements Product {
    @Override
    public String name() {
        return "SamsungProduct";
    }
}
```

* LGProduct.java
```
public class LGProduct implements Product {
    @Override
    public String name() {
        return "LGProduct";
    }
}
```

* Unit Test
```
@Test
public void testCreateProduct() {
    SamsungProduct samsungProduct = new SamsungProduct();
    LGProduct lgProduct = new LGProduct();
    ProductFactory productFactory = new ProductFactory();
    assertEquals(samsungProduct.name(), productFactory.create(Factory.SAMSUNG).name());
    assertEquals(lgProduct.name(), productFactory.create(Factory.LG).name());
    assertNotEquals(samsungProduct.name(), productFactory.create(Factory.LG).name());
}
```


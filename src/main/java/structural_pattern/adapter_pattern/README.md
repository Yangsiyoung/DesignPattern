어댑터 패턴
==========
래퍼 패턴 혹은 중개 패턴으로도 불리며, 내가 이해한 바로는  
기존에 구현되어 있던 로직이 있는데 그 로직을 그대로 사용하기엔 부적절한 리턴값 등이 있을 때  
기존 로직이 있던 클래스를 래핑한 클래스를 만들어서 지금 프로젝트에 사용하기에 적합한 구조로 바꿔주는  
역할을 하는 어댑터 클래스를 만드는 것(약간 110V to 220V 로 바꿔주는 변압기랄까...)  

그로니까 변경할 것이 많을 때에는 그냥 새로 만드는 것이 나을듯...
즉 그냥 가져다쓰는데 래핑해서 가져다쓰는 것...  

* Math.java
```
public class Math {

    public double twoTime(double number) {
        System.out.println(number);
        return number * 2;
    }

    public double halfTime(double number) {
        return number / 2;
    }

}
```

* MathAdapter.java
```
public interface MathAdapter {
    int twoTime(int number);
    int halfTime(int number);
}
```

* NewMath.java
```
public class NewMath implements MathAdapter{

    private final Math math = new Math();

    @Override
    public int twoTime(int number) {
        return (int) math.twoTime(number);
    }

    @Override
    public int halfTime(int number) {
        return (int) math.halfTime(number);
    }
}
```

* Unit Test
```
@Test
public void testAdapter() {
    NewMath newMath = new NewMath();
    assertEquals(2, newMath.twoTime(1));
    assertEquals(1, newMath.halfTime(2));
}
```
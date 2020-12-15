복합체 패턴
==========
객체 간의 구조화를 통해 객체를 확장하는 패턴  
객체들을 트리형태로 구성함  

* 복합객체  
객체가 또 다른 객체를 포함하고 있는 것  
(Composition 혹은 Aggregation 이라고 함)

복합체 패턴을 구현하기 위해선 아래의 구성요소가 필요하다.
* Component : 트리구조로 될 객체들의 공통 기능을 선언하는 Interface
* Leaf : Component 를 Implements 한 Class  
* Composite  : Component 를 Implements 한 Class 이며 자식 노드로 Leaf 를 가지고 있는 Class  
               추가적으로 Composite 는 자신의 Leaf 를 Add / Delete 할 수 있는 기능이 있음

약간 가계도? 같은 경우에 사용하는 느낌과 비슷하다.  

* Family.java (Component)
```
public interface Family {
    String getName();
    String getDateOfBirth();
}
```

* HanParents.java (Composite)
```
public class HanParents implements Family {

    private List<Family> childList = new ArrayList<>();

    @Override
    public String getName() {
        return "HanParents";
    }

    @Override
    public String getDateOfBirth() {
        return "0000-00-00";
    }

    public void addChild(Family child) {
        childList.add(child);
    }

    public void removeChild(Family child) {
        childList.remove(child);
    }

    public List<Family> getChildList() {
        return this.childList;
    }
}
```

* YangParents.java (Composite)
```
public class YangParents implements Family {

    private List<Family> childList = new ArrayList<>();

    @Override
    public String getName() {
        return "YangParents";
    }

    @Override
    public String getDateOfBirth() {
        return "0000-00-00";
    }

    public void addChild(Family child) {
        childList.add(child);
    }

    public void removeChild(Family child) {
        childList.remove(child);
    }

    public List<Family> getChildList() {
        return this.childList;
    }
}
```

* HanChild1.java (Leaf)
```
public class HanChild1 implements Family {
    @Override
    public String getName() {
        return "HanChild1";
    }

    @Override
    public String getDateOfBirth() {
        return "0000-00-00";
    }
}
```

* HanChild2.java (Leaf)
```
public class HanChild2 implements Family {
    @Override
    public String getName() {
        return "HanChild2";
    }

    @Override
    public String getDateOfBirth() {
        return "0000-00-00";
    }
}
```

* YangChild1.java (Leaf)
```
public class YangChild1 implements Family {

    @Override
    public String getName() {
        return "YangChild1";
    }

    @Override
    public String getDateOfBirth() {
        return "0000-00-00";
    }
}
```

* YangChild2.java (Leaf)
```
public class YangChild2 implements Family {
    @Override
    public String getName() {
        return "YangChild2";
    }

    @Override
    public String getDateOfBirth() {
        return "0000-00-00";
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
```

* Unit Test
```
@Test
public void testPattern() {
    HanChild1 hanChild1 = new HanChild1();
    HanChild2 hanChild2 = new HanChild2();

    YangChild1 yangChild1 = new YangChild1();
    YangChild2 yangChild2 = new YangChild2();

    HanParents hanParents = new HanParents();
    hanParents.addChild(hanChild1);
    hanParents.addChild(hanChild2);

    YangParents yangParents = new YangParents();
    yangParents.addChild(yangChild1);
    yangParents.addChild(yangChild2);

    assertEquals(hanChild1.getName(), hanParents.getChildList().get(0).getName());
    assertEquals(hanChild2.getName(), hanParents.getChildList().get(1).getName());

    assertEquals(yangChild1.getName(), yangParents.getChildList().get(0).getName());
    assertEquals(yangChild2.getName(), yangParents.getChildList().get(1).getName());
}
```




빌더 패턴
=========
복잡한 구조를 가진 복합 객체의 생성 과정을 단계별로 분리하는 패턴  
(Lombok 에서 편하게 빌더를 사용할 수 있다.)  
생성관련 코드가 1회에 완료되므로 객체 생성이후 수없는 set 을 할 필요가 없으며,  
객체에 필요한 값들이 초기화 되었는지 알 수 없던 set 방식을 벗어나  
1회의 호출로 객체 생성이 완료되고 필수 값들에 대한 검증을 할 수 있다.  
참고로 생성자를 사용해야한다면 값이 n 개라면 1개만 값이 있을때 ~ n 개 모두 값이있을때의 모든 케이스에 대한  
생성자를 선언해두어야 하기때문에... 생각만해도 어지럽다...  

* Student.java
```
public class Student {
    private String name;
    private int age;
    private String hobby;
    private String address;

    private Student(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.hobby = builder.hobby;
        this.address = builder.address;
    }

    public static class Builder {
        // 필수 값
        private final String name;
        private final int age;

        // 필수 X
        private String hobby;
        private String address;

        public Builder(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Builder hobby(String hobby) {
            this.hobby = hobby;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getHobby() {
        return hobby;
    }

    public String getAddress() {
        return address;
    }
}
```

* Unit Test
```
@Test
public void testBuilder() {
    String name = "name";
    int age = 28;
    String hobby = "hobby";
    String address = "address";

    Student student = new Student.Builder(name, age).hobby(hobby).address(address).build();
    
    assertEquals(name, student.getName());
    assertEquals(age, student.getAge());
    assertEquals(hobby, student.getHobby());
    assertEquals(address, student.getAddress());
}
```

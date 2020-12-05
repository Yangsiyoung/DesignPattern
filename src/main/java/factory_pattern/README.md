팩토리 패턴
===========

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
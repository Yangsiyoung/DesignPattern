package factory_pattern;

public class Hello {
    public String greeting() {
        Korean korean = new Korean();
        return korean.text();
    }
}

package creational_pattern.factory_pattern.original;

public class Hello {
    public String greeting() {
        Korean korean = new Korean();
        return korean.text();
    }
}

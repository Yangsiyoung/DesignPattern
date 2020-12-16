package structural_pattern.decorator_pattern.component;

public abstract class Beverage {
    public static final String LARGE = "L";
    public static final String MEDIUM = "M";
    public static final String SMALL = "S";
    public abstract int price();
    public abstract void orderSize(String size);
}

package structural_pattern.adapter_pattern;

public class Math {

    public double twoTime(double number) {
        System.out.println(number);
        return number * 2;
    }

    public double halfTime(double number) {
        return number / 2;
    }

}

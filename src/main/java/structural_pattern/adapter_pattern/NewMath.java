package structural_pattern.adapter_pattern;

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

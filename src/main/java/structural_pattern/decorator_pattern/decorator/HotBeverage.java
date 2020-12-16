package structural_pattern.decorator_pattern.decorator;

import structural_pattern.decorator_pattern.component.Beverage;

public abstract class HotBeverage extends Beverage {
    protected int numberOfSticks;
    public int sticks() {
        return this.numberOfSticks;
    };
    public abstract void setSticks(int numberOfSticks);
}

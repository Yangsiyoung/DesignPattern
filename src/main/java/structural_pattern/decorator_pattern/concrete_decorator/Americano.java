package structural_pattern.decorator_pattern.concrete_decorator;

import structural_pattern.decorator_pattern.component.Beverage;
import structural_pattern.decorator_pattern.decorator.HotBeverage;

public class Americano extends HotBeverage {

    private String size;

    @Override
    public void setSticks(int numberOfSticks) {
        this.numberOfSticks = numberOfSticks;
    }

    @Override
    public int price() {
        int price = -1;
        switch (size) {
            case Beverage.LARGE:
                price = 3500;
                break;
            case Beverage.MEDIUM:
                price = 3000;
                break;
            case Beverage.SMALL:
                price = 2500;
                break;
        }
        return price;
    }

    @Override
    public void orderSize(String size) {
        this.size = size;
    }
}

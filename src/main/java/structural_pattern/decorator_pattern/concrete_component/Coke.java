package structural_pattern.decorator_pattern.concrete_component;

import structural_pattern.decorator_pattern.component.Beverage;

public class Coke extends Beverage {

    private String size;

    @Override
    public int price() {
        int price = -1;
        switch (size) {
            case Beverage.LARGE:
                price = 2000;
                break;
            case Beverage.MEDIUM:
                price = 1500;
                break;
            case Beverage.SMALL:
                price = 1000;
                break;
        }
        return price;
    }

    @Override
    public void orderSize(String size) {
        this.size = size;
    }
}

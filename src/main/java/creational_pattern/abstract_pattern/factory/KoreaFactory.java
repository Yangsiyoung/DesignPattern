package creational_pattern.abstract_pattern.factory;

import creational_pattern.abstract_pattern.door.DoorProduct;
import creational_pattern.abstract_pattern.door.KoreaDoorProduct;
import creational_pattern.abstract_pattern.tire.KoreaTireProduct;
import creational_pattern.abstract_pattern.tire.TireProduct;

public class KoreaFactory extends Factory {
    @Override
    public TireProduct createTire() {
        return new KoreaTireProduct();
    }

    @Override
    public DoorProduct createDoor() {
        return new KoreaDoorProduct();
    }
}

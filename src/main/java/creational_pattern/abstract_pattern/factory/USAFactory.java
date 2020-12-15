package creational_pattern.abstract_pattern.factory;

import creational_pattern.abstract_pattern.door.DoorProduct;
import creational_pattern.abstract_pattern.door.USADoorProduct;
import creational_pattern.abstract_pattern.tire.TireProduct;
import creational_pattern.abstract_pattern.tire.USATireProduct;

public class USAFactory extends Factory{
    @Override
    public TireProduct createTire() {
        return new USATireProduct();
    }

    @Override
    public DoorProduct createDoor() {
        return new USADoorProduct();
    }
}

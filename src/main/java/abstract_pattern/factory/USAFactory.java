package abstract_pattern.factory;

import abstract_pattern.door.DoorProduct;
import abstract_pattern.door.USADoorProduct;
import abstract_pattern.tire.TireProduct;
import abstract_pattern.tire.USATireProduct;

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

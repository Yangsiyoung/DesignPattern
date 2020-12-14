package abstract_pattern.factory;

import abstract_pattern.door.DoorProduct;
import abstract_pattern.door.KoreaDoorProduct;
import abstract_pattern.tire.KoreaTireProduct;
import abstract_pattern.tire.TireProduct;

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

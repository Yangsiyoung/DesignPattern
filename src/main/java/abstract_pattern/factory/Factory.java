package abstract_pattern.factory;

import abstract_pattern.door.DoorProduct;
import abstract_pattern.tire.TireProduct;

public abstract class Factory {
    abstract public TireProduct createTire();
    abstract public DoorProduct createDoor();
}

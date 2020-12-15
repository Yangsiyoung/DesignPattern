package creational_pattern.abstract_pattern.factory;

import creational_pattern.abstract_pattern.door.DoorProduct;
import creational_pattern.abstract_pattern.tire.TireProduct;

public abstract class Factory {
    abstract public TireProduct createTire();
    abstract public DoorProduct createDoor();
}

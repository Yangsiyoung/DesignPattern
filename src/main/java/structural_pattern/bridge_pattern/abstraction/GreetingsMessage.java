package structural_pattern.bridge_pattern.abstraction;

import structural_pattern.bridge_pattern.implementor.Greetings;

public abstract class GreetingsMessage {
    protected Greetings greetings;
    abstract public String greet();
}

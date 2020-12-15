package bridge_pattern.abstraction;

import bridge_pattern.implementor.Greetings;

public abstract class GreetingsMessage {
    protected Greetings greetings;
    abstract public String greet();
}

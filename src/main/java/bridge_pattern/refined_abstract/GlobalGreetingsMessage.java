package bridge_pattern.refined_abstract;

import bridge_pattern.implementor.Greetings;
import bridge_pattern.abstraction.GreetingsMessage;

public class GlobalGreetingsMessage extends GreetingsMessage {

    public GlobalGreetingsMessage(Greetings greetings) {
        this.greetings = greetings;
    }

    @Override
    public String greet() {
        return this.greetings.greet();
    }
}

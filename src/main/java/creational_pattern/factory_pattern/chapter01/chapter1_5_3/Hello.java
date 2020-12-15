package creational_pattern.factory_pattern.chapter01.chapter1_5_3;

public class Hello {
    public String greeting(String type) {
        return Factory.getGreetingInstance(type).text();
    }
}

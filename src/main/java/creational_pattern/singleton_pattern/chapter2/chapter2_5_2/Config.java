package creational_pattern.singleton_pattern.chapter2.chapter2_5_2;

public class Config {
    private static Config instance = null;

    // 외부에서 new 키워드로 객체를 생성하지 못하게 막음
    protected Config() {
        System.out.println("Config 객체 생성");
    }

    public static Config getInstance() {
        if(instance == null) {
            instance = new Config();
        }
        return instance;
    }
}

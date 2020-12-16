package structural_pattern.facade_pattern;

public class Car {

    private final Engine engine;
    private final Handle handle;

    public Car() {
        this.engine = new Engine(); // 엔진이 바뀌면 여기만 바꾸면 됨
        this.handle = new Handle(); // 핸들이 바뀌면 여기만 바꾸면 됨
    }

    // 나중에 팩토리 패턴 혹은 팩토리 메서드 패턴 등을 통해 확장할 경우를 대비해 남겨둠
    public Car(Engine engine, Handle handle) {
        this.engine = engine;
        this.handle = handle;
    }

    public void goStraight() {
        engine.run();
        handle.straight();
    }

    public void goLeft(){
        engine.run();
        handle.left();
    }

    public void goRight() {
        engine.run();
        handle.right();
    }

    public void stop() {
        engine.stop();
        handle.straight();
    }
}

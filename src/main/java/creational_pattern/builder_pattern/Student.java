package creational_pattern.builder_pattern;

public class Student {
    private String name;
    private int age;
    private String hobby;
    private String address;

    private Student(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.hobby = builder.hobby;
        this.address = builder.address;
    }

    public static class Builder {
        // 필수 값
        private final String name;
        private final int age;

        // 필수 X
        private String hobby;
        private String address;

        public Builder(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Builder hobby(String hobby) {
            this.hobby = hobby;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getHobby() {
        return hobby;
    }

    public String getAddress() {
        return address;
    }
}

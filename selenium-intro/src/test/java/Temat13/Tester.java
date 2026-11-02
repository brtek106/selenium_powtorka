package Temat13;

public class Tester {
    private String firstName;
    private String city;
    private int age;
    private String position;

    public Tester(String firstName, String city, int age, String position) {
        this.firstName = firstName;
        this.city = city;
        this.age = age;
        this.position = position;
    }

    @Override
    public String toString() {
        return String.format("%s works in %s, age %d, is %s", this.firstName, this.city, this.age, this.position);
    }
}

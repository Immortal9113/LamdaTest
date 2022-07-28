package UserContainer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    int age;
    String name;
    boolean sex;
    String speciality;

    public User(int age, String name, boolean sex, String speciality) {
        this.age = age;
        this.name = name;
        this.sex = sex;
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return "Age: " + age + ", Name = " + name + ", Sex = " + sex + ", Speciality = " + speciality;
    }
}

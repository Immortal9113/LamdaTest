package InterfaceForFlex;

public interface ThreeDifferent {

    static int threeDifferent(int age, boolean sex, int deathAge) {
        System.out.println("Sex is " + sex);
        return deathAge - age;
    }
}

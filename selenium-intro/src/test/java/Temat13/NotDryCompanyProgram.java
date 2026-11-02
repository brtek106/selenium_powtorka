package Temat13;
public class NotDryCompanyProgram {

    public static String standardFormat = "%s is %s, works in %s, age %s";

    public static void main(String[] args) {
        System.out.println("Tester in the company are: ");
        introduceTester();
        introduceTester2();
        introduceTester3();
        introduceTester5();
    }

    private static void introduceTester() {
        String message = String.format(standardFormat, "Kazimierz", "Junior Manual Tester",  "Wrocław", 31);
        System.out.println(message);
    }

    private static void introduceTester5() {
        String message = String.format(standardFormat, "Zygmunt", "Junior Manual Tester",  "Wrocław", 21);
        System.out.println(message);
    }

    private static void introduceTester3() {
        String message = String.format(standardFormat, "Anna", "Lead Manual Tester",  "Wrocław", 44);
        System.out.println(message);
    }

    private static void introduceTester2() {
        String message = String.format(standardFormat, "Stefan", "Senior manual tester",  "Wrocław", 28);
        System.out.println(message);
    }

}

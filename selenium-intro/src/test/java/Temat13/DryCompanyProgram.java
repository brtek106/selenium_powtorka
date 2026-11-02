package Temat13;

import java.util.ArrayList;
import java.util.List;

public class DryCompanyProgram {

    private static final String CITY_WROCLAW = "Wrocław";

    public static void main(String[] args) {
        System.out.println("Testers in the company are: ");
        List<Tester> testers = new ArrayList<>();

        Tester testerKazimierz = new Tester("Kazimierz", CITY_WROCLAW, 32, Position.JUNIOR_MANUAL_TESTER.getPositionName());
        Tester testerZygmunt = new Tester("Zygmunt", CITY_WROCLAW, 21, Position.JUNIOR_MANUAL_TESTER.getPositionName());
        Tester testerAnna = new Tester("Anna", CITY_WROCLAW, 44, Position.LEAD_MANUAL_TESTER.getPositionName());
        Tester testerStefan = new Tester("Stefan", CITY_WROCLAW, 28, Position.SENIOR_MANUAL_TESTER.getPositionName());

        testers.add(testerKazimierz);
        testers.add(testerZygmunt);
        testers.add(testerAnna);
        testers.add(testerStefan);

        for (Tester tester : testers) {
            System.out.println(tester.toString());
        }
    }
}

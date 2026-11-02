package Temat13;

public enum Position {
    JUNIOR_MANUAL_TESTER("Junior Manual Tester"),
    LEAD_MANUAL_TESTER("Lead Manual Tester"),
    SENIOR_MANUAL_TESTER("Senior Manual Tester");

    private String positionName;

    Position(String positionName) {
        this.positionName = positionName;
    }

    public String getPositionName() {
        return positionName;
    }
}

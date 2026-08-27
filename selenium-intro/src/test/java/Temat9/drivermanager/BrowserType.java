package Temat9.drivermanager;

public enum BrowserType {

    FIREFOX("firefox"),
    CHROME("chrome"),
    IE("internetExplorer");

    private final String browser;

    BrowserType(String browser) {
        this.browser = browser;
    }
}

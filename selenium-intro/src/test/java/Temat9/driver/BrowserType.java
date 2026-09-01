package Temat9.driver;

public enum BrowserType {

    FIREFOX("firefox"),
    CHROME("chrome"),
    IE("internetExplorer");

    private final String browser;

    BrowserType(String browser) {
        this.browser = browser;
    }
}

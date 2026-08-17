package Temat9.drivermanager;

public enum BrowserType {

    FIREFOX("firefox"),
    CHROME("chrome"),
    EDGE("microsoftedge");

    private final String browser;

    BrowserType(String browser) {
        this.browser = browser;
    }
}

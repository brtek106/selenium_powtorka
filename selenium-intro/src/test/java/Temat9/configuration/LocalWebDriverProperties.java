package Temat9.configuration;

import Temat9.drivermanager.BrowserType;

public class LocalWebDriverProperties {

    // Metody zwracają właściwości dla poszczególnych kluczy, analogicznie jak w przypadku AppProperties

    public static BrowserType getLocalBrowser() {
        return BrowserType.valueOf(ConfigurationProperties.getProperties().getProperty("local.browser"));
    }
}

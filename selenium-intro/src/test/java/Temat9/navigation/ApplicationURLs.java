package Temat9.navigation;

import Temat9.configuration.AppProperties;

public class ApplicationURLs {
    public static final String APPLICATION_URL = AppProperties.getAllUrl();
    public static final String LOGIN_URL = APPLICATION_URL + "actions/Account.action?signonForm=";
}

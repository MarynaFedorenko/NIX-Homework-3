package nix.config;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class ApplicationEnvironment {


    private static final String LANG_KEY = "lang";

    private static final Map<String, String> APPLICATION_ENVIRONMENT_PROPERTIES = new HashMap<>();

    public static void setPropertyLang(String lang) {
        APPLICATION_ENVIRONMENT_PROPERTIES.put(LANG_KEY, lang);
    }

    public static String getPropertyLang() {
        return APPLICATION_ENVIRONMENT_PROPERTIES.get(LANG_KEY);
    }

    private static final ResourceBundle RESOURCE_APPOINTMENTS = ResourceBundle.getBundle("appointments");

    public static Map<String, String> getBundleProperties(String lang) {
        return convertResourceBundleToMap(RESOURCE_APPOINTMENTS);
    }

    private static Map<String, String> convertResourceBundleToMap(ResourceBundle resource) {
        Map<String, String> map = new HashMap<>();
        Enumeration<String> keys = resource.getKeys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            map.put(key, resource.getString(key));
        }
        return map;
    }

}

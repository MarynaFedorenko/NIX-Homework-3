package nix.Util;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class BundleUtil {

    private static final ResourceBundle RESOURCE_APPOINTMENT = ResourceBundle.getBundle("appointments");

    public static Map<String, String> getBundleProperties(String lang) {
        return convertResourceBundleToMap(RESOURCE_APPOINTMENT);
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

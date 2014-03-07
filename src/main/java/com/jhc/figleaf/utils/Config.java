package com.jhc.figleaf.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**.
 * User: DicksonH
 * Date: 05/03/14
 * Time: 10:15
 *
 */
public class Config {

    private static final Map<String, String> settings;

    static {
        Map<String, String> settingsBuilder = new HashMap<String, String>();
        String location = getPropertiesLocation();

        Properties properties = new Properties();

        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(location);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            settingsBuilder.put((String) entry.getKey(), (String) entry.getValue());
        }

        settings = Collections.unmodifiableMap(settingsBuilder);

    }

    public static String getSetting(String key)
    {
        return settings.get(key);
    }

    private static String getPropertiesLocation() {
        if (System.getProperty("os.name").toLowerCase().indexOf( "win" ) == 0) {
            return new File(Config.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParentFile().getParentFile().getParentFile().getParentFile().getParentFile().getParent() + "\\JobsRestApp.properties";
        } else {
            return "/opt/jhc/figleaf/figleaf.properties";
        }
    }
}

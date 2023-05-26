package org.ibatis.core;

import java.io.InputStream;

public class Resources {
    public static InputStream getResourcesAsStream(String config) {
        return ClassLoader.getSystemResourceAsStream(config);
    }
}

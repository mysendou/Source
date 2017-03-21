package org.flywaydb.commandline;

import java.io.Console;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import org.flywaydb.core.internal.util.ClassUtils;
import org.flywaydb.core.internal.util.StringUtils;

public class Test {
    public static void main(String[] args) throws Exception{
        System.out.println(System.getProperty("java.version"));
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("os.version"));
        System.out.println(System.getProperty("os.arch"));
        System.out.println(System.getProperty("user.home"));

        String path = ClassUtils.getLocationOnDisk(Test.class);
        System.out.println("path: " + path);
        System.out.println(new File(path).getParentFile().getParentFile().getAbsolutePath());
        
        Properties properties = new Properties();
//        File file = new File("/flyway.conf");
//        String contents = FileCopyUtils.copyToString(new InputStreamReader(new FileInputStream(file), "UTF-8"));
        
//        properties.load(new StringReader(contents.replace("\\", "\\\\")));
        
        properties.load(Test.class.getClassLoader().getResourceAsStream("flyway.conf"));
        System.out.println(properties);
        Console console = System.console();
        System.out.println(!properties.containsKey("flyway.user"));
        if (!properties.containsKey("flyway.user")) {
            System.out.println(console.readLine("Database user: "));
//            properties.put("flyway.user", console.readLine("Database user: "));
        }

        System.out.println(properties);
        System.out.println("==================================");
        dumpConfiguration(properties);
        loadJdbcDrivers();
    }
    
    private static void dumpConfiguration(Properties properties) {
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            String value = entry.getValue().toString();
            value = "flyway.password".equals(entry.getKey()) ? StringUtils.trimOrPad("", value.length(), '*') : value;
            System.out.println(entry.getKey() + " -> " + value);
        }
    }
    
    private static void loadJdbcDrivers() throws IOException {
        File driversDir = new File("D:/MyworkspaceTest/Flyway/src/drivers");
        File[] files = driversDir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(".jar");
            }
        });

        // see javadoc of listFiles(): null if given path is not a real
        // directory
        if (files == null) {
            System.exit(1);
        }

        for (File file : files) {
            System.out.println((file.getPath()));
        }
    }
}

package com.demoqa.tests.params;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {
    @Test
    void simplePropertyTest() {
        String browserName = System.getProperty("browser");
        System.out.println(browserName); //null
    }
    @Test
    void simpleProperty1Test() {
        System.setProperty("browser", "opera");
        String browserName = System.getProperty("browser");
        System.out.println(browserName); // opera
    }
    @Test
    void simpleProperty2Test() {
        String browserName = System.getProperty("browser", "firefox");
        System.out.println(browserName); // firefox
    }
    @Test
    void simpleProperty3Test() {
        System.setProperty("browser", "opera");
        String browserName = System.getProperty("browser", "firefox");
        System.out.println(browserName); // opera
    }
    @Test
    @Tag("property_test")
    void simpleProperty4Test() {
        String browserName = System.getProperty("browser", "firefox");
        System.out.println(browserName);
        //gradle clean property_test -Dbrowser=safari
        //safari
    }
    @Test
    @Tag("many_properties_test")
    void simpleProperty5Test() {
        String browserName = System.getProperty("browser", "firefox");
        String browserVersion = System.getProperty("browser_version", "105");
        String browserSize = System.getProperty("browser_size", "1920x1080");

        System.out.println(browserName);
        System.out.println(browserVersion);
        System.out.println(browserSize);
        /*
        From IDEA
              firefox
              105
              1920x1080

        gradle clean many_properties_test
              firefox
              105
              1920x1080

        gradle clean many_properties_test -Dbrowser=safari
              safari
              105
              1920x1080

        gradle clean many_properties_test -Dbrowser=safari -Dbrowser_version=99 -Dbrowser_size=500x700
              safari
              99
              500x700
        */
    }
    @Test
    @Tag("hello")
    void simpleProperty6Test() {
        System.out.println("Hello," + System.getProperty("user_name", "unknown student"));
        /*
          gradle clean hello -Duser_name=xenia
                        Hello,xenia
        */
    }
}

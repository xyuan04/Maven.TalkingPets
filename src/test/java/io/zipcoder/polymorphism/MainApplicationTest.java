package io.zipcoder.polymorphism;

import org.junit.Test;

public class MainApplicationTest {
@Test
    public void testMe(){}

    @Test
    public void testSpeak() {
        String name = "test";
        Pet test = new Dog(name);

        test.speak();
    }
}

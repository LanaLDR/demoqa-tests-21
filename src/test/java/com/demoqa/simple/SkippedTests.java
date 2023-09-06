package com.demoqa.simple;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("simple")
public class SkippedTests {

    @Test
    @Disabled("some reasone")
    void someTest() {
        assertTrue(false);
    }

    @Test
    @Disabled("some reasone")
    void someTest1() {
        assertTrue(false);
    }
}

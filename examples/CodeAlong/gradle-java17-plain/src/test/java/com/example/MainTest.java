package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void magicNumber() {
        var unit = new Main();
        Assertions.assertEquals(42, unit.magicNumber(), "magic number is incorrect");
    }
}
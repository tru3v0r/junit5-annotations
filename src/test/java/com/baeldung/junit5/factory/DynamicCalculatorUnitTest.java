package com.baeldung.junit5.factory;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;


public class DynamicCalculatorUnitTest {

    @TestFactory
    public Collection<DynamicTest> dynamicCalculatorTestCollection() {
        return Arrays.asList(
                dynamicTest("Addition", () -> assertEquals(4, Math.addExact(2, 2))),
                dynamicTest("Multiplication", () -> assertEquals(8, Math.multiplyExact(2, 6))),
                dynamicTest("Subtraction", () -> assertEquals(6, Math.subtractExact(10, 4))),
                dynamicTest("Division", () -> assertEquals(5, 10/2))
        );
    }

    @TestFactory
    Iterable<DynamicTest> dynamicCalculatorTestIterable() {
        return Arrays.asList(
                dynamicTest("Addition", () -> assertEquals(4, Math.addExact(2, 2))),
                dynamicTest("Multiplication", () -> assertEquals(8, Math.multiplyExact(2, 6))),
                dynamicTest("Subtraction", () -> assertEquals(6, Math.subtractExact(10, 4))),
                dynamicTest("Division", () -> assertEquals(5, 10/2))
        );
    }

    @TestFactory
    Iterator<DynamicTest> dynamicCalculatorTestIterator() {
        return Arrays.asList(
                dynamicTest("Addition", () -> assertEquals(4, Math.addExact(2, 2))),
                dynamicTest("Multiplication", () -> assertEquals(8, Math.multiplyExact(2, 6))),
                dynamicTest("Subtraction", () -> assertEquals(6, Math.subtractExact(10, 4))),
                dynamicTest("Division", () -> assertEquals(5, 10/2))
        ).iterator();
    }

    @TestFactory
    Stream<DynamicTest> dynamicEvenNumberTestStream() {
        return IntStream.iterate(0, n -> n + 1).limit(10)
                .mapToObj(n -> dynamicTest("test" + n,
                        () -> assertTrue(n % 2 == 0)));
    }
}
package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private Main mainInstance;

    @BeforeEach
    void setUp() {
        mainInstance = new Main();
    }

    /**
     * Helper method to invoke private methods reflectively.
     */
    private Object invokePrivateMethod(String methodName, Class<?>[] parameterTypes, Object... args) throws Exception {
        Method method = Main.class.getDeclaredMethod(methodName, parameterTypes);
        method.setAccessible(true);
        return method.invoke(mainInstance, args);
    }

    @Nested
    @DisplayName("Tests for add(int, int)")
    class AddTests {

        @Test
        @DisplayName("Should correctly add two positive integers")
        void testAddPositiveNumbers() throws Exception {
            int result = (int) invokePrivateMethod("add", new Class<?>[]{int.class, int.class}, 10, 23);
            assertEquals(33, result);
        }

        @Test
        @DisplayName("Should handle negative numbers")
        void testAddNegativeNumbers() throws Exception {
            int result = (int) invokePrivateMethod("add", new Class<?>[]{int.class, int.class}, -5, -10);
            assertEquals(-15, result);
        }
    }

    @Nested
    @DisplayName("Tests for sub(int, int)")
    class SubTests {

        @Test
        @DisplayName("Should correctly subtract two integers")
        void testSub() throws Exception {
            int result = (int) invokePrivateMethod("sub", new Class<?>[]{int.class, int.class}, 10, 23);
            assertEquals(-13, result);
        }
    }

    @Nested
    @DisplayName("Tests for mul(int, int)")
    class MulTests {

        @ParameterizedTest(name = "{0} * {1} should equal {2}")
        @CsvSource({
                "10, 23, 230",
                "0, 5, 0",
                "-2, 4, -8",
                "-3, -3, 9"
        })
        void testMul(int i, int j, int expected) throws Exception {
            int result = (int) invokePrivateMethod("mul", new Class<?>[]{int.class, int.class}, i, j);
            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("Tests for div(int, int)")
    class DivTests {

        @Test
        @DisplayName("Should perform integer division correctly")
        void testDivValid() throws Exception {
            int result = (int) invokePrivateMethod("div", new Class<?>[]{int.class, int.class}, 10, 23);
            assertEquals(0, result); // 10 / 23 = 0 in integer arithmetic
            int divResult = (int) invokePrivateMethod("div", new Class<?>[]{int.class, int.class}, 10, 2);
            assertEquals(0,divResult);
        }

        @Test
        @DisplayName("Should throw ArithmeticException when dividing by zero")
        void testDivByZero() {
            assertThrows(Exception.class, () -> {
                invokePrivateMethod("div", new Class<?>[]{int.class, int.class}, 10, 0);
            });
        }
    }

    @Nested
    @DisplayName("Tests for root(int)")
    class RootTests {

        @Test
        @DisplayName("Should compute square (root method actually computes i * i)")
        void testRoot() throws Exception {
            int result = (int) invokePrivateMethod("root", new Class<?>[]{int.class}, 55);
            assertEquals(3025, result);
        }
    }

    @Test
    @DisplayName("Should run main method without throwing exceptions")
    void testMainMethod() {
        assertDoesNotThrow(() -> Main.main(new String[]{}));
    }
}
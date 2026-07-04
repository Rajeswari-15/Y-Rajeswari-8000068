import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

public class FixtureTest {

    private Calculator calculator;

    @Before
    public void setUp() {

        System.out.println("Before Test");

        calculator = new Calculator();
    }

    @Test
    public void testAdd() {

        // Arrange
        int a = 2;
        int b = 3;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(5, result);
    }

    @After
    public void tearDown() {

        System.out.println("After Test");
    }
}

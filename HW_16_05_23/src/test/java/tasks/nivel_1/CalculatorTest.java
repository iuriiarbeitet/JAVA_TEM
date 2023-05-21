package tasks.nivel_1;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CalculatorTest {

    @Test
    void testAdd() {
        Calculator calculator = Mockito.mock(Calculator.class);
        int a = 5;
        int b = 5;
        Mockito.when(calculator.add(a, b)).thenReturn(10);
        calculator.add(a, b);
        Mockito.verify(calculator).add(a, b);
    }
}

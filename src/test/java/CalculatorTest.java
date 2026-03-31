import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    Adder adder = mock(Adder.class);
    Calculator calculator = new Calculator(adder);

    @BeforeEach
    void setUp() {
        doAnswer(invocation -> {
            int value = invocation.getArgument(0);
            return value + 1;
        }).when(adder).add(anyInt(), eq(1));

        doAnswer(invocation -> {
            int result = invocation.getArgument(0);
            int value = invocation.getArgument(1);
            return result + value;
        }).when(adder).add(anyInt(), anyInt());

//        System.out.println(adder.add(1, 3));
    }

    @Test
    void addTest() {
        int result = calculator.add(1, 2);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void subtractTest() {
        int result = calculator.subtract(1, 2);
        assertThat(result).isEqualTo(-1);
    }

    @Test
    void multiplyTest() {
        int result = calculator.multiply(1, 2);
        assertThat(result).isEqualTo(2);
    }
}
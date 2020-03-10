package michalsydoryk.fluentconditionals;

import org.mockito.Mockito;
import org.testng.annotations.Test;

import java.util.function.Supplier;

@Test
public class FluentConditionalsTest {
    public void shouldRunRunnableInOrElse() {
        //Given
        boolean condition = false;
        FluentConditionals fluentConditionals = new FluentConditionals(condition);
        Runnable runnable = Mockito.mock(Runnable.class);
        //When
        fluentConditionals.orElse(runnable);
        //Then
        Mockito.verify(runnable, Mockito.times(1)).run();
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void shouldThrowExceptionGivenAsArgumentInOrElseThrow() throws Exception {
        //Given
        boolean condition = false;
        FluentConditionals fluentConditionals = new FluentConditionals(condition);
        //When
        fluentConditionals.orElseThrow(new RuntimeException());
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void shouldThrowExceptionGivenFromSupplierInOrElseThrow() throws Exception {
        //Given
        boolean condition = false;
        Supplier<RuntimeException> supplier = () -> new RuntimeException();
        FluentConditionals fluentConditionals = new FluentConditionals(condition);
        //When
        fluentConditionals.orElseThrow(supplier);
    }
}

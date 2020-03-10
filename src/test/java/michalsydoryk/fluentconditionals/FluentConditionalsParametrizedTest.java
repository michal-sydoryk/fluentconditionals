package michalsydoryk.fluentconditionals;

import org.mockito.Mockito;
import org.testng.annotations.Test;

import java.util.function.Consumer;
import java.util.function.Supplier;

@Test
public class FluentConditionalsParametrizedTest {
    public void shouldRunConsumerInOrElse() {
        //Given
        String parameter = "Example";
        boolean condition = false;
        FluentConditionalsParametrized fluentConditionalsParametrized
                = new FluentConditionalsParametrized(parameter, condition);
        Consumer<String> consumer = Mockito.mock(Consumer.class);
        //When
        fluentConditionalsParametrized.orElse(consumer);
        //Then
        Mockito.verify(consumer, Mockito.times(1)).accept(parameter);
    }

    public void shouldRunRunnableInOrElse() {
        //Given
        String parameter = "Example";
        boolean condition = false;
        FluentConditionalsParametrized fluentConditionalsParametrized
                = new FluentConditionalsParametrized(parameter, condition);
        Runnable runnable = Mockito.mock(Runnable.class);
        //When
        fluentConditionalsParametrized.orElse(runnable);
        //Then
        Mockito.verify(runnable, Mockito.times(1)).run();
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void shouldThrowRuntimeExceptionInOrElseOnArgumentException() throws Exception {
        //Given
        String parameter = "Example";
        boolean condition = false;
        FluentConditionalsParametrized fluentConditionalsParametrized
                = new FluentConditionalsParametrized(parameter, condition);
        //When
        fluentConditionalsParametrized.orElseThrow(new RuntimeException());
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void shouldThrowRuntimeExceptionInOrElseOnExceptionSupplier() throws Exception {
        //Given
        String parameter = "Example";
        boolean condition = false;
        FluentConditionalsParametrized fluentConditionalsParametrized
                = new FluentConditionalsParametrized(parameter, condition);
        Supplier<RuntimeException> supplier = RuntimeException::new;
        //When
        fluentConditionalsParametrized.orElseThrow(supplier);
    }

}

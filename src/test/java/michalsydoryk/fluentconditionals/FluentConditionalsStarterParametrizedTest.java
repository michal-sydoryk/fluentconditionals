package michalsydoryk.fluentconditionals;

import org.mockito.Mockito;
import org.testng.annotations.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static michalsydoryk.fluentconditionals.FluentConditionalsStarterParametrized.given;

@Test
public class FluentConditionalsStarterParametrizedTest {
    public void shouldRunConsumerInThenMethodAfterGivingTrueConditionAndParameterByArgument() {
        //Given
        String parameter = "Example";
        boolean condition = true;
        Consumer<String> consumer = Mockito.mock(Consumer.class);
        //When
        given(parameter).when(condition).then(consumer);
        //Then
        Mockito.verify(consumer, Mockito.times(1)).accept(parameter);
    }

    public void shouldRunConsumerInThenMethodAfterGivingTrueConditionAndParameterBySupplier() {
        //Given
        String parameter = "Example";
        Supplier<String> stringSupplier = () -> parameter;
        Supplier<Boolean> booleanSupplier = () -> true;
        Consumer<String> consumer = Mockito.mock(Consumer.class);
        //When
        given(stringSupplier).when(booleanSupplier).then(consumer);
        //Then
        Mockito.verify(consumer, Mockito.times(1)).accept(parameter);
    }

    public void shouldNotRunConsumerInThenMethodAfterGivingFalseConditionAndParameterArgument() {
        //Given
        String parameter = "Example";
        boolean condition = false;
        Consumer<String> consumer = Mockito.mock(Consumer.class);
        //When
        given(parameter).when(condition).then(consumer);
        //Then
        Mockito.verify(consumer, Mockito.never()).accept(parameter);
    }

    public void shouldRunFunctionInThenReturnMethod() {
        //Given
        String parameter = "Example";
        boolean condition = false;
        Function<String, Integer> function = Mockito.mock(Function.class);
        //When
        given(parameter).when(condition).thenReturn(function);
        //Then
        Mockito.verify(function, Mockito.times(1)).apply(parameter);
    }

    public void shouldRunSupplierInThenReturnMethod() {
        //Given
        String parameter = "Example";
        boolean condition = false;
        Supplier<String> supplier = Mockito.mock(Supplier.class);
        //When
        given(parameter).when(condition).thenReturn(supplier);
        //Then
        Mockito.verify(supplier, Mockito.times(1)).get();
    }
}

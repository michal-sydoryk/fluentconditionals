package michalsydoryk.fluentconditionals;

import org.mockito.Mockito;
import org.testng.annotations.Test;

import java.util.function.Supplier;

import static michalsydoryk.fluentconditionals.FluentConditionalsStarter.when;

@Test
public class FluentconditionalsStarterTest {
    public void shouldRunRunnableInThenMethodAfterGivingTrueCondition() {
        //Given
        boolean condition = true;
        Runnable runnableCalledInThenMethod = Mockito.mock(Runnable.class);
        //When
        when(condition).then(runnableCalledInThenMethod);
        //Then
        Mockito.verify(runnableCalledInThenMethod, Mockito.times(1)).run();
    }

    public void shouldNotRunRunnableInThenMethodAfterGivingFalseCondition() {
        //Given
        boolean condition = false;
        Runnable runnableCalledInThenMethod = Mockito.mock(Runnable.class);
        //When
        when(condition).then(runnableCalledInThenMethod);
        //Then
        Mockito.verify(runnableCalledInThenMethod, Mockito.never()).run();
    }

    public void shouldRunRunnableInThenMethodAfterGivingTrueConditionBySupplier() {
        //Given
        Supplier<Boolean> returnTrue = () -> true;
        Runnable runnableCalledInThenMethod = Mockito.mock(Runnable.class);
        //When
        when(returnTrue).then(runnableCalledInThenMethod);
        //Then
        Mockito.verify(runnableCalledInThenMethod, Mockito.times(1)).run();
    }

    public void shouldNotRunRunnableInThenMethodAfterGivingFalseConditionBySupplier() {
        //Given
        Supplier<Boolean> returnTrue = () -> false;
        Runnable runnableCalledInThenMethod = Mockito.mock(Runnable.class);
        //When
        when(returnTrue).then(runnableCalledInThenMethod);
        //Then
        Mockito.verify(runnableCalledInThenMethod, Mockito.never()).run();
    }

    public void shouldRunRunnableInThenMethodAfterGivingFalseConditionBySupplier() {
        //Given
        Supplier<Boolean> returnTrue = () -> false;
        Runnable runnableCalledInThenMethod = Mockito.mock(Runnable.class);
        //When
        when(returnTrue).then(runnableCalledInThenMethod);
        //Then
        Mockito.verify(runnableCalledInThenMethod, Mockito.never()).run();
    }
}

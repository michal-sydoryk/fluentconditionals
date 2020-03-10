package michalsydoryk.fluentconditionals;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.function.Function;
import java.util.function.Supplier;

@Test
public class FluentConditionalsParametrizedReturningValueTest {
    public void shouldReturnStartingValueAfterCallingOrElseWithTrueConditionAndFunctionAsArgument() {
        //Given
        String parameter = "Parameter";
        boolean condition = true;
        String startingValue = "Value";
        FluentConditionalsParametrizedReturningValue<String, String> fluentConditionalsParametrizedReturningValue
                = new FluentConditionalsParametrizedReturningValue<>(parameter, condition, startingValue);
        Function<String, String> function = s -> "Swidrowiatrak";
        //When
        String returnedValue = fluentConditionalsParametrizedReturningValue
                .orElse(function);
        //Then
        Assert.assertEquals(returnedValue, startingValue);
    }

    public void shouldReturnGivenValueAfterCallingOrElseWithFalseConditionAndFunctionAsArgument() {
        //Given
        String parameter = "Parameter";
        boolean condition = false;
        String startingValue = "Value";
        String givenValue = "Given Value";
        FluentConditionalsParametrizedReturningValue<String, String>  fluentConditionalsParametrizedReturningValue
                = new FluentConditionalsParametrizedReturningValue<>(parameter, condition, startingValue);
        Function<String, String> function = s -> givenValue;
        //When
        String returnedValue = fluentConditionalsParametrizedReturningValue
                .orElse(function);
        //Then
        Assert.assertEquals(returnedValue, givenValue);
    }

    public void shouldReturnStartingValueAfterCallingOrElseWithTrueConditionAndSupplierAsArgument() {
        //Given
        String parameter = "Parameter";
        boolean condition = true;
        String startingValue = "Value";
        FluentConditionalsParametrizedReturningValue<String, String> fluentConditionalsParametrizedReturningValue
                = new FluentConditionalsParametrizedReturningValue<>(parameter, condition, startingValue);
        Supplier<String> supplier = () -> "Some different value";
        //When
        String returnedValue = fluentConditionalsParametrizedReturningValue
                .orElse(supplier);
        //Then
        Assert.assertEquals(returnedValue, startingValue);
    }

    public void shouldReturnGivenValueAfterCallingOrElseWithFalseConditionAndSupplierAsArgument() {
        //Given
        String parameter = "Parameter";
        boolean condition = false;
        String startingValue = "Value";
        String givenValue = "Given Value";
        FluentConditionalsParametrizedReturningValue<String, String> fluentConditionalsParametrizedReturningValue
                = new FluentConditionalsParametrizedReturningValue<>(parameter, condition, startingValue);
        Supplier<String> supplier = () -> givenValue;
        //When
        String returnedValue = fluentConditionalsParametrizedReturningValue
                .orElse(supplier);
        //Then
        Assert.assertEquals(returnedValue, givenValue);
    }


    public void shouldStartingValueAfterCallingOrElseWithTrueConditionAndObjectAsArgument() {
        //Given
        String parameter = "Parameter";
        boolean condition = false;
        String startingValue = "Value";
        FluentConditionalsParametrizedReturningValue<String, String> fluentConditionalsParametrizedReturningValue
                = new FluentConditionalsParametrizedReturningValue<>(parameter, condition, startingValue);

        //When
        String returnedValue = fluentConditionalsParametrizedReturningValue
                .orElse(startingValue);
        //Then
        Assert.assertEquals(returnedValue, startingValue);
    }

    public void shouldReturnGivenValueAfterCallingOrElseWithFalseConditionAndObjectAsArgument() {
        //Given
        String parameter = "Parameter";
        boolean condition = false;
        String startingValue = "Value";
        String givenValue = "Given Value";
        FluentConditionalsParametrizedReturningValue<String, String>  fluentConditionalsParametrizedReturningValue
                = new FluentConditionalsParametrizedReturningValue<>(parameter, condition, startingValue);
        //When
        String returnedValue = fluentConditionalsParametrizedReturningValue
                .orElse(givenValue);
        //Then
        Assert.assertEquals(returnedValue, givenValue);
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void shouldThrowRuntimeExceptionInOrElseOnExceptionSupplier() throws Exception {
        //Given
        String parameter = "Parameter";
        boolean condition = false;
        String startingValue = "Value";
        FluentConditionalsParametrizedReturningValue<String, String>  fluentConditionalsParametrizedReturningValue
                = new FluentConditionalsParametrizedReturningValue(parameter, condition, startingValue);
        Supplier<RuntimeException> supplier = RuntimeException::new;
        //When
        fluentConditionalsParametrizedReturningValue.orElseThrow(supplier);
    }

    public void shouldReturnStartingValueAfterCallingOrElseThrowWithTrueCondition() throws Exception {
        //Given
        String parameter = "Parameter";
        boolean condition = true;
        String startingValue = "Value";
        FluentConditionalsParametrizedReturningValue<String, String>  fluentConditionalsParametrizedReturningValue
                = new FluentConditionalsParametrizedReturningValue<>(parameter, condition, startingValue);
        Supplier<RuntimeException> supplier = RuntimeException::new;
        //When
        String returnedValue = fluentConditionalsParametrizedReturningValue
                .orElseThrow(supplier);
        //Then
        Assert.assertEquals(returnedValue, returnedValue);
    }
}

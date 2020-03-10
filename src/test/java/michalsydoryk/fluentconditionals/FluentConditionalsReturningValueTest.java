package michalsydoryk.fluentconditionals;

import org.testng.annotations.Test;

import java.util.function.Supplier;

import static org.testng.Assert.assertEquals;

@Test
public class FluentConditionalsReturningValueTest {
    public void shouldReturnValueGivenInOrElseAsArgument() {
        //Given
        boolean condition = false;
        int startingValue = 10;
        FluentConditionalsReturningValue<Integer> fluentConditionalsReturningValue
                = new FluentConditionalsReturningValue<>(condition, startingValue);
        int givenValue = 20;
        //When
        int returnedValue = fluentConditionalsReturningValue.orElse(givenValue);
        //Then
        assertEquals(returnedValue, givenValue);
    }

    public void shouldReturnValueGivenInOrElseBySupplier() {
        //Given
        boolean condition = false;
        int startingValue = 10;
        FluentConditionalsReturningValue<Integer> fluentConditionalsReturningValue
                = new FluentConditionalsReturningValue<>(condition, startingValue);
        int givenValue = 20;
        Supplier<Integer> supplier = () -> givenValue;
        //When
        int returnedValue = fluentConditionalsReturningValue.orElse(supplier);
        //Then
        assertEquals(returnedValue, givenValue);
    }

    public void shouldReturnStartingValueInOrElseWhenGivingAnotherValueByArgumentWithTrueCondition() {
        //Given
        boolean condition = true;
        int startingValue = 10;
        FluentConditionalsReturningValue<Integer> fluentConditionalsReturningValue
                = new FluentConditionalsReturningValue<>(condition, startingValue);
        int givenValue = 20;
        //When
        int returnedValue = fluentConditionalsReturningValue.orElse(givenValue);
        //Then
        assertEquals(returnedValue, startingValue);
    }

    public void shouldReturnStartingValueInOrElseWhenGivingAnotherValueBySupplierWithTrueCondition() {
        //Given
        boolean condition = true;
        int startingValue = 10;
        FluentConditionalsReturningValue<Integer> fluentConditionalsReturningValue
                = new FluentConditionalsReturningValue<>(condition, startingValue);
        int givenValue = 20;
        Supplier<Integer> supplier = () -> givenValue;
        //When
        int returnedValue = fluentConditionalsReturningValue.orElse(supplier);
        //Then
        assertEquals(returnedValue, startingValue);
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void shouldThrowExceptionAfterCallingOrElseThrowOnArgumentExceptionWithFalseCondition() throws Exception {
        //Given
        boolean condition = false;
        int startingValue = 10;
        FluentConditionalsReturningValue<Integer> fluentConditionalsReturningValue
                = new FluentConditionalsReturningValue<>(condition, startingValue);
        //When
        fluentConditionalsReturningValue.orElseThrow(new RuntimeException());

    }

    @Test(expectedExceptions = RuntimeException.class)
    public void shouldThrowExceptionAfterCallingOrElseThrowOnExceptionSupplierWithFalseCondition() throws Exception {
        //Given
        boolean condition = false;
        int startingValue = 10;
        FluentConditionalsReturningValue<Integer> fluentConditionalsReturningValue
                = new FluentConditionalsReturningValue<>(condition, startingValue);
        Supplier<RuntimeException> supplier = RuntimeException::new;
        //When
        fluentConditionalsReturningValue.orElseThrow(supplier);
    }

    public void shouldReturnStartingValueAfterCallingOrElseThrowOnArgumentExceptionWithTrueCondition() throws Exception {
        //Given
        boolean condition = true;
        int startingValue = 10;
        FluentConditionalsReturningValue<Integer> fluentConditionalsReturningValue
                = new FluentConditionalsReturningValue<>(condition, startingValue);
        //When
        int returnedValue = fluentConditionalsReturningValue
                .orElseThrow(new RuntimeException());
        //Then
        assertEquals(returnedValue, startingValue);

    }

    public void shouldReturnStartingValueAfterCallingOrElseThrowOnExceptionSupplierWithTrueCondition() throws Exception {
        //Given
        boolean condition = true;
        int startingValue = 10;
        FluentConditionalsReturningValue<Integer> fluentConditionalsReturningValue
                = new FluentConditionalsReturningValue<>(condition, startingValue);
        Supplier<RuntimeException> supplier = RuntimeException::new;
        //When
        int returnedValue = fluentConditionalsReturningValue
                .orElseThrow(supplier);
        //Then
        assertEquals(returnedValue, startingValue);
    }
}

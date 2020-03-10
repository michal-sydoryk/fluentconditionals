package michalsydoryk.fluentconditionals;

import java.util.function.Function;
import java.util.function.Supplier;

public class FluentConditionalsStarter {
    private boolean condition;

    private FluentConditionalsStarter(boolean condition) {
        this.condition = condition;
    }

    public static FluentConditionalsStarter when(boolean condition) {
        return new FluentConditionalsStarter(condition);
    }

    public static FluentConditionalsStarter when(Supplier<Boolean> supplier) {
        return new FluentConditionalsStarter(supplier.get());
    }

    public FluentConditionals then(Runnable runnable) {
        if (condition)
            runnable.run();
        return new FluentConditionals(condition);
    }

    public <T> FluentConditionalsReturningValue<T> thenReturn(T value) {
        return new FluentConditionalsReturningValue<>(condition, value);
    }

    public <T> FluentConditionalsReturningValue<T> thenReturn(Supplier<T> supplier) {
        return new FluentConditionalsReturningValue<>(condition, supplier.get());
    }

    public void thenThrow(Function<String, ? extends Exception> function, String message) throws Exception {
        if (!condition)
            throw function.apply(message);
    }
}

package michalsydoryk.fluentconditionals;

import java.util.function.Function;
import java.util.function.Supplier;

public class FluentConditionals {
    private boolean condition;
    public static Runnable doNothing = () -> {};

    public FluentConditionals(boolean condition) {
        this.condition = condition;
    }

    public Ender then(Runnable runnable) {
        return new Ender(this, runnable);
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

























    public void orElse(Runnable runnable){
        if (!condition)
            runnable.run();
    }

    public void orElseThrow(Exception exception) throws Exception {
        if (!condition)
            throw exception;
    }



    public void orElseThrow(Supplier<? extends Exception> supplier) throws Exception {
        if (!condition)
            throw supplier.get();
    }

    public void orElseThrow(Function<String, ? extends Throwable> function, String message) throws Throwable {
        if (!condition)
            throw function.apply(message);
    }
}

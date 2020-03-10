package michalsydoryk.fluentconditionals;

import java.util.function.Function;
import java.util.function.Supplier;

public class FluentConditionals {
    private boolean condition;
    public static Runnable doNothing = () -> {};

    public FluentConditionals(boolean condition) {
        this.condition = condition;
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

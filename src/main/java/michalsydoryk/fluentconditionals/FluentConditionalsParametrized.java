package michalsydoryk.fluentconditionals;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class FluentConditionalsParametrized<T> {
    private T parameter;
    private boolean condition;

    public FluentConditionalsParametrized(T parameter, boolean condition) {
        this.parameter = parameter;
        this.condition = condition;
    }

    public void orElse(Consumer<T> consumer){
        if(!condition)
            consumer.accept(parameter);
    }

    public void orElse(Runnable runnable){
        if(!condition)
            runnable.run();
    }

    public void orElseThrow(Exception exception) throws Exception {
        if (!condition)
            throw exception;
    }

    public void orElseThrow(Supplier<? extends Exception> supplier) throws Exception {
        if(!condition)
            throw supplier.get();
    }

    public static Runnable doNothing(){
        return () -> {};
    }
}

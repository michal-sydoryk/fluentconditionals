package michalsydoryk.fluentconditionals;

import java.util.function.Function;
import java.util.function.Supplier;

public class FluentConditionalsParametrizedReturningValue<T, R> {
    private T parameter;
    private boolean condition;
    private R value;

    public FluentConditionalsParametrizedReturningValue(T parameter, boolean condition, R value) {
        this.parameter = parameter;
        this.condition = condition;
        this.value = value;
    }

    public R orElse(Function<T, R> function){
        if (!condition)
            return function.apply(parameter);
        return value;
    }

    public R orElse(Supplier<R> supplier){
        if (!condition)
            return supplier.get();
        return value;
    }

    public R orElse(R object){
        if (!condition)
            return object;
        return value;
    }

    public R orElseThrow(Supplier<? extends Exception> supplier) throws Exception {
        if(!condition)
            throw supplier.get();
        return value;
    }

    public R orElseThrow(Function<String, ? extends Exception> function, String message) throws Exception {
        if (!condition)
            throw function.apply(message);
        return value;
    }
}

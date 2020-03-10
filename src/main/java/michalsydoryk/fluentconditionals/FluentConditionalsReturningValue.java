package michalsydoryk.fluentconditionals;

import java.util.function.Supplier;

public class FluentConditionalsReturningValue<T> {
    private boolean condition;
    private T value;

    public FluentConditionalsReturningValue(boolean condition, T value) {
        this.condition = condition;
        this.value = value;
    }

    public T orElse(T value){
        if(!condition)
            return value;
        return this.value;
    }

    public T orElse(Supplier<T> supplier){
        if(!condition)
            return supplier.get();
        return this.value;
    }

    public T orElseThrow(Exception exception) throws Exception {
        if(!condition)
            throw exception;
        return value;
    }

    public T orElseThrow(Supplier<? extends Exception> supplier) throws Exception {
        if(!condition)
            throw supplier.get();
        return value;
    }

}

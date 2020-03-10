package michalsydoryk.fluentconditionals;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class FluentConditionalsStarterParametrized<T> {
    private T parameter;
    private boolean condition;

    public FluentConditionalsStarterParametrized(T parameter) {
        this.parameter = parameter;
    }

    public static <T> FluentConditionalsStarterParametrized<T> given(T parameter){
        return new FluentConditionalsStarterParametrized<>(parameter);
    }

    public static <T> FluentConditionalsStarterParametrized<T> given(Supplier<T> supplier){
        return new FluentConditionalsStarterParametrized<>(supplier.get());
    }

    public FluentConditionalsStarterParametrized<T> when(boolean condition){
        this.condition = condition;
        return this;
    }

    public FluentConditionalsStarterParametrized<T> when(Supplier<Boolean> supplier){
        this.condition = supplier.get();
        return this;
    }

    public FluentConditionalsParametrized<T> then(Consumer<T> consumer){
        if (condition)
            consumer.accept(parameter);
        return new FluentConditionalsParametrized<>(parameter, condition);
    }

    public <R> FluentConditionalsParametrizedReturningValue<T, R> thenReturn(Function<T, R> function){
        R value = function.apply(parameter);
        return new FluentConditionalsParametrizedReturningValue<>(parameter, condition, value);
    }

    public <R> FluentConditionalsParametrizedReturningValue<T, R> thenReturn(Supplier<R> supplier){
        R value = supplier.get();
        return new FluentConditionalsParametrizedReturningValue<>(parameter, condition, value);
    }
}

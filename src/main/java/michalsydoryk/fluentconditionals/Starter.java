package michalsydoryk.fluentconditionals;

import java.util.function.Supplier;

public class Starter {
    public static FluentConditionals when(boolean condition) {
        return new FluentConditionals(condition);
    }

    public static FluentConditionals when(Supplier<Boolean> supplier) {
        return new FluentConditionals(supplier.get());
    }
}

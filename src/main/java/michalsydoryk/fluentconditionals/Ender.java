package michalsydoryk.fluentconditionals;

public class Ender {
    private boolean condition;
    private Runnable runnable;

    public Ender(boolean condition, Runnable runnable) {
        this.condition = condition;
        this.runnable = runnable;
    }

}

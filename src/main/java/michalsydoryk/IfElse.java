package michalsydoryk;

import static michalsydoryk.fluentconditionals.FluentConditionals.doNothing;
import static michalsydoryk.fluentconditionals.Starter.when;

//Task 1
public class IfElse {

    public static void main(String[] args) {

        when(TestHelper.somethingIsTrue())
                .then(TestHelper::printBar)
                .orElse(TestHelper::printFoo);
        //'Bar' printed to console

        when(TestHelper::somethingIsTrue)
                .then(TestHelper::printBar)
                .orElse(TestHelper::printFoo);
        //'Bar' printed to console


        when(!TestHelper.somethingIsTrue())
                .then(TestHelper::printBar)
                .orElse(doNothing);
        //nothing printed to console
    }
}

package michalsydoryk;


import static michalsydoryk.fluentconditionals.FluentConditionalsStarter.when;

//Task 2
public class IfExecuteElseThrow {

    public static void main(String[] args) throws Exception {

        when(TestHelper::somethingIsTrue)
                .then(TestHelper::printBar)
                .orElseThrow(new RuntimeException());
        //'Bar' printed to console

        when(TestHelper::somethingIsTrue)
                .then(TestHelper::printBar)
                .orElseThrow(RuntimeException::new);
        //'Bar' printed to console

        when(TestHelper::somethingIsTrue)
                .then(TestHelper::printBar)
                .orElseThrow(TestHelper::createException);
        //'Bar' printed to console

        when(!TestHelper.somethingIsTrue())
                .then(TestHelper::printFoo)
                .orElseThrow(TestHelper::createException);
        //exception thrown
    }
}

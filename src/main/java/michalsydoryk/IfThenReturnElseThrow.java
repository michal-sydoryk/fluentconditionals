package michalsydoryk;


import static michalsydoryk.fluentconditionals.Starter.when;

//Task 4
public class IfThenReturnElseThrow {

    public static void main(String[] args) throws Exception {

        int result3 = when(TestHelper::somethingIsTrue)
                .thenReturn(TestHelper::getLowNumber)
                .orElseThrow(new RuntimeException());
        System.out.println(result3);//1

        int result4 = when(!TestHelper.somethingIsTrue())
                .thenReturn(TestHelper::getLowNumber)
                .orElseThrow(RuntimeException::new);
        //exception thrown
    }
}

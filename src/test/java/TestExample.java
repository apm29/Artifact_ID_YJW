import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;


@RunWith(BlockJUnit4ClassRunner.class)
public class TestExample extends UnitTestBase{

    public TestExample() {
        super("classpath*:spring-context.xml");
    }

    @Test
    public void Test(){
        System.out.println("test");
        com.yjw.shirly.test.Test test = super.getBean("oneInterface");
        test.print();
    }
}

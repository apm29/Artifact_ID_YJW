import org.junit.After;
import org.junit.Before;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UnitTestBase {
    private ClassPathXmlApplicationContext context;

    private String springXmlpath;

    public UnitTestBase() {}

    public UnitTestBase(String springXmlpath) {
        this.springXmlpath = springXmlpath;
    }

    @Before
    public void before() {
        if (springXmlpath==null||springXmlpath.equals("")) {
            springXmlpath = "classpath*:spring-*.xml";
        }
        System.out.println(springXmlpath);
        try {
            context = new ClassPathXmlApplicationContext(springXmlpath.split("[,\\s]+"));
            context.start();
        } catch (BeansException e) {
            e.printStackTrace();
        }
    }

    @After
    public void after() {
        context.close();
    }

    @SuppressWarnings("unchecked")
    protected <T extends Object> T getBean(String beanId) {
        try {
            return (T)context.getBean(beanId);
        } catch (BeansException e) {
            e.printStackTrace();
            return null;
        }
    }

    protected <T extends Object> T getBean(Class<T> clazz) {
        try {
            return context.getBean(clazz);
        } catch (BeansException e) {
            e.printStackTrace();
            return null;
        }
    }
}

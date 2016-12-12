import executors.TestExecutor;

public class TestMain {

    public static void main(String[] args) throws Exception {
        TestExecutor.executeChromeTests();
        TestExecutor.executeFirefoxTests();
        TestExecutor.executeHtmlUnitTests();
        TestExecutor.executePhantomJSTests();
    }
}

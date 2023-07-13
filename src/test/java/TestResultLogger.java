import org.junit.AssumptionViolatedException;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class TestResultLogger extends TestWatcher {

    @Override
    protected void succeeded(Description description) {
        super.succeeded(description);
    }

    @Override
    protected void failed(Throwable e, Description description) {
        super.failed(e, description);
    }

    @Override
    protected void skipped(AssumptionViolatedException e, Description description) {
        super.skipped(e, description);
    }

    @Override
    protected void starting(Description description) {
        super.starting(description);
    }

    @Override
    protected void finished(Description description) {
        super.finished(description);
    }
}

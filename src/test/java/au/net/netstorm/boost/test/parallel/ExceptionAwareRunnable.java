package au.net.netstorm.boost.test.parallel;

import au.net.netstorm.boost.util.exception.DefaultThrowableMaster;
import au.net.netstorm.boost.util.exception.ThrowableMaster;

public class ExceptionAwareRunnable implements Runnable {
    private ThrowableMaster tosser = new DefaultThrowableMaster();
    private final Runnable delegate;
    private final Errors throwables;

    public ExceptionAwareRunnable(Runnable delegate, Errors throwables) {
        this.delegate = delegate;
        this.throwables = throwables;
    }

    public void run() {
        try {
            delegate.run();
        } catch (Throwable t) {
            throwables.thrown(t);
            tosser.rethrow(t);
        }
    }
}

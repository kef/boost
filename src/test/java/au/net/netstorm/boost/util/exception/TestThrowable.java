package au.net.netstorm.boost.util.exception;

import java.io.PrintWriter;

final class TestThrowable extends Throwable {
    private final String stackTrace;

    public TestThrowable(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    public void printStackTrace(PrintWriter printWriter) {
        printWriter.print(stackTrace);
    }
}

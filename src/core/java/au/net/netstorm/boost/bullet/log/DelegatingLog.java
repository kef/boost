package au.net.netstorm.boost.bullet.log;

import static au.net.netstorm.boost.bullet.log.LogLevel.TRACE;
import static au.net.netstorm.boost.bullet.log.LogLevel.INFO;
import static au.net.netstorm.boost.bullet.log.LogLevel.WARN;
import static au.net.netstorm.boost.bullet.log.LogLevel.ERROR;

public final class DelegatingLog implements Log {
    private final LogEngine delegate;

    public DelegatingLog(LogEngine delegate) {
        this.delegate = delegate;
    }

    public void trace(Object o) {
        log(TRACE, o);
    }

    public void trace(Throwable t) {
        log(TRACE, t);
    }

    public void trace(Object o, Throwable t) {
        log(TRACE, o, t);
    }

    public void info(Object o) {
        log(INFO, o);
    }

    public void info(Throwable t) {
        log(INFO, t);
    }

    public void info(Object o, Throwable t) {
        log(INFO, o, t);
    }

    public void warn(Object o) {
        log(WARN, o);
    }

    public void warn(Throwable t) {
        log(WARN, t);
    }

    public void warn(Object o, Throwable t) {
        log(WARN, o, t);
    }

    public void error(Object o) {
        log(ERROR, o);
    }

    public void error(Throwable t) {
        log(ERROR, t);
    }

    public void error(Object o, Throwable t) {
        log(ERROR, o, t);
    }

    public void log(LogLevel level, Object o) {
        delegate.log(level, o);
    }

    public void log(LogLevel level, Throwable t) {
        delegate.log(level, t);
    }

    public void log(LogLevel level, Object o, Throwable t) {
        delegate.log(level, o, t);
    }

    public boolean levelEnabled(LogLevel level) {
        return delegate.levelEnabled(level);
    }
}

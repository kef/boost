package au.net.netstorm.boost.log;

public interface LogEngine {
    void log(LogLevel level, Object o);

    void log(LogLevel level, Throwable t);

    void log(LogLevel level, Object o, Throwable t);

    boolean levelEnabled(LogLevel level);
}

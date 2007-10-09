package au.net.netstorm.boost.nursery.log;

public interface LogNice {
    void trace(Object o);

    void trace(Throwable t);

    void trace(Object o, Throwable t);

    void debug(Object o);

    void debug(Throwable t);

    void debug(Object o, Throwable t);

    void info(Object o);

    void info(Throwable t);

    void info(Object o, Throwable t);

    void warn(Object o);

    void warn(Throwable t);

    void warn(Object o, Throwable t);

    void error(Object o);

    void error(Throwable t);

    void error(Object o, Throwable t);
}

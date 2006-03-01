package au.net.netstorm.boost.util.reflect;

public interface ExceptionTestUtil {
    Class getRealExceptionClass(Throwable t); // FIXME: SC042 This belongs elsewhere (ExceptionTestUtil?).
}

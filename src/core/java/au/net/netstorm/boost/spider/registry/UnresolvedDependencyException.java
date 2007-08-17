package au.net.netstorm.boost.spider.registry;

import java.lang.reflect.Field;

public final class UnresolvedDependencyException extends RuntimeException {

    public UnresolvedDependencyException(Field field, Throwable cause) {
        super("Cannot resolve '" + field + "'.", cause);
    }
}

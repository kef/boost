package au.net.netstorm.boost.sledge.java.lang.reflect;

import java.lang.annotation.Annotation;

// FIX Not a stateless edge.
public interface Method {
    String getName();

    Object invoke(Object ref, Object... args);

    // FIX 2130 Remove this shite.
    // FIX  Don't cry... :(
    boolean isAnnotationPresent(Class<? extends Annotation> cls);

    <T extends Annotation> T getAnnotation(Class<T> cls);

    Class<?> getDeclaringClass();
}

package au.net.netstorm.boost.sledge.java.lang.reflect;

// FIX Not a stateless edge.
public interface Method {
    String getName();

    Object invoke(Object ref, Object... args);

    Class<?> getDeclaringClass();
}

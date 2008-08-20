package au.net.netstorm.boost.sledge.java.lang.reflect;

public interface Method {
    String getName();

    Object invoke(Object ref, Object... args);

    Class<?> getDeclaringClass();
}

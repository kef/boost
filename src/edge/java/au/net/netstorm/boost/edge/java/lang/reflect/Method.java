package au.net.netstorm.boost.edge.java.lang.reflect;

public interface Method {
    Object invoke(Object ref, Object... args);

    String getName();
}

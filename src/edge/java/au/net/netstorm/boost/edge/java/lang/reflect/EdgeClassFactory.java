package au.net.netstorm.boost.edge.java.lang.reflect;

public interface EdgeClassFactory {
    EdgeClass get(Class cls);

    EdgeClass get(String className);
}

package au.net.netstorm.boost.edge.java.lang;

public interface EdgeClassFactory {
    EdgeClass get(Class cls);

    EdgeClass get(String className);
}

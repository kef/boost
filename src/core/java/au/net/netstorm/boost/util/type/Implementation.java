package au.net.netstorm.boost.util.type;

public interface Implementation extends Data {
    Interface[] getTypes();

    Class getImpl();

    boolean is(Interface iface);
}

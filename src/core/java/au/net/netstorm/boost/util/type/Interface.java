package au.net.netstorm.boost.util.type;

public interface Interface extends Data {
    Class getType();

    boolean is(Interface iface);
}

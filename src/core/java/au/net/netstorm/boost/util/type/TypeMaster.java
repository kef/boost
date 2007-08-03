package au.net.netstorm.boost.util.type;

public interface TypeMaster {
    boolean implementz(Implementation impl, Interface iface);

    Interface[] declaredInterfaces(Implementation impl);

    boolean extendz(Interface sub, Interface supa);
}

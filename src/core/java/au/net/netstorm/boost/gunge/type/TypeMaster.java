package au.net.netstorm.boost.gunge.type;

public interface TypeMaster {
    Interface[] interfaces(Interface iface);

    Interface[] interfaces(Implementation impl);

    Interface[] declaredInterfaces(Interface iface);

    Interface[] declaredInterfaces(Implementation impl);

    boolean implementz(Implementation impl, Interface iface);

    boolean extendz(Interface sub, Interface supa);
}

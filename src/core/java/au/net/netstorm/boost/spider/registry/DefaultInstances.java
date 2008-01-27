package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.flavour.DefaultStrictMap;
import au.net.netstorm.boost.spider.flavour.StrictMap;
import au.net.netstorm.boost.util.array.ArrayMaster;
import au.net.netstorm.boost.util.array.DefaultArrayMaster;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultTypeMaster;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;
import au.net.netstorm.boost.util.type.TypeMaster;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public final class DefaultInstances implements Instances {
    private final StrictMap map = new DefaultStrictMap();
    private final TypeMaster typer = new DefaultTypeMaster();
    private final ArrayMaster arrays = new DefaultArrayMaster();

    public synchronized void put(Interface iface, Implementation impl, ResolvedInstance instance) {
        check(impl, instance);
        List key = getKey(iface, impl);
        map.put(key, instance);
    }

    public synchronized ResolvedInstance get(Interface iface, Implementation impl) {
        List key = getKey(iface, impl);
        return (ResolvedInstance) map.get(key);
    }

    public synchronized boolean exists(Interface iface, Implementation impl) {
        List key = getKey(iface, impl);
        return map.exists(key);
    }

    private List getKey(Interface iface, Implementation impl) {
        List tuple = new ArrayList();
        tuple.add(iface);
        tuple.add(impl);
        return tuple;
    }

    // FIX ()   94156 Clean up. Ugly Betty strikes again....
    private void check(Implementation impl, ResolvedInstance instance) {
        Class type = impl.getImpl();
        Object ref = instance.getRef();
        Class cls = ref.getClass();
        if (type.isAssignableFrom(cls)) return;
        Implementation proxy = new DefaultImplementation(cls);
        if (Proxy.class.isAssignableFrom(cls) && xxx(impl, proxy)) return;
        throw new WrongRegistrationTypeException(impl);
    }

    // FIX ()   94156 Rip out.
    // FIX ()   94156 Rename.
    private boolean xxx(Implementation real, Implementation proxy) {
        Interface[] expected = typer.declaredInterfaces(real);
        Interface[] actual = typer.declaredInterfaces(proxy);
        for (Interface iface : expected) {
            if (!arrays.contains(actual, iface)) return false;
        }
        return true;
    }
}
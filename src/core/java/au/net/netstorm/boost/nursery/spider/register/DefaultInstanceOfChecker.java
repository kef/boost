package au.net.netstorm.boost.nursery.spider.register;

import java.lang.reflect.Proxy;
import au.net.netstorm.boost.gunge.array.ArrayMaster;
import au.net.netstorm.boost.gunge.array.DefaultArrayMaster;
import au.net.netstorm.boost.gunge.type.DefaultImplementation;
import au.net.netstorm.boost.gunge.type.DefaultTypeMaster;
import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.gunge.type.Interface;
import au.net.netstorm.boost.gunge.type.Reference;
import au.net.netstorm.boost.gunge.type.TypeMaster;
import au.net.netstorm.boost.spider.registry.InstanceOfChecker;
import au.net.netstorm.boost.spider.registry.WrongRegistrationTypeException;

// FIX 2299 Move out of "nursery".

// FIX ()   2255 Clean up.
public final class DefaultInstanceOfChecker implements InstanceOfChecker {
    private final TypeMaster typer = new DefaultTypeMaster();
    private final ArrayMaster arrays = new DefaultArrayMaster();

    // FIX ()   2255 Ugly Betty strikes again....
    public void instanceOf(Reference instance, Implementation impl) {
        Class type = impl.getImpl();
        Object ref = instance.getRef();
        Class cls = ref.getClass();
        if (type.isAssignableFrom(cls)) return;
        Implementation proxy = new DefaultImplementation(cls);
        if (Proxy.class.isAssignableFrom(cls) && xxx(impl, proxy)) return;
        throw new WrongRegistrationTypeException(impl);
    }

    // FIX ()   2255 Rename.
    private boolean xxx(Implementation real, Implementation proxy) {
        Interface[] expected = typer.declaredInterfaces(real);
        Interface[] actual = typer.declaredInterfaces(proxy);
        for (Interface iface : expected) {
            if (!arrays.contains(actual, iface)) return false;
        }
        return true;
    }
}

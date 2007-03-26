package au.net.netstorm.boost.pebble.resolve;

import java.lang.reflect.Constructor;
import au.net.netstorm.boost.pebble.core.PebbleProviderEngine;
import au.net.netstorm.boost.pebble.inject.resolver.core.Finder;
import au.net.netstorm.boost.reflect.DefaultReflectMaster;
import au.net.netstorm.boost.reflect.ReflectMaster;
import au.net.netstorm.boost.util.type.DefaultInterfaceUtil;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Instance;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.InterfaceUtil;

public final class DefaultResolver implements Resolver {
    private final InterfaceUtil interfacer = new DefaultInterfaceUtil();
    private final ReflectMaster reflector = new DefaultReflectMaster();
    private final PebbleProviderEngine provider;
    private final Finder finder;

    // FIX BREADCRUMB 32755 Look at test.  Just changed RegistryMaster to Finder.
    public DefaultResolver(PebbleProviderEngine provider, Finder finder) {
        this.provider = provider;
        this.finder = finder;
    }

    // FIX BREADCRUMB 32755 Return Instance?
    public Object resolve(Interface iface) {
        // FIX 32755 What about onionising the instance?
        if (hasInstance(iface)) return getInstance(iface);
        Implementation impl = finder.getImplementation(iface);
        return resolve(impl);
    }

    // FIX BREADCRUMB 32755 Return Instance?
    public Object resolve(Implementation impl) {
        Class[] parameters = getParameters(impl);
        Object[] resolved = resolve(parameters);
        return provider.provide(impl, resolved);
    }

    // FIX BREADCRUMB 32755 Return Instances?
    public Object[] resolve(Interface[] ifaces) {
        int length = ifaces.length;
        Object[] result = new Object[length];
        for (int i = 0; i < length; i++) {
            result[i] = resolve(ifaces[i]);
        }
        return result;
    }

    private Object[] resolve(Class[] parameters) {
        Interface[] unresolved = interfacer.interfaces(parameters);
        return resolve(unresolved);
    }

    // SUGGEST: This really belongs in the pebble constructor area.  It is injection specific.
    private Class[] getParameters(Implementation impl) {
        Class cls = impl.getImpl();
        Constructor constructor = reflector.getConstructor(cls);
        return constructor.getParameterTypes();
    }

    private Object getInstance(Interface iface) {
        Instance instance = finder.getInstance(iface);
        return instance.getRef();
    }

    private boolean hasInstance(Interface iface) {
        return finder.hasInstance(iface);
    }
}
/*
             ./' .v~__,/~ _____   _____     _____   )~\      _____     _____
           ./  .(W---\| /',---.`\ |\./\     |\./|  / | \     |\./\     |\./|
          ,|  /<M.    ./././~\`\ \| |\ \    | | |././^\ \    | |\ \    | | |
\~b__________/$@|\------------\ \ \--\`\`\--| | |----^ \ \------\`\`\--| | |-.
 >@)$$$$$$$$($( )#H>===========) ) )==`\`\`\| | |=====\ \ \======`\`\`\| | |-->
/_p~~~~~~~~~~\$@|/------------/ / /-----`\`\\ | |------\ \ \-------`\`\\ | |-'
          `|  \<M`    `\ \`\_/ / /| | |   `\`\| | /'    \ \ \| | |   `\`\| |
           `\  `(B---/| \ `---' / |/^\|     \ | |/       \/^\\.^\|     \ | |
             `\  `?_~~`\_`~~~~~`  ~~~~~      )^\,\,      `~~~~~~~~      )^\,\,
               `~~~~~~~~~~        CROM       ~~~~~~                     ~~~~~~
*/

package au.net.netstorm.boost.pebble.resolve;

import java.lang.reflect.Constructor;
import au.net.netstorm.boost.pebble.core.PebbleProviderEngine;
import au.net.netstorm.boost.pebble.inject.resolver.core.RegistryEngine;
import au.net.netstorm.boost.reflect.DefaultReflectMaster;
import au.net.netstorm.boost.reflect.ReflectMaster;
import au.net.netstorm.boost.util.type.DefaultInterfaceUtil;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.InterfaceUtil;

public final class DefaultResolver implements Resolver {
    private final InterfaceUtil interfacer = new DefaultInterfaceUtil();
    private final ReflectMaster reflector = new DefaultReflectMaster();
    private final PebbleProviderEngine provider;
    private final RegistryEngine registryEngine;

    public DefaultResolver(PebbleProviderEngine provider, RegistryEngine registryEngine) {
        this.provider = provider;
        this.registryEngine = registryEngine;
    }

    public Object resolve(Interface iface) {
        // FIX BREADCRUMB 1824 Test-drive this bad boy up.
//        if (registryEngine.hasInstance(iface)) {
//            Instance instance = registryEngine.getInstance(iface);
//            return instance.getRef();
//        }
        Implementation impl = registryEngine.getImplementation(iface);
        return resolve(impl);
    }

    public Object resolve(Implementation impl) {
        Class[] parameters = getParameters(impl);
        Object[] resolved = resolve(parameters);
        return provider.provide(impl, resolved);
    }

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

package au.net.netstorm.boost.spider.resolve;

import java.lang.reflect.Constructor;
import au.net.netstorm.boost.reflect.DefaultReflectMaster;
import au.net.netstorm.boost.reflect.ReflectMaster;
import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.util.type.DefaultInterfaceUtil;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.InterfaceUtil;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultResolver implements Resolver {
    private final InterfaceUtil interfacer = new DefaultInterfaceUtil();
    private final ReflectMaster reflector = new DefaultReflectMaster();
    private final ProviderEngine provider;
    private final Finder finder;

    public DefaultResolver(ProviderEngine provider, Finder finder) {
        this.provider = provider;
        this.finder = finder;
    }

    public ResolvedInstance resolve(Interface iface) {
        if (hasInstance(iface)) return getInstance(iface);
        Implementation impl = finder.getImplementation(iface);
        return resolve(impl);
    }

    public ResolvedInstance resolve(Implementation impl) {
        Class[] parameters = getParameters(impl);
        Object[] resolved = resolve(parameters);
        return provider.provide(impl, resolved);
    }

    public ResolvedInstance[] resolve(Interface[] ifaces) {
        int length = ifaces.length;
        ResolvedInstance[] result = new ResolvedInstance[length];
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

    private ResolvedInstance getInstance(Interface iface) {
        // FIX 1887 What about onionising the instance?
        return finder.getInstance(iface);
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

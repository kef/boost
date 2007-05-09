package au.net.netstorm.boost.spider.resolve;

import java.lang.reflect.Constructor;
import au.net.netstorm.boost.reflect.DefaultReflectMaster;
import au.net.netstorm.boost.reflect.ReflectMaster;
import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.spider.inject.newer.assembly.DefaultNewerAssembler;
import au.net.netstorm.boost.spider.inject.newer.assembly.NewerAssembler;
import au.net.netstorm.boost.spider.inject.newer.core.Newer;
import au.net.netstorm.boost.util.type.DefaultBaseReference;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.DefaultInterfaceUtil;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.InterfaceUtil;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultResolverEngine implements ResolverEngine {
    private static final Interface NEWER = new DefaultInterface(Newer.class);
    private final InterfaceUtil interfacer = new DefaultInterfaceUtil();
    private final ReflectMaster reflector = new DefaultReflectMaster();
    private final NewerAssembler newerAssembler = new DefaultNewerAssembler();
    private final ProviderEngine provider;
    private final FinderEngine finder;

    public DefaultResolverEngine(ProviderEngine provider, FinderEngine finder) {
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
        Object[] resolvedParams = resolve(parameters);
        return provider.provide(impl, resolvedParams);
    }

    public Object[] resolve(Interface[] ifaces) {
        int length = ifaces.length;
        Object[] result = new Object[length];
        for (int i = 0; i < length; i++) {
            ResolvedInstance resolvedInstance = resolve(ifaces[i]);
            result[i] = resolvedInstance.getRef();
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
        if (iface.is(NEWER)) return aNewer(iface);
        return finder.getInstance(iface);
    }

    private boolean hasInstance(Interface iface) {
        if (iface.is(NEWER)) return true;
        return finder.hasInstance(iface);
    }

    private ResolvedInstance aNewer(Interface iface) {
        Newer newer = (Newer) newerAssembler.assemble(iface);
        return new DefaultBaseReference(newer);
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

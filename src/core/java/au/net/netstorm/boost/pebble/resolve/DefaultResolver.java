package au.net.netstorm.boost.pebble.resolve;

import java.lang.reflect.Constructor;
import au.net.netstorm.boost.pebble.core.PebbleProviderEngine;
import au.net.netstorm.boost.pebble.inject.resolver.core.ImplementationLookup;
import au.net.netstorm.boost.reflect.DefaultReflectMaster;
import au.net.netstorm.boost.reflect.ReflectMaster;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultResolver implements Resolver {
    private final ReflectMaster reflector = new DefaultReflectMaster();
    private final PebbleProviderEngine provider;
    private final ImplementationLookup lookup;

    public DefaultResolver(PebbleProviderEngine provider, ImplementationLookup lookup) {
        this.provider = provider;
        this.lookup = lookup;
    }

    public Object resolve(Interface iface) {
        Implementation impl = lookup.find(iface);
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
        Interface[] unresolved = interfaces(parameters);
        return resolve(unresolved);
    }

    // FIX 1779 Move into utility.
    private Interface[] interfaces(Class[] parameters) {
        int length = parameters.length;
        Interface[] result = new Interface[length];
        for (int i = 0; i < length; i++) {
            result[i] = new DefaultInterface(parameters[i]);
        }
        return result;
    }

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
               `~~~~~~~~~~                   ~~~~~~                     ~~~~~~
*/

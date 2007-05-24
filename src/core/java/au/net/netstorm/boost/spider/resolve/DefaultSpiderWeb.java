package au.net.netstorm.boost.spider.resolve;

import au.net.netstorm.boost.util.type.DefaultBaseReference;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultSpiderWeb implements SpiderWeb {
    private final WebSpinnerEngine spinnerEngine;

    public DefaultSpiderWeb(WebSpinnerEngine spinnerEngine) {
        this.spinnerEngine = spinnerEngine;
    }

    public void prototype(Class iface, Class impl) {
        Interface inyerface = new DefaultInterface(iface);
        Implementation implementation = new DefaultImplementation(impl);
        spinnerEngine.implementation(inyerface, implementation);
    }

    public void instance(Class iface, Object ref) {
        Interface inyerface = new DefaultInterface(iface);
        ResolvedInstance instance = new DefaultBaseReference(ref);
        spinnerEngine.instance(inyerface, instance);
    }
}

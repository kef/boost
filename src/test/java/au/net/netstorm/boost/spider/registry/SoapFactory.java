package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public final class SoapFactory implements Factory {
    public Blueprint get(Interface iface, Implementation host) {
        throw new UnsupportedOperationException();
    }

    public boolean canHandle(Interface iface) {
        throw new UnsupportedOperationException();
    }
}

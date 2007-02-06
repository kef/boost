package au.net.netstorm.boost.nursery.pebble.create;

import au.net.netstorm.boost.util.type.Interface;

// FIX 1665 Narrow scope in this package.  Probably CreatorInjector is the only one to expose.µ
public interface CreatorProxySupplier {
    Object create(Interface type);
}

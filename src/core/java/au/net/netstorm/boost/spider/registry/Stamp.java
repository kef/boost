package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.util.type.Immutable;

// FIX 2081 Make extend enumeration.

// FIX 2081 Make sure all extraneous usages of MULTIPLE have been locked down.

// OK InterfaceIsType {
public interface Stamp extends Immutable {
    Stamp MULTIPLE = new DefaultStamp("MULTIPLE");
    Stamp SINGLE = new DefaultStamp("SINGLE");
} // } OK InterfaceIsType


package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.util.type.Immutable;

// OK InterfaceIsType {
public interface Stamp extends Immutable {
    Stamp MULTIPLE = new DefaultStamp("MULTIPLE");
    Stamp SINGLE = new DefaultStamp("SINGLE");
} // } OK InterfaceIsType


package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.gunge.type.Immutable;

// OK InterfaceIsType {
public interface Stamp extends Immutable {
    // FIX 1914 Multiples go!!!!!!!!!!!!!
    // FIX 2248 Looks like an enum.
    Stamp MULTIPLE = new DefaultStamp("MULTIPLE");
    Stamp SINGLE = new DefaultStamp("SINGLE");
} // } OK InterfaceIsType


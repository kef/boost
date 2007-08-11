package au.net.netstorm.boost.spider.registry;

// FIX 2081 Make extend enumeration.

// OK InterfaceIsType {
public interface Stamp {
    Stamp MULTIPLE = new DefaultStamp("MULTIPLE");
    Stamp SINGLE = new DefaultStamp("SINGLE");
} // } OK InterfaceIsType


package au.net.netstorm.boost.nursery.time;

import au.net.netstorm.boost.gunge.type.Immutable;

// OK InterfaceIsType {
public interface TimeType extends Immutable {
    TimeType RELATIVE = new DefaultTimeType("RELATIVE");
    TimeType ABSOLUTE = new DefaultTimeType("ABSOLUTE");
    TimeType NONE = new DefaultTimeType("NONE");
} // } OK InterfaceIsType

package au.net.netstorm.boost.demo.retireddata;

import au.net.netstorm.boost.gunge.type.Data;
import au.net.netstorm.boost.gunge.type.LooseData;

interface NestedNonImmutableInterface extends Data, LooseData {
    String getGuitar();

    NonImmutableInterface getNonImmutable();
}

package au.net.netstorm.boost.demo.data;

import au.net.netstorm.boost.util.type.Data;
import au.net.netstorm.boost.util.type.LooseData;

interface NestedNonImmutableInterface extends Data, LooseData {
    String getGuitar();

    NonImmutableInterface getNonImmutable();
}

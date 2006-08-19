package au.net.netstorm.boost.demo.data;

import au.net.netstorm.boost.util.type.Data;

interface NestedNonImmutableInterface extends Data {
    String getGuitar();

    NonImmutableInterface getNonImmutable();
}

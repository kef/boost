package au.net.netstorm.boost.demo.pebble.fixtures;

import au.net.netstorm.boost.nursery.pebble.create.Creator;

public interface NewDefaultBob extends Creator {
    // FIX BREADCRUMB 1665 MUST RETURN Bob.
    DefaultBob create(String comment);
}

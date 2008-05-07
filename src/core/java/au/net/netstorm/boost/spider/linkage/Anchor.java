package au.net.netstorm.boost.spider.linkage;

import au.net.netstorm.boost.gunge.type.Data;

// FIX 2363 wire into linkage, will eventually abstract out the anchor totally field vs name
public interface Anchor extends Data {
    String getName();
}

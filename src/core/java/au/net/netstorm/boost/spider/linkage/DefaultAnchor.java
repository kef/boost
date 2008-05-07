package au.net.netstorm.boost.spider.linkage;

import au.net.netstorm.boost.bullet.primordial.Primordial;

//FIX 2363 wire into linkage, will eventually abstract out the anchor totally field vs name
public final class DefaultAnchor extends Primordial implements Anchor {
    private final String name;

    public DefaultAnchor(String name) {
        this.name = name;
        if (this.name == null) throw new IllegalArgumentException();
    }

    public String getName() {
        return name;
    }
}

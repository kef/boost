package au.net.netstorm.boost.demo.nuspider.lifecycle.constructable;

import au.net.netstorm.boost.spider.core.Constructable;

public final class DefaultConstructableThing implements ConstructableSingle, ConstructableMulti, Constructable {
    private int count;

    public void constructor() {
        ++count;
    }

    public int constructionCount() {
        return count;
    }
}

package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultStampedResolvedInstance extends Primordial implements StampedResolvedInstance {
    private final ResolvedInstance instance;
    private final Stamp stamp;

    public DefaultStampedResolvedInstance(ResolvedInstance instance, Stamp stamp) {
        validate(instance, stamp);
        this.instance = instance;
        this.stamp = stamp;
    }

    public ResolvedInstance getInstance() {
        return instance;
    }

    public Stamp getStamp() {
        return stamp;
    }

    private void validate(ResolvedInstance instance, Stamp stamp) {
        if (instance == null) boom();
        if (stamp == null) boom();
    }

    private void boom() {
        throw new IllegalArgumentException();
    }
}

package au.net.netstorm.boost.nursery.spider.onion.core;

public interface Peeler {

    Object peel(Object ref);

    boolean peelable(Object ref);
}

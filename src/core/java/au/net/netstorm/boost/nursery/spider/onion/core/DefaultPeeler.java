package au.net.netstorm.boost.nursery.spider.onion.core;

public final class DefaultPeeler implements Peeler {

    public Object peel(Object ref) {
        if (!peelable(ref)) return ref;
        return ((OnionSkin) ref).real();
    }

    public boolean peelable(Object ref) {
        return OnionSkin.class.isAssignableFrom(ref.getClass());
    }
}

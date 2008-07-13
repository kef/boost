package au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites;

public interface FieldInjectionSite extends InjectionSite {
    // FIX 2394 name for o
    void inject(Object ref, Object resolved);

    // FIX 2394 name for o ... "ref" is pretty bloody good for me.
    boolean isWired(Object ref);
}

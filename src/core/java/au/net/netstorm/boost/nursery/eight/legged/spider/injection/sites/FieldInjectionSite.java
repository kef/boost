package au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites;

public interface FieldInjectionSite extends InjectionSite {
    void inject(Object ref, Object resolved);
    boolean isWired(Object ref);
}

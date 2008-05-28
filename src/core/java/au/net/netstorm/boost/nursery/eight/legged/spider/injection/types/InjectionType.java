package au.net.netstorm.boost.nursery.eight.legged.spider.injection.types;

// FIX 2328 smart type, injection sites have types, rules have a relationship with types
public interface InjectionType {
    InjectionType raw();
    InjectionType[] parameters();
    Class<?> rawClass();
}

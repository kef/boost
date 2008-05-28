package au.net.netstorm.boost.nursery.eight.legged.spider.injection.types;

public interface InjectionTypeChecker {
    void checkType(InjectionType subject, InjectionType raw, Class<?> rawClass);
}

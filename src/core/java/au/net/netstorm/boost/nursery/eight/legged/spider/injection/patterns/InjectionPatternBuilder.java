package au.net.netstorm.boost.nursery.eight.legged.spider.injection.patterns;

import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;

public interface InjectionPatternBuilder {
    InjectionPattern pattern(Class<?> host, Class<?> type, String name);
    InjectionPattern pattern(Implementation host, InjectionType type, String name);
}
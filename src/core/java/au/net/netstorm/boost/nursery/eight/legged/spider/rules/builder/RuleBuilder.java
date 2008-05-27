package au.net.netstorm.boost.nursery.eight.legged.spider.rules.builder;

// FIX 2394 experiment in a tidy way to build rules
public interface RuleBuilder {
    // FIX 2394 add some strong typing here 
    RuleTarget multi(Class<?> type);
    RuleTarget single(Class<?> type);
    WildcardTarget single(TypeMatcher matcher);
    WildcardTarget multi(TypeMatcher matcher);
}

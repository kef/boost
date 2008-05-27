package au.net.netstorm.boost.nursery.eight.legged.spider.rules.builder;

// FIX 2394 experiment in a tidy way to build rules (from part)
public interface RuleBuilder {
    RuleTarget multi(Class<?> type);
    RuleTarget single(Class<?> type);
}

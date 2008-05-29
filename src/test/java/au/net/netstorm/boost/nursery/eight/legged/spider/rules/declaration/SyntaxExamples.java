package au.net.netstorm.boost.nursery.eight.legged.spider.rules.declaration;

import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.Factory;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.types.Provider;
import au.net.netstorm.boost.nursery.eight.legged.spider.config.RuleConfig;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.oldbuilder.RuleBuilder;

public final class SyntaxExamples {
    Ruler rule;
    Factory wildcardFactory;
    Factory treeFactory;
    Provider treeProvider;
    Rules rules;
    {
        // iface -> impl
        rule.map(Tree.class).to(GreenTree.class);

        // iface -> impl as a singletion
        rule.map(Tree.class).to(GreenTree.class).asSingle();

        // iface -> impl only for host
        rule.map(Tree.class).to(DeadTree.class).in(TreeHolder.class);

        // iface -> impl only for host as a singleton
        rule.map(Tree.class).to(DeadTree.class).in(TreeHolder.class).asSingle();

        // iface -> factory (optionaly restricted in() and asSingle() as above)
        rule.map(Tree.class).to(treeFactory);

        // iface -> provider (optionaly restricted in() and asSingle() as avove)
        rule.map(Tree.class).to(treeProvider);

        // register all rules in RuleConfig
        rule.mapAll(rules);

        // register a wildcarded factory
        rule.register(wildcardFactory);
    }


    private static class Rules implements RuleConfig {
        public void apply(RuleBuilder rule) {
            // FIX 2394 to be updated to new Ruler
        }
    }
}

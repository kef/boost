package au.net.netstorm.boost.nursery.eight.legged.spider.rules.declaration;

import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.Factory;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.types.Provider;

public final class SyntaxExamples {
    Ruler rule;
    Factory wildcardFactory;
    Factory treeFactory;
    Provider treeProvider;
    {
        // iface -> impl (default currently multi could be changed)
        rule.map(Tree.class).to(GreenTree.class);

        // iface -> impl as a singleton
        rule.map(Tree.class).to(GreenTree.class).asSingle();

        // iface -> impl as explicit multiton
        rule.map(Tree.class).to(GreenTree.class).asMulti();

        // iface -> impl only for host
        rule.map(Tree.class).to(DeadTree.class).in(TreeHolder.class);

        // iface -> impl only for host as a singleton
        rule.map(Tree.class).to(DeadTree.class).in(TreeHolder.class).asSingle();

        // iface -> factory (optionaly restricted in() and asSingle() as above)
        rule.map(Tree.class).to(treeFactory);

        // iface -> provider (optionaly restricted in() and asSingle() as avove)
        rule.map(Tree.class).to(treeProvider);
    }
}

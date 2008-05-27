package au.net.netstorm.boost.nursery.eight.legged.spider.rules.builder;

import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.core.Rules;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.core.DefaultRules;

public final class RuleBuilderMolecularTest extends LifecycleTestCase implements HasFixtures {
    private RuleBuilder builder;
    private Rules rules;

    public void setUpFixtures() {
        rules = new DefaultRules();
        builder = new DefaultRuleBuilder(rules);
    }

    public void testIfaceToConcrete() {
        builder.multi(Tree.class).to(GreenTree.class);
    }

    public void testIfaceToConcreteWithHost() {
        builder.multi(Tree.class).to(DeadTree.class).in(TreeHolder.class);
    }
    
    public void testIfaceToConcreteWithHostAndField() {
        builder.multi(Tree.class).to(DeadTree.class).in(TreeHolder.class, "tree");
    }

    public void testIfaceToConcreteWithField() {
        builder.multi(Tree.class).to(DeadTree.class).in("tree");
    }

    public void testSingle() {
        builder.single(Tree.class).to(DeadTree.class);
    }
}

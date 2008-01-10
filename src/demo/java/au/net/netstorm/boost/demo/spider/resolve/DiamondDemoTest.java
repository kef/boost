package au.net.netstorm.boost.demo.spider.resolve;

import au.net.netstorm.boost.spider.core.DefaultGraphUtil;
import au.net.netstorm.boost.spider.core.GraphUtil;

public final class DiamondDemoTest extends ResolverDemooooTest {
    GraphUtil grapher = new DefaultGraphUtil();
    Tomato t1 = new JuicyTomato("Tomato 1");
    Tomato t2 = new JuicyTomato("Tomato 2");

    {
        registry.single(Fridge.class, HealthyFridge.class);
    }

    public void testOneInstance() {
        check(t1, t1);
    }

    public void testTwoInstances() {
        check(t1, t2);
    }

    private void check(Tomato tomato1, Tomato tomato2) {
        registry.instance(Fruit.class, tomato1);
        registry.instance(Vegetable.class, tomato2);
        Fridge fridge = resolver.resolve(Fridge.class);
        check(fridge, tomato1, "fruit");
        check(fridge, tomato2, "vegetable");
    }

    private void check(Fridge fridge, Tomato tomato, String name) {
        Edible edible = (Edible) grapher.get(fridge, name);
        assertSame(tomato, edible);
    }
}
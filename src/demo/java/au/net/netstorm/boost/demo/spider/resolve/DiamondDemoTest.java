package au.net.netstorm.boost.demo.spider.resolve;

import au.net.netstorm.boost.spider.core.DefaultGraphUtil;
import au.net.netstorm.boost.spider.core.GraphUtil;

public final class DiamondDemoTest extends ResolverDemooooTest {
    GraphUtil grapher = new DefaultGraphUtil();
    Tomato tomato = new JuicyTomato();

    {
        registry.instance(Fruit.class, tomato);
        registry.instance(Vegetable.class, tomato);
        registry.single(Fridge.class, HealthyFridge.class);
    }

    public void testMultipleInterfacesOneImplementation() {
        Fridge fridge = resolver.resolve(Fridge.class);
        check(fridge, "fruit");
        check(fridge, "vegetable");
    }

    private void check(Fridge fridge, String name) {
        Object fruit = grapher.get(fridge, name);
        assertEquals(tomato, fruit);
    }
}
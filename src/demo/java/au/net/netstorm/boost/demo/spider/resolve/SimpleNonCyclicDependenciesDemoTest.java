package au.net.netstorm.boost.demo.spider.resolve;

public final class SimpleNonCyclicDependenciesDemoTest extends ResolverDemooooTest {
    {
        registry.multiple(Bicycle.class, BmxBicycle.class);
        registry.multiple(Wheel.class, DefaultWheel.class);
    }

    public void testDifferentWheels() {
        Bicycle bicycle = (Bicycle) resolver.resolve(Bicycle.class);
        Object o1 = grapher.get(bicycle, "front");
        Object o2 = grapher.get(bicycle, "rear");
        assertNotEquals(o1, o2);
    }
}

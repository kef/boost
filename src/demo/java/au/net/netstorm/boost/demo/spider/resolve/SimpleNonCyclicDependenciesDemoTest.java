package au.net.netstorm.boost.demo.spider.resolve;

public final class SimpleNonCyclicDependenciesDemoTest extends ResolverDemooooTest {
    {
        registry.single(Bicycle.class, BmxBicycle.class);
        registry.multiple(Wheel.class, MagWheel.class);
    }

    public void testDifferentWheels() {
        Bicycle bicycle = resolver.resolve(Bicycle.class);
        Object o1 = grapher.get(bicycle, "front");
        Object o2 = grapher.get(bicycle, "rear");
        assertNotEquals(o1, o2);
    }
}

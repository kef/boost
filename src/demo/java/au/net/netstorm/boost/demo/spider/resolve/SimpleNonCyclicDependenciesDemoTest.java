package au.net.netstorm.boost.demo.spider.resolve;

// FIX 1977 Build test utility for obtaining field paths (ie. "ball.bike.chain").

// FIX 1977 Convert all existing object graph tests to use this technique.
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

    // FIX 1977 Test behaviour for registry.single.
    // FIX 1977 Test behaviour for registry.instance.
}

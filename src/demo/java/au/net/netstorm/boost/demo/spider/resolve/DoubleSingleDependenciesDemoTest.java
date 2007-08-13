package au.net.netstorm.boost.demo.spider.resolve;

public class DoubleSingleDependenciesDemoTest extends ResolverDemooooTest {
    {
        registry.single(Shed.class, RedShed.class);
        registry.single(Car.class, MetalCar.class);
    }

    // FIX 2081 Complete.
    public void testDoubleSingle() {
        Shed shed = (Shed) resolver.resolve(Shed.class);
    }
}

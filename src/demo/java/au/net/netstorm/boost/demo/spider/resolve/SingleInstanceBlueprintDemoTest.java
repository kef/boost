package au.net.netstorm.boost.demo.spider.resolve;

public final class SingleInstanceBlueprintDemoTest extends ResolverDemooooTest {

    {
        registry.multiple(Town.class, Weipa.class);
        registry.single(FlyingDoctor.class, FnqFlyingDoctor.class);
    }

    // FIX 2081 Refactor.
    public void testSingle() {
        Town t1 = resolveTown();
        Town t2 = resolveTown();
        assertEquals(true, t1 != t2);
        FlyingDoctor d1 = getDoctor(t1);
        FlyingDoctor d2 = getDoctor(t2);
        assertNotNull(d1);
        // FIX 2081 Reinstate as acceptance test.
//        assertEquals(d1, d2);
    }

    private FlyingDoctor getDoctor(Town t1) {
        return (FlyingDoctor) grapher.get(t1, "doctor");
    }

    private Town resolveTown() {
        return (Town) resolver.resolve(Town.class);
    }
}

package au.net.netstorm.boost.demo.spider.resolve;

public final class BlueprintDemoTest extends ResolverDemooooTest {
    {
        registry.multiple(Town.class, Weipa.class);
        registry.single(FlyingDoctor.class, FnqFlyingDoctor.class);
        registry.multiple(AirField.class, BrisbaneAirField.class);
        registry.single(BrisbaneAirField.class, FlyingDoctor.class, CoastalFlyingDoctor.class);
        // FIX ()   2237 Make this work too.  Write a test for it.
//        registry.single(BrisbaneAirField.class,  FlyingDoctor.class,  "jack", CoastalFlyingDoctor.class);
    }

    public void testSingle() {
        Town t1 = resolveTown();
        Town t2 = resolveTown();
        checkDifferent(t1, t2);
        FlyingDoctor d1 = getDoctor(t1);
        FlyingDoctor d2 = getDoctor(t2);
        checkSame(d1, d2);
    }

    public void testHostedSingle() {
        AirField af1 = resolver.resolve(AirField.class);
        FlyingDoctor doctor = getDoctor(af1);
        Class actual = doctor.getClass();
        assertEquals(CoastalFlyingDoctor.class, actual);
    }

    private Town resolveTown() {
        return resolver.resolve(Town.class);
    }

    private FlyingDoctor getDoctor(Object ref) {
        return (FlyingDoctor) grapher.get(ref, "doctor");
    }

    private void checkSame(Object o1, Object o2) {
        assertNotNull(o1);
        assertEquals(true, o1 == o2);
    }

    private void checkDifferent(Object o1, Object o2) {
        assertNotNull(o1);
        assertNotNull(o2);
        assertEquals(true, o1 != o2);
    }
}

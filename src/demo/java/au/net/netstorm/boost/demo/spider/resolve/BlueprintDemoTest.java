package au.net.netstorm.boost.demo.spider.resolve;

public final class BlueprintDemoTest extends ResolverDemooooTransitionTest {
    {
        registry.multiple(Town.class, Weipa.class);
        registry.single(FlyingDoctor.class, FnqFlyingDoctor.class);
        registry.multiple(AirField.class, BrisbaneAirField.class);
        registry.single(BrisbaneAirField.class, FlyingDoctor.class, CoastalFlyingDoctor.class);
        registry.single(BrisbaneAirField.class,  FlyingDoctor.class,  "ambulance", FlyingAmbulance.class);
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
        AirField airField = resolver.resolve(AirField.class);
        check(airField, "doctor", CoastalFlyingDoctor.class);
        check(airField, "ambulance", FlyingAmbulance.class);
    }

    private Town resolveTown() {
        return resolver.resolve(Town.class);
    }

    private void check(AirField airField, String fieldName, Class expected) {
        FlyingDoctor doctor = getDoctor(airField, fieldName);
        Class actual = doctor.getClass();
        assertEquals(expected, actual);
    }

    private FlyingDoctor getDoctor(Object ref) {
        return getDoctor(ref, "doctor");
    }

    private FlyingDoctor getDoctor(Object ref, String fieldName) {
        return (FlyingDoctor) grapher.get(ref, fieldName);
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

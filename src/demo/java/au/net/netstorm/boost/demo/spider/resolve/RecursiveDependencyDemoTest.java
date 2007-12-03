package au.net.netstorm.boost.demo.spider.resolve;

public final class RecursiveDependencyDemoTest extends ResolverDemooooTest {
    {
        registry.multiple(Recursion.class, MrRecursion.class);
    }

    public void testRecursive() {
        Recursion recursion = resolver.resolve(Recursion.class);
        Object selfRef = grapher.get(recursion, "self");
        checkSame(recursion, selfRef);
    }

    // FIX 1887 Consider making BoooostCase onion aware.  See how imports go.
    private void checkSame(Recursion recursion, Object selfRef) {
        Object pRecursion = peeler.peel(recursion);
        Object pSelfRef = peeler.peel(selfRef);
        assertSame(pRecursion, pSelfRef);
    }
}

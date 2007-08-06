package au.net.netstorm.boost.demo.spider.resolve;

public final class SingleRecursiveDependencyDemoTest extends ResolverDemooooTest {

    {
        registry.multiple(Recursion.class, MrRecursion.class);
    }

    public void testRecursive() {
        Recursion recursion = (Recursion) resolver.resolve(Recursion.class);
        Object selfRef = grapher.get(recursion, "self");
        checkSame(recursion, selfRef);
    }

    private void checkSame(Recursion recursion, Object selfRef) {
        Object pRecursion = peeler.peel(recursion);
        Object pSelfRef = peeler.peel(selfRef);
        assertSame(pRecursion, pSelfRef);
    }
}

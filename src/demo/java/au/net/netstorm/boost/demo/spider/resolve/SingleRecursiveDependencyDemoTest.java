package au.net.netstorm.boost.demo.spider.resolve;

public final class SingleRecursiveDependencyDemoTest extends ResolverDemooooTest {

    {
        registry.multiple(Recursion.class, MrRecursion.class);
    }

    public void testRecursive() {
        Recursion recursion = (Recursion) resolver.resolve(Recursion.class);
        Object selfRef = fielder.getInstance(recursion, "self");
        assertSame(recursion, selfRef);
    }
}

package au.net.netstorm.boost.demo.spider.resolve;

public final class FactoryDemoTest extends ResolverDemooooTransitionTest {
    {
        // FIX 2394 Currently does new spider does not handle old-syle blueprint factories.
        registry.factory(MemorabiliaFactory.class);
        registry.single(OjSimpson.class, JailedOjSimpson.class);
    }

    public void testResolve() {
        OjSimpson oj = resolver.resolve(OjSimpson.class);
        Memorabilia memorabilia = oj.getMemorabilia();
        Class actual = memorabilia.getOwner();
        assertEquals(JailedOjSimpson.class, actual);
    }
}

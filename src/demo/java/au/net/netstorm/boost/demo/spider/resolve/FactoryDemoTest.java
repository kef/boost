package au.net.netstorm.boost.demo.spider.resolve;

public final class FactoryDemoTest extends ResolverDemooooTest {

    {
        registry.factory(MemorabiliaFactory.class);
        registry.single(OjSimpson.class, JailedOjSimpson.class);
    }

    public void testResolve() {
        OjSimpson oj = (OjSimpson) resolver.resolve(OjSimpson.class);
        Memorabilia memorabilia = oj.getMemorabilia();
        Class actual = memorabilia.getOwner();
        assertEquals(JailedOjSimpson.class, actual);
    }
}

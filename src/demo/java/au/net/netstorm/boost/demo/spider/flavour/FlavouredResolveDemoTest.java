package au.net.netstorm.boost.demo.spider.flavour;

import au.net.netstorm.boost.demo.spider.resolve.ResolverDemooooTest;

public final class FlavouredResolveDemoTest extends ResolverDemooooTest {

    // FIX BREADCRUMB 1977 CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC Test with instances too.
    {
        registry.multiple(Curry.class, Madras.class, "mild");
        registry.multiple(Curry.class, Vindaloo.class, "hot");
        registry.multiple(Curry.class, PrawnMalai.class, "stevesFavourite");
        registry.multiple(Beer.class, Tiger.class);
        registry.multiple(Party.class, RockinParty.class);
    }

    public void testFlavours() {
        Party party = (Party) resolver.resolve(Party.class);
        checkField(Madras.class, party, "mild");
        checkField(Vindaloo.class, party, "hot");
        checkField(PrawnMalai.class, party, "stevesFavourite");
        checkField(Tiger.class, party, "schooner");
        checkField(Tiger.class, party, "pint");
    }

    private void checkField(Class expected, Party party, String field) {
        Object value = grapher.get(party, field);
        Class cls = value.getClass();
        boolean is = expected.isAssignableFrom(cls);
        assertEquals(true, is);
    }
}

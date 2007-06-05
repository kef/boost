package au.net.netstorm.boost.demo.spider.flavour;

import au.net.netstorm.boost.demo.spider.resolve.ResolverDemooooTest;
import au.net.netstorm.boost.spider.core.DefaultGraphUtil;
import au.net.netstorm.boost.spider.core.GraphUtil;

// FIX 1977 Separate package for newers?

// FIX 1977 Acceptance test for this CARD.
public final class FlavouredResolveDemoTest extends ResolverDemooooTest {
    private final GraphUtil grapher = new DefaultGraphUtil();

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
    }

    private void checkField(Class expected, Party party, String field) {
        Object value = grapher.get(party, field);
        Class cls = value.getClass();
        assertEquals(true, expected.isAssignableFrom(cls));
    }
}

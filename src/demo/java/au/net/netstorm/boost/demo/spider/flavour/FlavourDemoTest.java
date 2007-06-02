package au.net.netstorm.boost.demo.spider.flavour;

import au.net.netstorm.boost.demo.spider.resolve.ResolverDemooooTest;
import au.net.netstorm.boost.test.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;

// FIX 1977 Remove GoodCitizen.

// FIX 1977 Acceptance test for this CARD.
public final class FlavourDemoTest extends ResolverDemooooTest {
    private final FieldTestUtil fielder = new DefaultFieldTestUtil();

    // FIX BREADCRUMB 1977 CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC Test with instances too.
    {
        registry.multiple(Curry.class, Madras.class, "mild");
        registry.multiple(Curry.class, Vindaloo.class, "hot");
        registry.multiple(Curry.class, PrawnMalai.class, "stevesFavourite");
        registry.multiple(Party.class, RockinParty.class);
    }

    public void testFlavours() {
        Party party = (Party) resolver.resolve(Party.class);
        checkField(party, Madras.class, "mild");
        checkField(party, Vindaloo.class, "hot");
        checkField(party, PrawnMalai.class, "stevesFavourite");
    }

    private void checkField(Party party, Class expected, String field) {
        Object value = fielder.getInstance(party, field);
        Class cls = value.getClass();
        assertEquals(true, expected.isAssignableFrom(cls));
    }
}

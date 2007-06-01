package au.net.netstorm.boost.demo.spider.flavour;

import au.net.netstorm.boost.demo.spider.resolve.ResolverDemooooTest;
import au.net.netstorm.boost.test.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;

public final class FlavourDemoTest extends ResolverDemooooTest {
    private final FieldTestUtil fielder = new DefaultFieldTestUtil();

    {
        // FIX BREADCRUMB 1977 AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA Reinstate.
        registry.multiple(Curry.class, Madras.class, "mild");
//        registry.multiple(Curry.class, Vindaloo.class, "hot");
//        registry.multiple(Curry.class, PrawnMalai.class, "stevesFavourite");
        registry.multiple(Party.class, DefaultParty.class);
    }

    // FIX 1977 Remove GoodCitizen.
    // FIX BREADCRUMB 1977 CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC Test with instances too.
    // FIX 1977 Acceptance test.
    public void testFlavours() {
        Party party = (Party) resolver.resolve(Party.class);
        checkField(party, Madras.class, "mild");
        // FIX BREADCRUMB 1977 GGGGGGGGGGGGGGGGGGGGGGGGGGGG Reinstate.
//        checkField(party, Vindaloo.class, "hot");
//        checkField(party, PrawnMalai.class, "stevesFavourite");
    }

    private void checkField(Party party, Class expected, String field) {
        Object value = fielder.getInstance(party, field);
        Class cls = value.getClass();
        assertEquals(true, expected.isAssignableFrom(cls));
    }

    /*
    void instance(Interface iface, ResolvedInstance instance);

    void multiple(Interface iface, Implementation implementation);

    void single(Interface iface, Implementation implementation);

    void instance(Interface iface, ResolvedInstance instance, Flavour flavour);

    void multiple(Interface inyerface, Implementation implementation, Flavour foo);

    void single(Interface iface, Implementation implementation, Flavour flavour);
    */

/*
    {
        // Flavours
        registry.instance(SuperMap.class, softwareMap, "softwareMap");
        registry.instance(SuperMap.class, hardwareMap, "hardwareMap");
        registry.instance(SuperMap.class, anotherMap, "anotherMap");

        registry.multiple(Marshaller.class, DefaultGenericMarshaller.class, "generic");
        registry.multiple(Marshaller.class, DefaultPrimitiveMarshaller.class, "primitive");
        registry.multiple(Marshaller.class, DefaultStructMarshaller.class, "struct");
        registry.multiple(Marshaller.class, DefaultArrayMarshaller.class, "array");

        registry.single(Base64.class, DefaultBase64.class, "common");
        registry.single(Base64.class, BoringBase64.class, "boring");

        // No flavours
        registry.instance(SuperMap.class, softwareMap);

        registry.multiple(Marshaller.class, DefaultGenericMarshaller.class);

        registry.single(Base64.class, DefaultBase64.class);

        // The hook
        registry.multiple(Shampoo.class, DefaultShampoo.class);

        // Some observations:
        //   - The flavours (eg. "generic") map to field names in the class being resolved.
        //   - A type (1st parameter) is either flavoured or not.  It cannot be both.
    }

    public void example() {
        Shampoo shampoo = (Shampoo) resolver.resolve(Shampoo.class);
    }

    private class DefaultShampoo {
        Marshaller marshaller;
    }

    private class DefaultGenericMarshaller implements Marshaller {
        Marshaller primitive;
        Marshaller struct;
        Marshaller array;
    }

    private class DefaultStructMarshaller implements Marshaller {
        Marshaller generic;
    }

    private class DefaultArrayMarshaller implements Marshaller {
        Marshaller generic;
    }
    
*/
}

package au.net.netstorm.boost.demo.spider.resolve;

import au.net.netstorm.boost.test.cases.BoooostCase;

public final class FlavourDemoTest extends BoooostCase {
    public void testXxx() {
        // FIX 9999 Complete.
    }

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

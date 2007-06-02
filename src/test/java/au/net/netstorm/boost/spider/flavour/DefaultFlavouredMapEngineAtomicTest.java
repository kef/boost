package au.net.netstorm.boost.spider.flavour;

import au.net.netstorm.boost.test.automock.HasSubjects;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.UsesAutoMocks;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;

// FIX BREADCRUMB 1977 LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL Finish this.
public final class DefaultFlavouredMapEngineAtomicTest extends InteractionTestCase implements UsesAutoMocks, HasSubjects {
    FlavouredMapEngine subject;
    Interface milkshake = new DefaultInterface(Milkshake.class);
    Flavour chocolate = new DefaultFlavour("chocolate");
    Flavour vanilla = new DefaultFlavour("vanilla");
    Flavour unflavoured = Flavour.UNFLAVOURED;
    FlavouredInterface milkshakeChocolate = mix(milkshake, chocolate);
    FlavouredInterface milkshakeVanilla = mix(milkshake, vanilla);
    FlavouredInterface milkshakeUnflavoured = mix(milkshake, unflavoured);
    Object value;
    // FIX 1977 Complete.

    public void setupSubjects() {
        subject = new DefaultFlavouredMapEngine();
    }

    public void testUnflavoured() {
        subject.put(milkshakeUnflavoured, value);
        Object result = subject.get(milkshakeUnflavoured);
        assertEquals(value, result);
    }

    public void testUnflavouredFirst() {
        subject.put(milkshakeUnflavoured, value);
        // FIX BREADCRUMB 1977 MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM Reinstate.
/*
        try {
            subject.put(milkshakeChocolate, value);
            fail();
        } catch (FlavouredMapException expected) { }
*/
    }

    private FlavouredInterface mix(Interface iface, Flavour flavour) {
        return new DefaultFlavouredInterface(iface, flavour);
    }
}

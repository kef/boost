package au.net.netstorm.boost.spider.inject.resolver.core;

import java.lang.reflect.Field;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.spider.flavour.DefaultFlavour;
import au.net.netstorm.boost.spider.flavour.DefaultFlavouredInterface;
import au.net.netstorm.boost.spider.flavour.Flavour;
import au.net.netstorm.boost.spider.flavour.FlavourMapException;
import au.net.netstorm.boost.spider.flavour.FlavouredInterface;
import au.net.netstorm.boost.spider.registry.UnresolvedDependencyException;
import au.net.netstorm.boost.spider.resolve.ResolverEngine;
import au.net.netstorm.boost.test.automock.HasFixtures;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.LazyFields;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultFieldResolverAtomicTest extends InteractionTestCase implements HasFixtures, LazyFields {
    private static final String HAPPY_CHAP = "happyChap";
    private static final String BEER_IN_HIS_TUMMY = "beerInHisTummy";
    EdgeClass classer = new DefaultEdgeClass();
    Interface happyChap = new DefaultInterface(HappyChap.class);
    Interface beerInHisTummy = new DefaultInterface(BeerInHisTummy.class);
    FieldResolver subject;
    ResolverEngine resolverMock;
    ResolvedInstance resolved;

    public void setUpFixtures() {
        subject = new DefaultFieldResolver(resolverMock);
    }

    public void testResolve() {
        checkResolve(HAPPY_CHAP, happyChap);
        checkResolve(BEER_IN_HIS_TUMMY, beerInHisTummy);
    }

    public void testWrapsExceptionOnResolveFail() {
        setupThrowsExpectations();
        try {
            Field field = field(HAPPY_CHAP);
            subject.resolve(field);
            fail();
        } catch (UnresolvedDependencyException expected) {}
    }

    private void checkResolve(String fieldName, Interface iface) {
        Flavour flavour = flavour(fieldName);
        Field field = field(fieldName);
        checkResolve(iface, flavour, field);
    }

    private void checkResolve(Interface iface, Flavour flavour, Field field) {
        expect.oneCall(resolverMock, resolved, "resolve", iface, flavour);
        ResolvedInstance result = subject.resolve(field);
        assertEquals(resolved, result);
    }

    private void setupThrowsExpectations() {
        Flavour flavour = flavour(HAPPY_CHAP);
        FlavourMapException flavourMapException = makeException(flavour);
        expect.oneCall(resolverMock, flavourMapException, "resolve", happyChap, flavour);
    }

    private FlavourMapException makeException(Flavour flavour) {
        FlavouredInterface flavoured = new DefaultFlavouredInterface(happyChap, flavour);
        return new FlavourMapException(flavoured, "reason");
    }

    private Flavour flavour(String flavour) {
        return new DefaultFlavour(flavour);
    }

    private Field field(String name) {
        return classer.getDeclaredField(Gary.class, name);
    }
}

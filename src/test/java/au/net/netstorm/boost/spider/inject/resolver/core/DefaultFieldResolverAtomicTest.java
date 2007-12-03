package au.net.netstorm.boost.spider.inject.resolver.core;

import java.lang.reflect.Field;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.spider.flavour.InterfaceMapException;
import au.net.netstorm.boost.spider.registry.UnresolvedDependencyException;
import au.net.netstorm.boost.spider.resolve.ResolverEngine;
import au.net.netstorm.boost.test.core.LifecycleTestCase;
import au.net.netstorm.boost.test.marker.HasFixtures;
import au.net.netstorm.boost.test.marker.LazyFields;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultFieldResolverAtomicTest extends LifecycleTestCase implements HasFixtures, LazyFields {
    private static final String HAPPY_CHAP = "happyChap";
    private static final String BEER_IN_HIS_TUMMY = "beerInHisTummy";
    EdgeClass classer = new DefaultEdgeClass();
    Interface happyChap = new DefaultInterface(HappyChap.class);
    Interface beerInHisTummy = new DefaultInterface(BeerInHisTummy.class);
    ResolverEngine resolverMock;
    ResolvedInstance resolved;
    FieldResolver subject;
    Implementation host;

    public void setUpFixtures() {
        subject = new DefaultFieldResolver(resolverMock);
    }

    public void testResolve() {
        checkResolve(HAPPY_CHAP, happyChap);
        checkResolve(BEER_IN_HIS_TUMMY, beerInHisTummy);
    }

    public void testWrapsExceptionOnResolveFail() {
        Field field = field(HAPPY_CHAP);
        setupHost(field);
        setupThrowsExpectations();
        try {
            subject.resolve(field);
            fail();
        } catch (UnresolvedDependencyException expected) {}
    }

    private void checkResolve(String fieldName, Interface iface) {
        Field field = field(fieldName);
        checkResolve(iface, field);
    }

    private void checkResolve(Interface iface, Field field) {
        setupHost(field);
        expect.oneCall(resolverMock, resolved, "resolve", iface, host);
        ResolvedInstance result = subject.resolve(field);
        assertEquals(resolved, result);
    }

    private void setupHost(Field field) {
        Class hostClass = field.getDeclaringClass();
        host = new DefaultImplementation(hostClass);
    }

    private void setupThrowsExpectations() {
        InterfaceMapException interfaceMapException = makeException();
        expect.oneCall(resolverMock, interfaceMapException, "resolve", happyChap, host);
    }

    private InterfaceMapException makeException() {
        return new InterfaceMapException(happyChap, "reason");
    }

    private Field field(String name) {
        return classer.getDeclaredField(Gary.class, name);
    }
}

package au.net.netstorm.boost.gunge.generics;

import java.lang.reflect.Type;

import au.net.netstorm.boost.gunge.collection.FunctionalCollection;
import au.net.netstorm.boost.nursery.type.core.Types;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultTypeResolverAtomicTest extends LifecycleTestCase
        implements HasFixtures, InjectableSubject, InjectableTest, LazyFields {

    private TypeResolver subject;
    private Type[] interfaceTypes;
    private Type edgeType;

    FunctionalCollection collectionMock;
    TypeTokenFinder typeTokenFinderMock;
    TypeInstance typeTokenInstanceMock;
    Types typesMock;

    public void setUpFixtures() {
        subject = new DefaultTypeResolver();
        interfaceTypes = SuperMan.class.getGenericInterfaces();
        edgeType = interfaceTypes[0];
    }

    public void testResolveTypeToken() {
        expect.oneCall(typesMock, typeTokenFinderMock, "nu", TypeTokenFinder.class, Man.class);
        expect.oneCall(collectionMock, edgeType, "find", interfaceTypes, typeTokenFinderMock);
        expect.oneCall(typesMock, typeTokenInstanceMock, "nu", TypeInstance.class, edgeType);
        TypeInstance result = subject.resolve(SuperMan.class, Man.class);
        assertSame(typeTokenInstanceMock, result);
    }

    public void testFailureToResolveTypeToken() {
        try {
            subject.resolve(Bob.class, Man.class);
            fail("Token must implement token interface.");
        } catch (RuntimeException expected) { }
    }
}

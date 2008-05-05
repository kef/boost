package au.net.netstorm.boost.gunge.generics;

import java.lang.reflect.Type;
import java.util.List;
import au.net.netstorm.boost.gunge.collection.FunctionalCollection;
import au.net.netstorm.boost.nursery.autoedge.Edge;
import au.net.netstorm.boost.nursery.autoedge.testdata.AutoEdgeByteBuffer;
import au.net.netstorm.boost.nursery.autoedge.testfixtures.EdgeBufferFixture;
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
    EdgeBufferFixture fixture;

    FunctionalCollection collectionMock;
    TypeTokenFinder typeTokenFinderMock;
    TypeInstance typeTokenInstanceMock;
    Types typesMock;

    public void setUpFixtures() {
        subject = new DefaultTypeResolver();
        interfaceTypes = fixture.edgeInterfaceTypes();
        edgeType = interfaceTypes[0];
    }

    public void testResolveTypeToken() {
        expect.oneCall(typesMock, typeTokenFinderMock, "nu", TypeTokenFinder.class, Edge.class);
        expect.oneCall(collectionMock, edgeType, "find", interfaceTypes, typeTokenFinderMock);
        expect.oneCall(typesMock, typeTokenInstanceMock, "nu", TypeInstance.class, edgeType);
        subject.resolve(AutoEdgeByteBuffer.class, Edge.class);
    }

    public void testFailureToResolveTypeToken() {
        try {
            subject.resolve(List.class, Edge.class);
            fail("Token must implement token interface.");
        } catch (RuntimeException expected) { }
    }
}

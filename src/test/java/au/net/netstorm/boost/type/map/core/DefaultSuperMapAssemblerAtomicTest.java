package au.net.netstorm.boost.type.map.core;

import au.net.netstorm.boost.test.automock.HasSubjects;
import au.net.netstorm.boost.test.automock.InjectableSubject;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.UsesAutoMocks;
import au.net.netstorm.boost.test.automock.UsesExpectations;

public final class DefaultSuperMapAssemblerAtomicTest extends InteractionTestCase
        implements HasSubjects, UsesExpectations, UsesAutoMocks, InjectableSubject {
    SuperMapAssembler subject;
    TypedMapRead typedMapRead;
    TypedMapWrite typedMapWrite;
    TypedMap typedMap;
    HolderMap holderMap;
    SuperMap superMap;
    NewDefaultTypedMap newDefaultTypedMap;
    NewDefaultHolderMap newDefaultHolderMap;
    NewDefaultSuperMap newDefaultSuperMap;
    NewBoomTypedMapWrite newBoomTypedMapWrite;

    public void setupSubjects() {
        subject = new DefaultSuperMapAssembler();
    }

    public void testAssembleFromMap() {
        setupAssembleFromTypedMap();
        SuperMap actual = subject.assemble(typedMap);
        assertSame(superMap, actual);
    }

    public void testAssembleFromRead() {
        expect.oneCall(newBoomTypedMapWrite, typedMapWrite, "nu");
        expect.oneCall(newDefaultTypedMap, typedMap, "nu", typedMapRead, typedMapWrite);
        setupAssembleFromTypedMap();
        SuperMap actual = subject.assemble(typedMapRead);
        assertSame(superMap, actual);
    }

    public void testAssembleFromWrite() {
        try {
            subject.assemble(typedMapWrite);
            fail();
        } catch (UnsupportedOperationException expected) { }
    }

    private void setupAssembleFromTypedMap() {
        expect.oneCall(newDefaultHolderMap, holderMap, "nu", typedMap);
        expect.oneCall(newDefaultSuperMap, superMap, "nu", typedMap, holderMap);
    }
}

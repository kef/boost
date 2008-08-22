package au.net.netstorm.boost.scalpel.engine;

import au.net.netstorm.boost.scalpel.testdata.real.ArrayElement;
import au.net.netstorm.boost.scalpel.testdata.real.Arrayo;
import au.net.netstorm.boost.sledge.java.lang.EdgeClass;
import au.net.netstorm.boost.sledge.java.lang.reflect.Method;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

import java.io.InputStream;

public final class DefaultMethodWarpAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableSubject, InjectableTest, LazyFields {
    private MethodWarp subject;
    StreamFixture stream;
    ArrayoFixture arrayo;
    EdgeClass classerMock;
    Unedger unedgerMock;

    public void setUpFixtures() {
        subject = new DefaultMethodWarp();
    }

    public void testWarp() {
        expect.oneCall(classerMock, stream.realMethod(), "getMethod", InputStream.class, stream.methodName(), stream.argTypes());
        expect.oneCall(unedgerMock, stream.argTypes(), "unedge", new Object[]{stream.argTypes()});
        expect.oneCall(unedgerMock, int.class, "unedge", int.class);
        checkWarp(stream.realMethod(), InputStream.class, stream.edgeMethod());
    }

    public void testWarpVoidReturn() {
        expect.oneCall(classerMock, stream.realMethod(), "getMethod", InputStream.class, stream.methodName(), stream.argTypes());
        expect.oneCall(unedgerMock, stream.argTypes(), "unedge", new Object[]{stream.argTypes()});
        expect.oneCall(unedgerMock, void.class, "unedge", int.class);
        checkWarp(stream.realMethod(), InputStream.class, stream.edgeMethod());
    }

    public void testArray() {
        Class[] args = new Class[0];
        expect.oneCall(classerMock, arrayo.realMulti(), "getMethod", Arrayo.class, "multi", args);
        expect.oneCall(unedgerMock, args, "unedge", new Object[]{args});
        expect.oneCall(unedgerMock, ArrayElement[][].class, "unedge", au.net.netstorm.boost.scalpel.testdata.edge.ArrayElement[][].class);
        checkWarp(arrayo.edgedMulti(), Arrayo.class, arrayo.edgedMulti());
    }

    public void testArrayMismatch() {
        Class[] args = new Class[0];
        expect.oneCall(classerMock, arrayo.realMulti(), "getMethod", Arrayo.class, "multi", args);
        expect.oneCall(unedgerMock, args, "unedge", new Object[]{args});
        expect.oneCall(unedgerMock, ArrayElement.class, "unedge", au.net.netstorm.boost.scalpel.testdata.edge.ArrayElement.class);
        checkWarpFailure(Arrayo.class, arrayo.badEdgedMulti());
    }

    public void testWarpWithBadReturnType() {
        expect.oneCall(classerMock, stream.realMethod(), "getMethod", InputStream.class, stream.methodName(), stream.argTypes());
        expect.oneCall(unedgerMock, stream.argTypes(), "unedge", new Object[]{stream.argTypes()});
        expect.oneCall(unedgerMock, String.class, "unedge", int.class);
        checkWarpFailure(InputStream.class, stream.edgeMethod());
    }

    private void checkWarp(Method expected, Class cls, Method method) {
        Method result = subject.warp(cls, method);
        assertEquals(expected, result);
    }

    private void checkWarpFailure(Class cls, Method method) {
        try {
            subject.warp(cls, method);
            fail();
        } catch (IllegalArgumentException expected) {}
    }
}

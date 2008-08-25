package au.net.netstorm.boost.scalpel.engine;

import java.io.InputStream;

import au.net.netstorm.boost.nursery.proxy.DefaultMethod;
import au.net.netstorm.boost.sledge.java.lang.EdgeClass;
import au.net.netstorm.boost.sledge.java.lang.reflect.Method;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.sniper.reflect.util.FieldTestUtil;
import au.net.netstorm.boost.spider.inject.core.Injector;

public final class DefaultAutoEdgeAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, InjectableSubject, LazyFields {
    private AutoEdge subject;
    private AutoEdge subjectStatic;
    private Method unedge;
    private Method toString;
    private Method equals;
    private Method forName;
    private Method hashCode;
    Injector injector;
    StreamFixture stream;
    MethodWarp warperMock;
    Unedger unedgerMock;
    ReturnEdger returnEdgerMock;
    EdgeClass classer;
    Method realMethodMock;
    FieldTestUtil fielder;

    public void setUpFixtures() {
        subject = new DefaultAutoEdge(InputStream.class, stream.real());
        subjectStatic = new DefaultAutoEdge(Class.class, null);
        injector.inject(subjectStatic);
        unedge = method("unedge");
        toString = method("toString");
        equals = method("equals");
        hashCode = method("hashCode");
        forName = new DefaultMethod(classer.getMethod(Class.class, "forName", String.class));
    }

    public void testInvoke() {
        byte[] result = new byte[stream.length()];
        Object[] args = {result};
        expectations(stream.edgeMethod(), stream.length(), args);
        int length = (Integer) subject.invoke(stream.edgeMethod(), args);
        assertEquals(stream.length(), length);
    }

    public void testInvokeUnedge() {
        Object[] args = {};
        Object result = subject.invoke(unedge, args);
        assertEquals(true, result instanceof InputStream);
        assertSame(stream.real(), result);
    }

    public void testInvokeStatic() {
        Object[] args = {getClass().getName()};
        Object result = subjectStatic.invoke(forName, args);
        assertEquals(getClass(), result);
    }

    public void testInvokeStaticToString() {
        String expected = "StaticEdge<java.lang.Class>";
        Object result = subjectStatic.invoke(toString, null);
        assertEquals(expected, result);
    }

    public void testInvokeStaticHashCode() {
        int expected = subjectStatic.hashCode();
        int result = (Integer) subjectStatic.invoke(hashCode, null);
        assertEquals(expected, result);
    }

    public void testInvokeStaticEquals() {
        Object[] args = {subjectStatic};
        boolean result = (Boolean) subjectStatic.invoke(equals, args);
        assertEquals(true, result);
    }

    private void expectations(Method src, Object expected, Object args) {
        expect.oneCall(warperMock, realMethodMock, "warp", InputStream.class, src);
        expect.oneCall(unedgerMock, args, "unedge", args);
        expect.oneCall(realMethodMock, expected, "invoke", stream.real(), args);
        expect.oneCall(returnEdgerMock, expected, "edge", src, expected);
    }

    private Method method(String name) {
        return (Method) fielder.getInstance(subject, name);
    }
}

package au.net.netstorm.boost.spider.inject.newer.core;

import au.net.netstorm.boost.spider.inject.core.InjectorEngine;
import au.net.netstorm.boost.spider.inject.newer.field.NewerField;
import au.net.netstorm.boost.spider.inject.newer.field.NewerFieldFinder;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.UnresolvedInstance;

public final class DefaultNewerProxyInjectorEngineAtomicTest extends InteractionTestCase {
    InjectorEngine subject;
    Object larry = new Larry("ten");
    UnresolvedInstance unresolved;
    String proxy;
    NewerField[] newerFields =
            {}; // SUGGEST: Put CARD into boost.  This flushes out the need to deal with arrays differently.
    NewerProxySupplier newerProxySupplier;
    NewerFieldFinder newerFieldFinder;
    NewerField newerField;
    Interface newerInterface;
    Implementation classToNu;
    String fieldName = "fingers";

    public void setupSubjects() {
        subject = new NewerProxyInjectorEngine(newerProxySupplier, newerFieldFinder);
        newerFields = new NewerField[]{newerField, newerField};
    }

    public void testSubject() {
        expect.oneCall(unresolved, larry, "getRef");
        expect.oneCall(newerFieldFinder, newerFields, "find", larry);
        setArrayElementExpectations();
        subject.inject(unresolved);
        Object expectedLarry = new Larry(proxy);
        assertEquals(expectedLarry, larry);
    }

    private void setArrayElementExpectations() {
        for (int i = 0; i < newerFields.length; i++) {
            expect.oneCall(newerField, newerInterface, "getNewerInterface");
            expect.oneCall(newerField, classToNu, "getClassToNu");
            expect.oneCall(newerProxySupplier, proxy, "nu", newerInterface, classToNu);
            expect.oneCall(newerField, fieldName, "getFieldName");
        }
    }
}

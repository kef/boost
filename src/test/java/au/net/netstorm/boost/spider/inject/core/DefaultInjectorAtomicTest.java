package au.net.netstorm.boost.spider.inject.core;

import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.util.type.DefaultBaseReference;
import au.net.netstorm.boost.util.type.UnresolvedInstance;

public final class DefaultInjectorAtomicTest extends InteractionTestCase {
    Injector subject;
    Object ref;
    InjectorEngine engine;
    UnresolvedInstance unresolved;

    public void setupSubjects() {
        unresolved = new DefaultBaseReference(ref);
        subject = new DefaultInjector(engine);
    }

    public void testInjector() {
        expect.oneCall(engine, VOID, "inject", unresolved);
        subject.inject(ref);
    }
}

package au.net.netstorm.boost.nursery.eight.legged.spider.injection.types;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

public final class DefaultInjectionTypeChecker implements InjectionTypeChecker {
    public void checkType(InjectionType subject, InjectionType raw, Class<?> rawClass) {
        checkParameters(subject);
        checkRaw(subject, raw);
        checkRawClass(subject, rawClass);
    }

   private void checkParameters(InjectionType subject) {
        // FIX 2394 add test to support parametized types
        try {
            subject.parameters();
            fail();
        } catch (UnsupportedOperationException expected) {}
    }

    private void checkRaw(InjectionType subject, InjectionType expected) {
        InjectionType result = subject.raw();
        assertEquals(expected, result);
    }

    private void checkRawClass(InjectionType subject, Class<?> expected) {
        Class<?> result = subject.rawClass();
        assertEquals(expected, result);
    }
}

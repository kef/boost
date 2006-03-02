package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.Member;

// FIXME: SC042 Type up a story card for building a delegator (composer).

public interface ModifierTestChecker {
    void checkPublic(Member member);

    void checkPrivate(Member member);

    void checkFinal(Member member);

    void checkSynchronized(Member member);

    void checkStatic(Member member);

    void checkInstance(Member member);

    void checkPublic(Class cls);

    void checkFinal(Class cls);

    void checkConcrete(Class cls);
}

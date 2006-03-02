package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.Member;

// FIXME: SC042 Type up a story card for building a delegator (composer).

public interface ModifierTestChecker {
    void checkFinal(Member member);

    void checkSynchronized(Member member);

    // FIXME: SC042 Add checkStatic(member)
    // FIXME: SC042 Add checkPublic(member)

    void checkPublic(Class cls);

    void checkFinal(Class cls);

    void checkConcrete(Class cls);
}

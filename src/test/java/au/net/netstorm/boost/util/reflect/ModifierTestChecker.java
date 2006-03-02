package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.Member;

public interface ModifierTestChecker {
    // FIXME: SC042 Coalesce into Member.
    void checkFinal(Member member);

    void checkSynchronized(Member member);

    void checkPublic(Class cls);

    void checkFinal(Class cls);

    void checkConcrete(Class cls);
}

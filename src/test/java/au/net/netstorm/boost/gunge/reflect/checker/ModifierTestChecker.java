package au.net.netstorm.boost.gunge.reflect.checker;

import java.lang.reflect.Member;

public interface ModifierTestChecker {
    void checkPublic(Member member);

    void checkPrivate(Member member);

    void checkFinal(Member member);

    void checkSynchronized(Member member);

    void checkStatic(Member member);

    void checkInstance(Member member);

    void checkPrivateFinalInstance(Member member);

    void checkPublic(Class cls);

    void checkFinal(Class cls);

    void checkConcrete(Class cls);
}
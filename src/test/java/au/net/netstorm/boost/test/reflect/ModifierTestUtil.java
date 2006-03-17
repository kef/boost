package au.net.netstorm.boost.test.reflect;

import java.lang.reflect.Member;

public interface ModifierTestUtil {
    boolean isPublic(Member member);

    boolean isPrivate(Member member);

    boolean isPublicInstance(Member member);

    boolean isStatic(Member member);

    boolean isInstance(Member member);

    boolean isFinal(Member member);

    boolean isSynchronized(Member member);

    // Why the hell doesn't j.l.Class implement j.l.r.Member?
    // Then we would not need to double up like this!

    boolean isPublic(Class cls);

    boolean isFinal(Class cls);

    boolean isAbstract(Class cls);

    boolean isConcrete(Class cls);

    boolean isInterface(Class cls);

    boolean isSynchronized(Class cls);
}

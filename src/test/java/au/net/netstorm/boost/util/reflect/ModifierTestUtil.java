package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.Member;
import java.lang.reflect.Method;

// Why the hell doesn't j.l.Class implement Member?!

public interface ModifierTestUtil {
    boolean isPublic(Member member);

    boolean isPublicInstance(Member member);

    boolean isStatic(Member method);

    boolean isFinal(Member member);

    // FIXME: SC042 PublicInstance.
    // FIXME: SC042 Final
    // FIXME: SC042 Static
    // FIXME: SC042 Synchronized
    // FIXME: SC042 Abstract
    // FIXME: SC042 Concrete
    // FIXME: SC042 Interface.
    // FIXME: SC042 Synchronized

    // FIXME: SC042 Coalesce these into Members.

    boolean isSynchronized(Method method);

    boolean isPublic(Class cls);

    boolean isFinal(Class cls);

    boolean isAbstract(Class cls);

    boolean isConcrete(Class cls);

    boolean isInterface(Class cls);

    boolean isSynchronized(Class cls);
}

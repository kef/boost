package au.net.netstorm.boost.spider.inject.resolver.field;

import java.util.Set;
import java.util.TreeSet;
import au.net.netstorm.boost.spider.core.Citizen;

final class Legend implements Citizen {
    Set resolveMe;
    final Set doNotResolveMe = null;
    Set doNotResolveMeEither = new TreeSet();
    Set resolveMeToo;
    private Set doNotResolveMeIAmPrivate;
    static Class doNotResolveStaticOrSynthetic;
}

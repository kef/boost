package au.net.netstorm.boost.pebble.inject.resolver.field;

import java.util.Set;
import java.util.TreeSet;

final class Legend {
    private Set resolveMe;
    private final Set doNotResolveMe = null;
    private Set doNotResolveMeEither = new TreeSet();
    private Set resolveMeToo;
}

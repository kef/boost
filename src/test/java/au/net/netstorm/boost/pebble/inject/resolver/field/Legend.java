package au.net.netstorm.boost.pebble.inject.resolver.field;

import java.util.Set;
import java.util.TreeSet;
import au.net.netstorm.boost.pebble.core.Pebble;

final class Legend implements Pebble {
    Set resolveMe;
    final Set doNotResolveMe = null;
    Set doNotResolveMeEither = new TreeSet();
    Set resolveMeToo;
    private Set doNotResolveMeIAmPrivate;
}

package au.net.netstorm.boost.spider.core;

import au.net.netstorm.boost.spider.inject.core.Injector;
import au.net.netstorm.boost.spider.resolve.Resolver;
import au.net.netstorm.boost.spider.registry.Registry;

// FIX 2394 this smells a bit to me, define what a is spider and delegate
// FIX 2394 what seems like conveniance - is about the equivelant of shooting your foot off
public interface Spider extends Nu, Injector, Resolver {
    // FIX 2394 remove me when possible
    Registry dirtyHackAllowsBootstrapToAvoidBugThatThingsCantBeResolvedIfThereAreNoFactories();
}

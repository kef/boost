package au.net.netstorm.boost.demo.pebble.resolve;

import au.net.netstorm.boost.demo.pebble.core.PebblePortal;
import au.net.netstorm.boost.demo.pebble.newer.DefaultPebbleAssembler;
import au.net.netstorm.boost.demo.pebble.newer.PebbleAssembler;
import au.net.netstorm.boost.pebble.core.Pebble;
import au.net.netstorm.boost.pebble.core.PebbleProvider;
import au.net.netstorm.boost.pebble.inject.resolver.core.Registry;
import au.net.netstorm.boost.test.cases.BoooostCase;

public final class DefaultResolveDemoTest extends BoooostCase {
    private static final Object[] NO_PARAMETERS = {};
    private final PebbleAssembler pebbleAssembler = new DefaultPebbleAssembler(Pebble.class);
    private final PebblePortal pebblePortal = pebbleAssembler.assemble();
    private final PebbleProvider pebbleProvider = pebblePortal.getProvider();
    private final Registry registry = pebblePortal.getRegistry();

    {
        registry.prototype(TheDude.class, JeffBridges.class);
        registry.prototype(Quote.class, ClassicQuote.class);
        registry.prototype(Movie.class, BigLebowski.class);
        registry.prototype(Cinema.class, RegalCinema.class);
        registry.instance(Actor.class, new PeterSellers());
        registry.instance(Celebrity.class, new BritneySpears());
        // FIX BREADCRUMB 1824 What happens when we want to create an instance that relies on another prototype/instance?
        registry.prototype(Hollywood.class, GlitzyHollywood.class);
        registry.prototype(Business.class, MovieBusiness.class);
    }

    public void testNoArgProvide() {
        TheDude theDude = (TheDude) pebbleProvider.provide(JeffBridges.class, NO_PARAMETERS);
        checkTheDudeIsReallyJeff(theDude);
    }

    public void testProvide() {
        Cinema regalCinema = (Cinema) pebbleProvider.provide(RegalCinema.class, NO_PARAMETERS);
        assertNotNull(regalCinema);
    }

    public void testProvideSingleton() {
        Hollywood hollywood = (Hollywood) provide(GlitzyHollywood.class, NO_PARAMETERS);
        Business business = (Business) provide(MovieBusiness.class, NO_PARAMETERS);
        checkSameInstances(hollywood, business);
    }

    private void checkSameInstances(Hollywood hollywood, Business business) {
        checkSameActorInstance(hollywood, business);
        checkCelebritySameInstance(hollywood, business);
    }

    private void checkCelebritySameInstance(Hollywood hollywood, Business business) {
        Celebrity hollywoodCelebrity = hollywood.getCelebrity();
        Celebrity movieCelebrity = business.getCelebrity();
        assertSame(hollywoodCelebrity, movieCelebrity);
    }

    private void checkSameActorInstance(Hollywood hollywood, Business business) {
        Actor hollywoodActor = hollywood.getActor();
        Actor movieActor = business.getActor();
        assertSame(hollywoodActor, movieActor);
    }

    private void checkTheDudeIsReallyJeff(TheDude theDude) {
        assertNotNull(theDude);
        assertEquals(true, theDude instanceof JeffBridges);
        Quote quote = theDude.getQuote();
        assertNotNull(quote);
    }

    private Object provide(Class impl, Object[] parameters) {
        Object ref = pebbleProvider.provide(impl, parameters);
        assertNotNull(ref);
        return ref;
    }
}
 
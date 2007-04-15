package au.net.netstorm.boost.demo.pebble.resolve;

import au.net.netstorm.boost.demo.pebble.core.Spidery;
import au.net.netstorm.boost.demo.pebble.newer.DefaultPebbleAssembler;
import au.net.netstorm.boost.demo.pebble.newer.PebbleAssembler;
import au.net.netstorm.boost.spider.core.Citizen;
import au.net.netstorm.boost.spider.core.Provider;
import au.net.netstorm.boost.spider.resolve.Registry;
import au.net.netstorm.boost.test.cases.BoooostCase;

public final class DefaultResolveDemoTest extends BoooostCase {
    private static final Object[] NO_PARAMETERS = {};
    private final PebbleAssembler pebbleAssembler = new DefaultPebbleAssembler(Citizen.class);
    private final Spidery spider = pebbleAssembler.assemble();
    private final Provider provider = spider;
    private final Registry registry = spider;

    {
        registry.prototype(TheDude.class, JeffBridges.class);
        registry.prototype(Quote.class, ClassicQuote.class);
        registry.prototype(Movie.class, BigLebowski.class);
        registry.prototype(Cinema.class, RegalCinema.class);
        registry.instance(Actor.class, new PeterSellers());
        registry.instance(Celebrity.class, new BritneySpears());
        registry.prototype(Hollywood.class, GlitzyHollywood.class);
        registry.prototype(Business.class, MovieBusiness.class);
    }

    public void testNoArgProvide() {
        TheDude theDude = (TheDude) provider.provide(JeffBridges.class, NO_PARAMETERS);
        checkTheDudeIsReallyJeff(theDude);
    }

    public void testProvide() {
        Cinema regalCinema = (Cinema) provider.provide(RegalCinema.class, NO_PARAMETERS);
        assertNotNull(regalCinema);
    }

    public void testProvideSingleton() {
        Hollywood hollywood = (Hollywood) provide(GlitzyHollywood.class, NO_PARAMETERS);
        Business business = (Business) provide(MovieBusiness.class, NO_PARAMETERS);
        checkSameInternals(hollywood, business);
    }

    private void checkSameInternals(Hollywood hollywood, Business business) {
        checkSameActor(hollywood, business);
        checkSameCelebrity(hollywood, business);
    }

    private void checkSameCelebrity(Hollywood hollywood, Business business) {
        Celebrity hollywoodCelebrity = hollywood.getCelebrity();
        Celebrity movieCelebrity = business.getCelebrity();
        assertSame(hollywoodCelebrity, movieCelebrity);
    }

    private void checkSameActor(Hollywood hollywood, Business business) {
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
        Object ref = provider.provide(impl, parameters);
        assertNotNull(ref);
        return ref;
    }
}
 
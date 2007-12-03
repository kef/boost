package au.net.netstorm.boost.demo.spider.resolve;

import au.net.netstorm.boost.spider.flavour.AllowOverrides;
import au.net.netstorm.boost.spider.flavour.DefaultAllowOverrides;

// SUGGEST: This test could and should be a lot simpler.  Check out BlueprintDemoTest.
public final class ResolveDemoTest extends ResolverDemooooTest {
    private AllowOverrides overrides = new DefaultAllowOverrides();
    private PeterSellers peter = new PeterSellers();
    private KeiraKnightley keira = new KeiraKnightley();

    {
        registry.multiple(TheDude.class, JeffBridges.class);
        registry.multiple(Quote.class, ClassicQuote.class);
        registry.multiple(Movie.class, BigLebowski.class);
        registry.multiple(Cinema.class, RegalCinema.class);
        registry.instance(Actor.class, peter);
        registry.single(Celebrity.class, BritneySpears.class);
        registry.multiple(Hollywood.class, GlitzyHollywood.class);
        registry.multiple(Business.class, MovieBusiness.class);
    }

    public void testNoArgProvide() {
        TheDude theDude = nu.nu(JeffBridges.class);
        checkTheDudeIsReallyJeff(theDude);
    }

    public void testProvide() {
        Cinema regalCinema = nu.nu(RegalCinema.class);
        assertNotNull(regalCinema);
    }

    public void testProvideSingleton() {
        Hollywood hollywood = (Hollywood) nu(GlitzyHollywood.class);
        Business business = (Business) nu(MovieBusiness.class);
        checkSameInternals(hollywood, business);
    }

    public void testOverrides() {
        overrideRegistry();
        checkOverriden();
    }

    private void checkOverriden() {
        TheDude dude = resolver.resolve(TheDude.class);
        assertEquals(BennyHill.class, dude.getClass());
        Actor actor = resolver.resolve(Actor.class);
        assertEquals(keira, actor);
        Celebrity celeb = resolver.resolve(Celebrity.class);
        assertEquals(ChristinaAguilera.class, celeb.getClass());
    }

    private void overrideRegistry() {
        overrides.withOverride(new Runnable() {
            public void run() {
                registry.multiple(TheDude.class, BennyHill.class);
                registry.instance(Actor.class, keira);
                registry.single(Celebrity.class, ChristinaAguilera.class);
            }
        });
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
        assertNotNull(movieActor);
        assertSame(hollywoodActor, movieActor);
        assertEquals(peter, hollywoodActor);
    }

    private void checkTheDudeIsReallyJeff(TheDude theDude) {
        assertNotNull(theDude);
        Object pTheDude = peeler.peel(theDude);
        assertEquals(true, pTheDude instanceof JeffBridges);
        Quote quote = theDude.getQuote();
        assertNotNull(quote);
    }

    private Object nu(Class impl) {
        Object ref = nu.nu(impl);
        assertNotNull(ref);
        return ref;
    }
}

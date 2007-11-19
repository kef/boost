package au.net.netstorm.boost.demo.spider.resolve;

// SUGGEST: This test could and should be a lot simpler.  Check out BlueprintDemoTest.
public final class ResolveDemoTest extends ResolverDemooooTest {
    private PeterSellers peter = new PeterSellers();

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

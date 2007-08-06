package au.net.netstorm.boost.demo.spider.resolve;

public final class ResolveDemoTest extends ResolverDemooooTest {

    {
        registry.multiple(TheDude.class, JeffBridges.class);
        registry.multiple(Quote.class, ClassicQuote.class);
        registry.multiple(Movie.class, BigLebowski.class);
        registry.multiple(Cinema.class, RegalCinema.class);
        registry.instance(Actor.class, new PeterSellers());
        registry.instance(Celebrity.class, new BritneySpears());
        registry.multiple(Hollywood.class, GlitzyHollywood.class);
        registry.multiple(Business.class, MovieBusiness.class);
    }

    public void testNoArgProvide() {
        TheDude theDude = (TheDude) provider.provide(JeffBridges.class);
        checkTheDudeIsReallyJeff(theDude);
    }

    public void testProvide() {
        Cinema regalCinema = (Cinema) provider.provide(RegalCinema.class);
        assertNotNull(regalCinema);
    }

    public void testProvideSingleton() {
        Hollywood hollywood = (Hollywood) provide(GlitzyHollywood.class);
        Business business = (Business) provide(MovieBusiness.class);
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
        Object pTheDude = peeler.peel(theDude);
        assertEquals(true, pTheDude instanceof JeffBridges);
        Quote quote = theDude.getQuote();
        assertNotNull(quote);
    }

    private Object provide(Class impl) {
        Object ref = provider.provide(impl);
        assertNotNull(ref);
        return ref;
    }
}
 
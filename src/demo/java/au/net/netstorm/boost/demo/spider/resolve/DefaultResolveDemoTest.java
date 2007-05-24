package au.net.netstorm.boost.demo.spider.resolve;

import au.net.netstorm.boost.demo.spider.core.Spider;
import au.net.netstorm.boost.demo.spider.newer.DefaultSpiderAssembler;
import au.net.netstorm.boost.demo.spider.newer.SpiderAssembler;
import au.net.netstorm.boost.spider.core.GoodCitizen;
import au.net.netstorm.boost.spider.core.Provider;
import au.net.netstorm.boost.spider.resolve.SpiderWeb;
import au.net.netstorm.boost.test.cases.BoooostCase;

public final class DefaultResolveDemoTest extends BoooostCase {
    private static final Object[] NO_PARAMETERS = {};
    private final SpiderAssembler spiderAssembler = new DefaultSpiderAssembler(GoodCitizen.class);
    private final Spider spider = spiderAssembler.assemble();
    private final Provider provider = spider;
    private final SpiderWeb web = spider;

    {
        web.prototype(TheDude.class, JeffBridges.class);
        web.prototype(Quote.class, ClassicQuote.class);
        web.prototype(Movie.class, BigLebowski.class);
        web.prototype(Cinema.class, RegalCinema.class);
        web.instance(Actor.class, new PeterSellers());
        web.instance(Celebrity.class, new BritneySpears());
        web.prototype(Hollywood.class, GlitzyHollywood.class);
        web.prototype(Business.class, MovieBusiness.class);
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
 
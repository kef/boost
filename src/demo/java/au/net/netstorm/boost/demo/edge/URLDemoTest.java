package au.net.netstorm.boost.demo.edge;

import au.net.netstorm.boost.edge.core.AutoEdger;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import demo.edge.java.net.URL;
//FIX 2328 reinstate when default package mapping implemented
public class URLDemoTest extends LifecycleTestCase implements InjectableTest {
    private URL subject;
    AutoEdger edger;

    public void testURLEdgeConstruction() {
//        String url = "http://boost";
//        subject = edger.nu(URL.class, url);
//        assertEquals(url, subject.toExternalForm());
    }

    public void testURLEdgeConstructionFailure() {
//        try {
//            edger.nu(URL.class, "..badone..");
//            fail();
//        } catch (EdgeException e) {
//            // FIX 2328 see FIX in DefaultEdgeMethod do we want to change this?
//            // FIX 2328 MAG I don't think we want to change this on DEM.
//            // FIX 2328 MAG But we probably do want to change it elsewhere.
//            // FIX 2328 MAG Agree this should look like a MURLE.
//            // assertEquals(true, e.causeIs(MalformedURLException.class));
//            assertEquals(true, e.causeIs(InvocationTargetException.class));
//        }
    }
}

package au.net.netstorm.boost.demo.nursery.autoedge;

import java.lang.reflect.InvocationTargetException;

import au.net.netstorm.boost.edge.EdgeException;
import au.net.netstorm.boost.nursery.autoedge.AutoEdger;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import demo.edge.java.net.URL;

public class URLDemoTest extends LifecycleTestCase implements InjectableTest {
    private URL subject;
    AutoEdger edger;

    public void testURLEdgeConstruction() {
        String url = "http://boost";
        subject = edger.nu(URL.class, url);
        assertEquals(url, subject.toExternalForm());
    }

    public void testURLEdgeConstructionFailure() {
        try {
            edger.nu(URL.class, "..badone..");
        } catch (EdgeException e) {
            // FIX 2328 see FIX in DefaultEdgeMethod do we want to change this?
            // assertEquals(true, e.causeIs(MalformedURLException.class));
            assertEquals(true, e.causeIs(InvocationTargetException.class));
        }
    }
}

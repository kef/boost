package au.net.netstorm.boost.demo.edge;

import java.net.MalformedURLException;

import au.net.netstorm.boost.edge.core.AutoEdger;
import au.net.netstorm.boost.edge.guts.EdgeException;
import au.net.netstorm.boost.gunge.exception.ThrowableMaster;
import demo.edge.java.net.URL;

public class URLDemoTest extends EdgeDemooooTest {
    private URL subject;
    ThrowableMaster thrower;
    AutoEdger edger;

    public void testURLEdgeConstruction() {
        String url = "http://boost";
        subject = edger.nu(URL.class, url);
        assertEquals(url, subject.toExternalForm());
    }

    public void testURLEdgeConstructionFailure() {
        try {
            edger.nu(URL.class, "..badone..");
            fail();
        } catch (EdgeException e) {
            Throwable cause = thrower.rootCause(e);
            assertEquals(true, cause instanceof MalformedURLException);
        }
    }
}


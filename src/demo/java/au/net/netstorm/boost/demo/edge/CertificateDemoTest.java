package au.net.netstorm.boost.demo.edge;

import au.net.netstorm.boost.edge.core.AutoEdger;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableTest;

public final class CertificateDemoTest extends LifecycleTestCase implements InjectableTest {
    AutoEdger edger;

    // FIX 2328 Reinstate.
    public void testEdge() {
/*
        CertificateFactoryStatic stat = edger.edge(CertificateFactoryStatic.class);
        java.io.InputStream realStream = new ByteArrayInputStream(new byte[0]);
        InputStream stream = edger.edge(InputStream.class, realStream);
        checkEdge(stat, stream);
*/
    }

/*
    private void checkEdge(CertificateFactoryStatic stat, InputStream stream) {
        CertificateFactory factory = stat.getInstance("X.509");
        Certificate certificate = factory.generateCertificate(stream);
        X509Certificate x509 = (X509Certificate) certificate;
    }
*/
}

package demo.edge.java.security.cert;

import au.net.netstorm.boost.edge.core.Edge;
import demo.edge.java.io.InputStream;

public interface CertificateFactory extends Edge<java.security.cert.CertificateFactory> {
    Certificate generateCertificate(InputStream stream);
}

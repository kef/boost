package demo.edge.java.security.cert;

import au.net.netstorm.boost.scalpel.core.Edge;
import demo.edge.java.io.InputStream;

public interface CertificateFactory extends Edge {
    Certificate generateCertificate(InputStream stream);
}

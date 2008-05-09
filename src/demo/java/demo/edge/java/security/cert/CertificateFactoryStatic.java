package demo.edge.java.security.cert;

import au.net.netstorm.boost.edge.core.Edge;

public interface CertificateFactoryStatic extends Edge {
    CertificateFactory getInstance(String type);
}

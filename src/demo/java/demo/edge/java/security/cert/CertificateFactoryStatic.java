package demo.edge.java.security.cert;

import au.net.netstorm.boost.scalpel.core.Edge;

public interface CertificateFactoryStatic extends Edge {
    CertificateFactory getInstance(String type);
}

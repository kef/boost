package demo.edge.java.security.cert;

import au.net.netstorm.boost.edge.core.StaticEdge;

public interface CertificateFactoryStatic extends StaticEdge<java.security.cert.CertificateFactory> {
    CertificateFactory getInstance(String type);
}

package demo.edge.java.security.cert;

import demo.edge.java.util.Date;

public interface X509Certificate extends Certificate {
    Date getNotAfter();
}

package au.net.netstorm.boost.nursery.autoedge;

import java.io.InputStream;

public interface AutoEdgeInputStream extends Edge<InputStream> {
    int read(byte[] out);
}

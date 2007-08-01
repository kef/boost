package au.net.netstorm.boost.util.io;

import au.net.netstorm.boost.edge.java.io.EdgeInputStream;
import au.net.netstorm.boost.edge.java.io.EdgeOutputStream;

public final class DefaultStreamConverter implements StreamConverter {
    private static final int BUFFER_SIZE = 4096;

    public void write(EdgeOutputStream destination, byte[] bytes) {
        destination.write(bytes);
        destination.flush();
    }

    // Do not use an algorithm which does byte[] -> String -> byte[] as localisation nails ya.
    public byte[] read(EdgeInputStream stream) {
        byte[] result = {};
        byte[] buf = new byte[BUFFER_SIZE];
        while (true) {
            int count = stream.read(buf);
            // SUGGEST Change this unbounded loop to <= 0...
            // SUGGEST: Pass in a content length.
            // SUGGEST: Use read(buf, offset, len).
            if (count == -1) break;
            result = append(result, count, buf);
        }
        return result;
    }

    private byte[] append(byte[] original, int count, byte[] buf) {
        int origSize = original.length;
        int newSize = origSize + count;
        byte[] result = new byte[newSize];
        System.arraycopy(original, 0, result, 0, origSize);
        System.arraycopy(buf, 0, result, origSize, count);
        return result;
    }
}

package au.net.netstorm.boost.util.io;

public final class DefaultStreamConverter implements StreamConverter {
    private static final int BUFFER_SIZE = 4096;

    public void write(EdgeOutputStream destination, byte[] bytes) {
        destination.write(bytes);
        destination.flush();
    }

    public byte[] read(EdgeInputStream stream) {
        byte[] buf = new byte[BUFFER_SIZE];
        String result = spin(stream, buf);
        return result.getBytes();
    }

    private String spin(EdgeInputStream stream, byte[] buf) {
        String result = "";
        while (true) {
            int count = stream.read(buf);
            if (count == -1) break;
            result += new String(buf, 0, count);
        }
        return result;
    }
}

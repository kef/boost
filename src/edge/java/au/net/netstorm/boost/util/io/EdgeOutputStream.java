package au.net.netstorm.boost.util.io;

public interface EdgeOutputStream extends EdgeStream {
    void write(byte[] bytes);

    void flush();
}

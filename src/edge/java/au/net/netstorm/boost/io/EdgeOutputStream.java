package au.net.netstorm.boost.io;

public interface EdgeOutputStream extends EdgeStream {
    void write(byte[] bytes);

    void flush();
}

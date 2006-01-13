package au.net.netstorm.boost.util.io;

public interface EdgeOutputStream {
    void flush();

    void write(byte[] bytes);
}

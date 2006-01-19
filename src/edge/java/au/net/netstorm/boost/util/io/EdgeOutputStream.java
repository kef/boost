package au.net.netstorm.boost.util.io;

public interface EdgeOutputStream {
    void write(byte[] bytes);

    void flush();

    void close();

}

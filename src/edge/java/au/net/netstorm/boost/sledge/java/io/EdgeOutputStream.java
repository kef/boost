package au.net.netstorm.boost.sledge.java.io;

public interface EdgeOutputStream extends EdgeStream {
    void write(byte[] bytes);

    void flush();
}

package au.net.netstorm.boost.edge.java.io;

public interface EdgeOutputStream extends EdgeStream {
    void write(byte[] bytes);

    void flush();
}

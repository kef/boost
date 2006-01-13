package au.net.netstorm.boost.util.io;

public interface StreamConverter {
    void write(EdgeOutputStream destination, byte[] bytes);

    byte[] read(EdgeInputStream stream);
}

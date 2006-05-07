package au.net.netstorm.boost.io;

public interface StreamConverter {
    void write(EdgeOutputStream destination, byte[] bytes);

    byte[] read(EdgeInputStream stream);
}

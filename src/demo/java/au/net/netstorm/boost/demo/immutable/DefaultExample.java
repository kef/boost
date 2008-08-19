package au.net.netstorm.boost.demo.immutable;

public final class DefaultExample implements Example {
    Socker socker;

    public void example() {
        Sock sock = socker.sock();
        Host host = sock.host();
        Port port = sock.port();
        System.out.println("work = " + sock);
    }
}

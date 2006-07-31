package au.net.netstorm.boost.start;

// NOTE: IllegalArgumentExceptions here have untested comment strings as this is a special case - JVM entry point.
// The exception stacktrace is not seen by many tools calling us.

// FIX SC509 ? Experiment with the SPECIAL-CASE flag.
public final class VmEntry {
    private VmEntry() {
    }

    private static VmEntry instance = new VmEntry();
    private Bootstrapper bootstrapper = new DefaultBootstrapper(); // FIX SC509 Test this with a wiring test.

    public static void main(String[] args) {
        validateArgList(args);
        validateArgs(args);
        String argument = args[0];
        VmStyle style = new VmStyle(argument);
        instance.bootstrapper.bootstrap(style);
    }

    private static void validateArgs(String[] args) {
        if (args[0] == null) fail("VmStyle cannot be null.");
    }

    private static void validateArgList(String[] args) {
        if (args == null) fail("Argument list is null.");
        int length = args.length;
        if (length != 1) fail("Incorrect number of arguments.  Expected 1 but got " + length);
    }

    private static void fail(String msg) {
        throw new IllegalArgumentException("Usage: VmEntry <style>.  " + msg);
    }
}

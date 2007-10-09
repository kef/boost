package au.net.netstorm.boost.nursery.log;

// OK InterfaceIsType {
public interface LogLevel {
    LogLevel TRACE = new DefaultLogLevel("TRACE");
    LogLevel DEBUG = new DefaultLogLevel("DEBUG");
    LogLevel INFO = new DefaultLogLevel("INFO");
    LogLevel WARN = new DefaultLogLevel("WARN");
    LogLevel ERROR = new DefaultLogLevel("ERROR");
}
// } OK InterfaceIsType

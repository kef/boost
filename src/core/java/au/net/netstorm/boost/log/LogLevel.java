package au.net.netstorm.boost.log;

import au.net.netstorm.boost.util.type.Data;

// OK InterfaceIsType {
public interface LogLevel extends Data {
    LogLevel TRACE = new DefaultLogLevel("TRACE");
    LogLevel DEBUG = new DefaultLogLevel("DEBUG");
    LogLevel INFO = new DefaultLogLevel("INFO");
    LogLevel WARN = new DefaultLogLevel("WARN");
    LogLevel ERROR = new DefaultLogLevel("ERROR");
}
// } OK InterfaceIsType

package au.net.netstorm.boost.bullet.log;

import au.net.netstorm.boost.gunge.type.Data;

// OK InterfaceIsType {
public interface LogLevel extends Data {
    // DO NOT ADD "debug" or "fatal".  There is:
    //  . User oriented logging (error, warn, info)
    //  . Programmer oriented logging (trace)
    LogLevel TRACE = new DefaultLogLevel("TRACE");
    LogLevel INFO = new DefaultLogLevel("INFO");
    LogLevel WARN = new DefaultLogLevel("WARN");
    LogLevel ERROR = new DefaultLogLevel("ERROR");
}
// } OK InterfaceIsType

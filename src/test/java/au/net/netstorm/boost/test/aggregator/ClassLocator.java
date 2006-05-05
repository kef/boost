/*
 * Copyright (C) 2005 Transtoll Pty Limited.
 */
package au.net.netstorm.boost.test.aggregator;

import java.io.File;

public interface ClassLocator {
    DefaultClassName[] locate(File root, RegexPattern pattern);
}

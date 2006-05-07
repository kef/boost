/*
 * Copyright (C) 2005 Transtoll Pty Limited.
 */
package au.net.netstorm.boost.test.aggregator;

import java.io.File;

interface ClassLocator {
    JavaClass[] locate(File root, RegexPattern pattern);
}

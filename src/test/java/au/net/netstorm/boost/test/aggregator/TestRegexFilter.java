package au.net.netstorm.boost.test.aggregator;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// FIXME: SC043 De train wreck.

final class TestRegexFilter implements FileFilter {
    private final Pattern pattern;

    public TestRegexFilter(RegexPattern pattern) {
        this.pattern = Pattern.compile(pattern.getPattern());
    }

    public boolean accept(File file) {
        if (file.isDirectory()) return false;
        Matcher m = pattern.matcher(file.getAbsolutePath());
        return m.matches();
    }
}

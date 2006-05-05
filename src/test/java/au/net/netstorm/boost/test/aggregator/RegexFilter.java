package au.net.netstorm.boost.test.aggregator;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// FIXME: SC043 De train wreck.

class RegexFilter implements FileFilter {
    private final Pattern pattern;

    public RegexFilter(RegexPattern pattern) {
        this.pattern = Pattern.compile(pattern.getPattern());
    }

    public boolean accept(File file) {
        if (file.isDirectory()) return false;
        Matcher m = pattern.matcher(file.getAbsolutePath());
        return m.matches();
    }
}

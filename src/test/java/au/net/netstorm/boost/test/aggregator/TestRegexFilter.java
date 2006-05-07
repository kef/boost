package au.net.netstorm.boost.test.aggregator;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import au.net.netstorm.boost.primordial.Primordial;

final class TestRegexFilter extends Primordial implements FileFilter {
    private final Pattern pattern;

    public TestRegexFilter(RegexPattern regexPattern) {
        String pattern = regexPattern.getPattern();
        this.pattern = Pattern.compile(pattern);
    }

    public boolean accept(File file) {
        if (file.isDirectory()) return false;
        String absolutePath = file.getAbsolutePath();
        Matcher m = pattern.matcher(absolutePath);
        return m.matches();
    }
}

package au.net.netstorm.boost.util.indent;

public interface IndenterMaster {
    // FIXME: SC501 Move this up into super interface (Indent).
    String INDENT = "    ";

    String indent(String s);
}

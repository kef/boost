package au.net.netstorm.boost.start;

class MockBootstrapper implements Bootstrapper {
    private VmStyle style;

    public void bootstrap(VmStyle style) {
        this.style = style;
    }

    public VmStyle getStyle() {
        return style;
    }
}

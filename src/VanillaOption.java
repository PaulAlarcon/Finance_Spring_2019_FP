class VanillaOption extends Derivative {

    static enum TYPE {PUT, CALL};
    static enum VERSION{AMERICAN, EUROPE};

    public TYPE type;
    public VERSION version;

    public VanillaOption(double t, TYPE type, VERSION version) {
        T = t;
        this.type = type;
        this.version = version;
    }

    @Override
    public void terminalCondition(Node n) {

    }

    @Override
    public void valuationTest(Node n) {

    }
}


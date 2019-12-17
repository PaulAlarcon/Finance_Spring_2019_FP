import static java.lang.Math.exp;

class VanillaOption extends Derivative {

    static enum TYPE {PUT, CALL};
    static enum VERSION{AMERICAN, EUROPE};

    public TYPE type;
    public VERSION version;

    public VanillaOption(double t, double strPrice, TYPE type, VERSION version) {
        T = t;
        this.type = type;
        this.version = version;
        this.strikePrice = strPrice;
    }

    @Override
    public void terminalCondition(Node n) {
        if(type == TYPE.CALL){
            n.fairValue = max( n.stockPrice - strikePrice , 0) ;
        }
        else if(type == TYPE.PUT){
            n.fairValue = max( strikePrice - n.stockPrice , 0) ;
        }
        n.fugit = fugitAtN;
    }

    @Override
    public void valuationTest(Node n) {
        if(version == VERSION.EUROPE){
            n.fairValue = invDk*(p*n.rChild.fairValue + q*n.lChild.fairValue);
        }
        else if(version == VERSION.AMERICAN){
            if(type == TYPE.PUT){
                n.intrinsicValue = max(strikePrice - n.stockPrice, 0);
            }
            else if(type == TYPE.CALL){
                n.intrinsicValue = max(n.stockPrice - strikePrice, 0);
            }
            n.fairValue = invDk*(p*n.rChild.fairValue + q*n.lChild.fairValue);

            double tempFugit = 0;
            if(n.intrinsicValue > n.fairValue){
                n.EEX = true;
                n.fairValue = n.intrinsicValue;
                if(n.n != 0) {
                    tempFugit = n.n * deltaT;
                }
                else {
                    tempFugit = 0;
                }
            }
            else{
                tempFugit = (p*n.rChild.fugit + q*n.lChild.fugit);
            }
            n.fugit = tempFugit;
        }


    }

}


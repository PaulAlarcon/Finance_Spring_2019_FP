public class Main {

    public static void main(String args[]){
        Library l = new Library();
        VanillaOption americanPut = new VanillaOption(0.3, VanillaOption.TYPE.PUT, VanillaOption.VERSION.AMERICAN);
        MarketData mD = new MarketData(100, 100, 0.1, 0.4, 0);
        int n = 4;
        l.binom(americanPut, mD, 3);
    }

}

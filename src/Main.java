public class Main {

    public static void main(String args[]){
        Library l = new Library();
        VanillaOption americanPut = new VanillaOption(0.3, 100, VanillaOption.TYPE.PUT, VanillaOption.VERSION.AMERICAN);
        VanillaOption americanCall = new VanillaOption(0.3, 100, VanillaOption.TYPE.CALL, VanillaOption.VERSION.AMERICAN);
//        VanillaOption europeanPut = new VanillaOption(0.3, 100, VanillaOption.TYPE.PUT, VanillaOption.VERSION.EUROPE);
//        VanillaOption europeanCall = new VanillaOption(0.3, 100, VanillaOption.TYPE.CALL, VanillaOption.VERSION.EUROPE);

        MarketData mD = new MarketData(100, 0.1, 0.5, 0);
        System.out.println(l.binom(americanPut, mD, 3));
//        System.out.println(l.binom(americanPut, mD, 4));
//        System.out.println(l.binom(americanCall, mD, 4));
    }

}

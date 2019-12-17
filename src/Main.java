public class Main {

    public static void main(String args[]){
//        VanillaOption europeanPut = new VanillaOption(0.3, 100, VanillaOption.TYPE.PUT, VanillaOption.VERSION.EUROPE);
//        VanillaOption europeanCall = new VanillaOption(0.3, 100, VanillaOption.TYPE.CALL, VanillaOption.VERSION.EUROPE);


//        System.out.println(l.binom(americanPut, mD, 3));
//        System.out.println(l.binom(americanPut, mD, 4));
//        System.out.println(l.binom(americanCall, mD, 4));


        Library l = new Library();
//        VanillaOption americanCall = new VanillaOption(0.3, 100, VanillaOption.TYPE.CALL, VanillaOption.VERSION.AMERICAN);
        VanillaOption americanPut = new VanillaOption(0.4, 100, VanillaOption.TYPE.PUT, VanillaOption.VERSION.AMERICAN);
        MarketData mD = new MarketData(100, 0.1, 0.01, 0); // for impliedvol we are not using sigma at all
        System.out.println(l.binom(americanPut, mD, 4));

        mD.setPrice(10.446); // you need fairValue at root;
        Output out = new Output();
        l.impvol(americanPut, mD, 4, 100, 000000.1, out );
        System.out.println(out.impvol);



    }

}

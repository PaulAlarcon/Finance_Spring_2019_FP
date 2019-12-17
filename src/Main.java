public class Main {

    public static void main(String args[]){
//        VanillaOption europeanPut = new VanillaOption(0.3, 100, VanillaOption.TYPE.PUT, VanillaOption.VERSION.EUROPE);
//        VanillaOption europeanCall = new VanillaOption(0.3, 100, VanillaOption.TYPE.CALL, VanillaOption.VERSION.EUROPE);


//        System.out.println(l.binom(americanPut, mD, 3));
//        System.out.println(l.binom(americanPut, mD, 4));
//        System.out.println(l.binom(americanCall, mD, 4));


        Library l = new Library();
//        VanillaOption americanCall = new VanillaOption(0.3, 100, VanillaOption.TYPE.CALL, VanillaOption.VERSION.AMERICAN);
//        VanillaOption americanPut = new VanillaOption(1, 105, VanillaOption.TYPE.CALL, VanillaOption.VERSION.AMERICAN);
        MarketData mD = new MarketData(100, 0.1, 0.1, 0); // for impliedvol we are not using sigma at all
        BermudanOption bermudanCall = new BermudanOption(1, 105, 0.2,0.3, BermudanOption.TYPE.CALL);
        System.out.println(l.binom(bermudanCall, mD, 4));


//
//        mD.setPrice(20); // you need fairValue at root;
//        Output out = new Output();
//        l.impvol(bermudanCall, mD, 4, 100, 0.01, out );
//        System.out.println(out.impvol + " " + out.num_iter);



    }

}

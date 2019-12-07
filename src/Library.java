
import java.lang.Math.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

import static java.lang.Math.exp;
import static java.lang.Math.sqrt;

final class Library {

    Output binom(final Derivative deriv, final MarketData mkt, int n){

        if(n < 1){
            System.out.println("Invalid number n");
            return null;
        }

        double deltaT = (deriv.T - mkt.t0)/n;
        float u = (float) ( exp(mkt.sigma * sqrt(deltaT) ));
        float d = 1/u;
        float dk = (float) exp(mkt.r*deltaT);
        float InvDk = (float) 1/dk;

        float p = (dk - d)/(u-d);
        float q = 1 - p;

        Node root = new Node(mkt.Price);

        ArrayList<ArrayList<Node>> tree = new ArrayList<>();
        tree.add(new ArrayList<>(1));
        tree.get(0).add(root);

        int i;
        //Array initialization
        for(i = 1; i <=  n + 1; i++){
            tree.add(new ArrayList<>(n));
        }

        for(i = 1; i <= n + 1; i++){
            int firstIndex = 0;
            int prevLastIndex  = n - 2;
            int sizePrevStep = n - 1;

            if( sizePrevStep == 1){
                double tempVal =  tree.get(i - 1).get(firstIndex).fairValue;
                tree.get(i).add(new Node(tempVal * u));
                tree.get(i).add(new Node(tempVal * d));
            }
            else{
                double prevU =  tree.get(i - 1).get(firstIndex).fairValue;
                double prevD = tree.get(i - 1).get(prevLastIndex).fairValue;
                tree.get(i).add(new Node(prevU * u));
                tree.get(i).add(new Node(prevD * d));
            }

        }

//        for(i = 0; i < tree.size(); i++) {
//            System.out.print(tree.get(i).fairValue + " ");
//        }

//        System.out.println(deltaT);
//        System.out.println(u);
//        System.out.println(d);
//        System.out.println(dk);
//        System.out.println(InvDk);
//        System.out.println(p);
//        System.out.println(q);

        return null;

    };

    int impvol(final Derivative deriv, final MarketData mkt, int n , int max_iter , double tol , Output out){
    // The function impvol executes a loop of iterations to calculate the implied volatility of a derivative.
//        The market price of the derivative is supplied in theMarketDataobject.
//        To calculate the implied volatility, the functionimpvolcallsbinomin a loop.
//        The number of loop iterations and the implied volatility are returned in theOutputobject.
        // The function must not change the input data, hence they are tagged asfinalobjects.


        return 1;
    };

}


/*
ROOT
    Left Child
        Left Child
            Left Child
            Right Child
        Right Child
            Left Child
            Right Child
    Right Child
        Left Child
            Left Child
            Right Child
        Right Child
            Left Child
            Right Child
 */

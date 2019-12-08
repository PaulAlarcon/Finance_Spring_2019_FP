
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

        Node root = new Node(mkt.Price, 0);

        Node tree[][] = new Node[n + 1][n + 1];
        //set root at first array, first pos
        tree[0][0] = root;
        tree[1][0] = new Node(root.fairValue * d, 1  ); // sets
        tree[1][1] = new Node(root.fairValue * u, 1 );
        tree[2][1] = new Node(root.fairValue, 2);

        int level = 2;
        for(int i = 2; i < n + 1; i++){
            tree[i][0] = new Node(tree[i - 1][0].fairValue * d, i); // down
            tree[i][level] = new Node( tree[i - 1][level - 1].fairValue * u, i); // up
            for(int j = 1; j < level; j++){
                    tree[i][j] = new Node(tree[i - 2][j - 1].fairValue, i);
            }
            level++;

        }

        // Printing
        for(int i = 0; i < tree.length; i++){
            for(int j = 0; j < tree[i].length; j++){
                if(tree[i][j] != null){
                    System.out.print( tree[i][j].fairValue + " ");
                }
                else {
                    System.out.print(" ( ) ");
                }
            }
            System.out.println();
        }

//        for(i = 1; i <= n + 1; i++){
//            int firstIndex = 0;
//            int prevLastIndex  = n - 2;
//            int sizePrevStep = n - 1;
//
//            if( sizePrevStep == 1){
//                double tempVal =  tree.get(i - 1).get(firstIndex).fairValue;
//                tree.get(i).add(new Node(tempVal * u));
//                tree.get(i).add(new Node(tempVal * d));
//            }
//            else{
//                double prevU =  tree.get(i - 1).get(firstIndex).fairValue;
//                double prevD = tree.get(i - 1).get(prevLastIndex).fairValue;
//                tree.get(i).add(new Node(prevU * u));
//                tree.get(i).add(new Node(prevD * d));
//            }
//
//        }
//
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
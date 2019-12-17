import static java.lang.Math.exp;
import static java.lang.Math.sqrt;

final class Library {

    Output binom(final Derivative deriv, final MarketData mkt, int n) {

        if (n < 1) {
            System.out.println("Invalid number n");
            return null;
        }

        double deltaT = (deriv.T - mkt.t0) / n;
        double u = (exp(mkt.sigma * sqrt(deltaT)));
        double d = 1 / u;
        double dk =  exp(mkt.r * deltaT);
        double InvDk =  1 / dk;
        double p = (dk  - d) / (u - d);
        double q = 1 - p;
        double fugitAtN = deriv.T - mkt.t0;
        deriv.calculateParemeters( deltaT, u, d, dk, InvDk, p, q, fugitAtN);

        Node tree[][] = new Node[n + 1][n + 1];
        Node root = new Node( mkt.S,0);
        tree[0][0] = root;

        for (int i = 1; i < n + 1; i++) {

            if(i == 1){
                tree[i][0] = new Node(tree[0][0].stockPrice * d, 1); // sets
                tree[i][i] = new Node(tree[0][0].stockPrice * u,1);
            }

            tree[i][0] = new Node(tree[i - 1][0].stockPrice * d, i); // down
            tree[i][i] = new Node(tree[i - 1][i - 1].stockPrice * u, i); // up

            for (int j = 1; j < i; j++) {
                tree[i][j] = new Node(tree[i - 2][j - 1].stockPrice, i);
            }
        }

        for(int i = 0; i < tree.length - 1; i++){
            for(int j = 0; j < i + 1; j++){
                tree[i][j].setChildren(tree[i + 1 ][j], tree[i + 1][j + 1]);
            }
        }

        for(int j = tree.length - 1; j >= 0; j--){
            for(int i = 0; i <= j; i++){
                if(j == tree.length - 1){
                    deriv.terminalCondition(tree[j][i]);
                }
                else{
                    deriv.valuationTest(tree[j][i]);
                }
            }
        }

//        printTree(tree);

        return new Output(root.fairValue, root.fugit);

    }

    int impvol(final Derivative deriv, final MarketData mkt, int n, int max_iter, double tol, Output out) {
        // The function impvol executes a loop of iterations to calculate the implied volatility of a derivative.
//        The market price of the derivative is supplied in theMarketDataobject.
//        To calculate the implied volatility, the functionimpvolcallsbinomin a loop.
//        The number of loop iterations and the implied volatility are returned in theOutputobject.
        // The function must not change the input data, hence they are tagged asfinalobjects.


        return 1;
    }

    //ROTATE
    static void printTree(Node[][] tree) {
        for (int i = 0; i < tree.length; i++) {
            for (int j = 0; j < tree[i].length; j++) {
                if (tree[i][j] != null)
                    System.out.print(" |" + tree[i][j].fugit + " |");
            }

            System.out.println();
        }
    }

}
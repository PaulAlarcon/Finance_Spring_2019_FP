final class Output {
    public double FV;      // fair value
    public double fugit;   // fugit
    public double impvol;  // implied volatility
    public int num_iter;   // number of iterations to compute implied volatility

    //Output for binom
    public Output(double FV, double fugit) {
        this.FV = FV;
        this.fugit = fugit;
    }

    //Output for impvol
    public Output(double impvol, int num_iter) {
        this.impvol = impvol;
        this.num_iter = num_iter;
    }
}

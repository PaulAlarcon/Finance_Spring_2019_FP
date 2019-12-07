
//This class is set in a calling application

class MarketData {
        public double Price;          // market price of security
        public double S;              // stock price
        public double r;              // interest rate
        public double sigma;          // volatility
        public double t0;             // current time


        public MarketData(double price, double s, double r, double sigma, double t0) {
                Price = price;
                S = s;
                this.r = r;
                this.sigma = sigma;
                this.t0 = t0;
        }
}

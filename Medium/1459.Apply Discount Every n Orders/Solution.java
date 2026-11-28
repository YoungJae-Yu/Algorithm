class Cashier {
    private final int n;
    private final int discount;
    private final int[] price = new int[201];
    private int count = 0;

    public Cashier(int n, int discount, int[] products, int[] prices) {
        this.n = n;
        this.discount = discount;
        for (int i = 0; i < products.length; i++) {
            price[products[i]] = prices[i];
        }
    }

    public double getBill(int[] product, int[] amount) {
        count++;
        long total = 0;
        for (int i = 0; i < product.length; i++) {
            total += (long) price[product[i]] * amount[i];
        }
        if (count % n == 0) {
            return total * (100 - discount) / 100.0;
        }
        return (double) total;
    }
}
public class Week7P5 {
    
}
public class Week7P5 {

    static class Cart {
        private double[] prices;
        private int itemCount;
        private final String cartId;

        Cart(String cartId, int maxItems) {
            this.cartId = cartId;
            prices = new double[maxItems];
            itemCount = 0;
        }

        void addItem(double price) {
            if (itemCount < prices.length) {
                prices[itemCount] = price;
                itemCount++;
            }
        }

        double getTotal() {
            double total = 0;

            for (int i = 0; i < itemCount; i++) {
                total += prices[i];
            }

            return total;
        }

        int getItemCount() {
            return itemCount;
        }
    }

    public static void main(String[] args) {

        Cart cart = new Cart("CART-5", 20);

        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("Total: " + cart.getTotal());
        System.out.println("Count: " + cart.getItemCount());
    }
}
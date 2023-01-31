public class Money {
    /**
     * This method counts total amount of money.
     * @param cents the list of cents that will be counted.
     * @return the total count.
     */
    public static double countTotal(int[] cents) {
        if (cents.length == 0) {
            return 0;
        }
        double price = 0;
        int len = cents.length;
        int[] arr = {};
        if (len == 0) {
            return 0;
        } else {
            price = cents[0];
            arr = new int[len - 1];
            for (int i = 1; i < cents.length; i++) {
                arr[i - 1] = cents[i];
            }
        }
        return price / 100.0 + countTotal(arr);
    }
    /**
     * This method calculates difference between payment and price.
     * @param price the price of product.
     * @param cents the list of cents received.
     * @return the difference in dollars.
     */
    public static double findDifference(double price, int[] cents) {
        double money = 0;
        int len = cents.length;
        int[] arr = {};
        if (len == 0) {
            return price;
        } else {
            money = cents[0] / 100.0;
            price = price - money;
            arr = new int[len - 1];
            for (int i = 1; i < cents.length; i++) {
                arr[i - 1] = cents[i];
            }
        }
        return findDifference(price, arr);
    }
    /**
     * This method finds most effective way for changing.
     * @param change that needs to be made.
     * @return the number of trial.
     */
    public static int makeChange(int change) {
        int[] coin =  {25, 10, 5, 1};
        int size = coin.length;
        int answers = Integer.MAX_VALUE;
        if (change <= 0) {
            return 0;
        } else {
            for (int i = 0; i < size; i++) {
                if (coin[i] == change) {
                    return 1;
                } else if (coin[i] < change) {
                    int min = 1 + makeChange(change - coin[i]);
                    if (min < answers && min != Integer.MAX_VALUE) {
                        answers = min;
                    }
                }
            }
        }
        return answers;
    }
    /**
     * This method finds most effective way for changing.
     * @param change that needs to be made.
     * @param possible the list of cents.
     * @return the number of trial.
     */
    public static int makeChange(int change, int[] possible) {
        int size2 = possible.length;
        int answers2 = Integer.MAX_VALUE;
        if (change <= 0) {
            return 0;
        } else {
            for (int i = 0; i < size2; i++) {
                if (possible[i] == change) {
                    return 1;
                } else if (possible[i] < change) {
                    int min2 = 1 + makeChange(change - possible[i], possible);
                    if (min2 < answers2 && min2 != Integer.MAX_VALUE) {
                        answers2 = min2;
                    }
                }
            }
            if (answers2 == Integer.MAX_VALUE) {
                return 0;
            }
            return answers2;
        }
    }
}
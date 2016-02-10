package common;

/**
 * Borrowed from
 * https://github.com/java8/Java8InAction
 *
 * Java 8 in Action
 * Lambdas, streams, and functional-style programming
 * Raoul-Gabriel Urma, Mario Fusco, and Alan Mycroft
 */
public class Transaction {

    private Trader trader;
    private int year;
    private int value;

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return this.trader;
    }

    public int getYear() {
        return this.year;
    }

    public int getValue() {
        return this.value;
    }

    public String toString() {
        return "{" + this.trader + ", " +
                "year: " + this.year + ", " +
                "value:" + this.value + "}";
    }
}
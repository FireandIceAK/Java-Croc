package ru.croc.task11;

import java.util.concurrent.atomic.AtomicReference;

public class Main {
    private final AtomicReference<Long> currentTimeMillis = new AtomicReference<>(0L);
    private final AtomicReference<Long> timeExpirationMillis = new AtomicReference<>(0L);
    private final AtomicReference<String> currentHighBidder = new AtomicReference<>("");
    private final AtomicReference<Double> currentPrice = new AtomicReference<>(0.0);

    public Main(long timeExpirationMillis) {
        this.currentTimeMillis.set(System.currentTimeMillis());
        this.timeExpirationMillis.set(timeExpirationMillis);
    }

    public synchronized boolean bid(String bidderName, double bidPrice) {
        long now = System.currentTimeMillis();
        if (now < timeExpirationMillis.get() && bidPrice > currentPrice.get()) {
            currentPrice.set(bidPrice);
            currentHighBidder.set(bidderName);
            return true;
        }
        return false;
    }

    public synchronized String getWinnerName() {
        long now = System.currentTimeMillis();
        if (now >= timeExpirationMillis.get()) {
            return currentHighBidder.get();
        } else {
            return null;
        }
    }

    public long getCurrentTimeMillis() {
        return currentTimeMillis.get();
    }

    public long getTimeExpirationMillis() {
        return timeExpirationMillis.get();
    }

    public String getCurrentHighBidder() {
        return currentHighBidder.get();
    }

    public double getCurrentPrice() {
        return currentPrice.get();
    }
}
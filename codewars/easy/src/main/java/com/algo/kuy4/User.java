package com.algo.kuy4;

public class User {
    int rank;
    int progress;

    public User() {
        this.rank = -8;
    }

    public void incProgress(int progress) {
        if (progress > rank) {
            int d = Math.abs(progress) - Math.abs(rank);
            this.progress += 10 * Math.pow(d, 2);
        }
        if (progress == rank) {
            this.progress += 10;
        }
        if (this.progress >= 100) {
            rank++;
            this.progress -= 100;
        }
    }
}

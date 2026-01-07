package org.greg.BankSystem.Enums;

public enum AccountType {
    SIMPLE {
        public boolean canDeposit(double value) {
            return value <= 300;
        }

        public boolean canWithdraw(double value, double balance) {
            return value > 0 && value <= 200 && value <= balance;
        }
    },
    MIDDLE {
        public boolean canDeposit(double value) {
            return value <= 1000;
        }

        public boolean canWithdraw(double value, double balance) {
            return value > 0 && value <= 500 && value <= balance;
        }
    },
    GOLD {
        public boolean canDeposit(double value) {
            return true;
        }

        public boolean canWithdraw(double value, double balance) {
            return value > 0 && value <= balance;
        }
    };

    public abstract boolean canDeposit(double value);
    public abstract boolean canWithdraw(double value, double balance);
}

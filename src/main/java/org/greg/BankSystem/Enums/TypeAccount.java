package org.greg.BankSystem.Enums;

public enum TypeAccount {
    SIMPLE {
        public boolean canDeposit(double value) {
            return value <= 300;
        }
    },
    MIDDLE {
        public boolean canDeposit(double value) {
            return value <= 1000;
        }
    },
    GOLD {
        public boolean canDeposit(double value) {
            return true;
        }
    };

    public abstract boolean canDeposit(double value);
}

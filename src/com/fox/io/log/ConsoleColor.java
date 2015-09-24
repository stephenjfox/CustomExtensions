package com.fox.io.log;

/**
 * Created by stephen on 7/28/15.
 */
public enum ConsoleColor {

    RESET {
        @Override
        public String ansiCode() {
            return "\u001B[0m";
        }
    },
    BLACK {
        @Override
        public String ansiCode() {
            return "\u001B[30m";
        }
    },
    RED {
        @Override
        public String ansiCode() {
            return "\u001B[31m";
        }
    },
    GREEN {
        @Override
        public String ansiCode() {
            return "\u001B[32m";
        }
    },
    YELLOW {
        @Override
        public String ansiCode() {
            return "\u001B[33m";
        }
    },
    BLUE {
        @Override
        public String ansiCode() {
            return "\u001B[34m";
        }
    },
    PURPLE {
        @Override
        public String ansiCode() {
            return "\u001B[35m";
        }
    },
    CYAN {
        @Override
        public String ansiCode() {
            return "\u001B[36m";
        }
    },
    WHITE {
        @Override
        public String ansiCode() {
            return "\u001B[37m";
        }
    };

    public abstract String ansiCode();
}
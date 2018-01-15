package com.example.mohit.waterjug;

class State {
    /*
     * Amount in jug1 for current State
     */

    int x;
    /*
     * Amount in jug2 for current State
     */
    int y;

    /*
     * Parent of current State
     */
    State pre;

    public State(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    public State(int x, int y, State pre) {
        super();
        this.x = x;
        this.y = y;
        this.pre = pre;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        State other = (State) obj;
        if (x != other.x) {
            return false;
        }
        if (y != other.y) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (pre != null) {
            builder.append(pre);
        }
        builder.append(x);
        builder.append("    ").append(y).append("\n");
        return builder.toString();
    }
}

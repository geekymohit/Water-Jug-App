package com.example.mohit.waterjug;
import android.os.Build;
import android.util.Log;

import java.util.HashSet;
import java.util.LinkedList;
//import java.util.Scanner;


class WaterJugBFS {


    HashSet<State> uniqueStates;
    State finalPath , initialState , finalState;
    int flag ;
    public void letsRoll(int a , int b , int c) {
        /*
         * The capacity of jug1(jug1 capacity is greater than jug2 capacity)
         */

        //System.out.println("\nEnter the capacity of your first(1st) jug : ");
        int jug1 = a;


        /*
         * The capacity of jug two
         */
        //System.out.println("\nEnter the capacity of your first( 2nd ) jug : ");
        int jug2 = b;

        /*
         * Final Amount needed in jug1
         */
        //System.out.println("\nEnter the amount of water you need in  your first jug : ");
        int amtNeeded = c;

        initialState = new State(0, 0);
        finalState = new State(amtNeeded, 0);
        finalPath = null;


        uniqueStates = new HashSet<>();

        /*
         * Change queue to stack to convert to DFS
         */
        LinkedList<State> queue = new LinkedList<>();
        queue.add(initialState);

        while (!queue.isEmpty()) {
            State currState = queue.poll();
            if (currState.equals(finalState)) {
                finalPath = currState;
                break;
            }

            // if x is zero fill it
            if (currState.x == 0) {
                State nextState = new State(jug1, currState.y, currState);
                checkUniqueStates(uniqueStates, nextState, queue);
            }

            // if y is empty fill it
            if (currState.y == 0) {
                State nextState = new State(currState.x, jug2, currState);
                checkUniqueStates(uniqueStates, nextState, queue);
            }

            // if x is not empty , empty it
            if (currState.x > 0) {
                State nextState = new State(0, currState.y, currState);
                checkUniqueStates(uniqueStates, nextState, queue);
            }

            // if y is not empty, empty it
            if (currState.y > 0) {
                State nextState = new State(currState.x, 0, currState);
                checkUniqueStates(uniqueStates, nextState, queue);
            }

            // transfer from x to y, when x non empty and y is not full
            if (currState.x > 0 && currState.y < jug2) {
                int amtToTransfer = Math.min(currState.x, jug2 - currState.y);
                State nextState = new State(currState.x - amtToTransfer, currState.y
                        + amtToTransfer,
                        currState);
                checkUniqueStates(uniqueStates, nextState, queue);
            }

            // transfer from y to x, when y is not empty and x is not full
            if (currState.y > 0 && currState.x < jug1) {
                int amtToTransfer = Math.min(currState.y, jug1 - currState.x);
                State nextState = new State(currState.x + amtToTransfer, currState.y
                        - amtToTransfer,
                        currState);
                checkUniqueStates(uniqueStates, nextState, queue);
            }
        }
        if (finalPath != null) {
            System.out.println("J1  J2");
            System.out.println(finalPath);
            flag =1 ;
            Log.i("Liters",finalPath.toString());
        }
        else{
            System.out.println("Not Possible");
             flag= 0 ;

        }
    }

    /*
     * Checks whether State toCheck has been generated before, if not it is
     * added to queue and uniqueStates Set
     */
    void checkUniqueStates(HashSet<State> uniqueStates, State toCheck,
                           LinkedList<State> queue) {
        if (!uniqueStates.contains(toCheck)) {
            uniqueStates.add(toCheck);
            queue.add(toCheck);
        }
    }

   // public static void main(String[] args) {
    //    new WaterJugBFS().letsRoll();
    //}
}
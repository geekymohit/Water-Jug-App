package com.example.mohit.waterjug;

import java.util.*;
public class WaterJug {

    int a_max = 4;
    int b_max = 3;
    int a = 0;
    int b = 0;
    int goal = 2;
    int c[][] = new int[20][2];



    void checkGoal() {

        int fin = 0;

        while(fin != 1) {

            if((this.a == this.goal) || (this.b == this.goal)) { fin = 1; }

            if(this.a==0) {
                fillA();

            } else if ((this.a > 0) && (this.b != this.b_max)) {
                transferAtoB();

            } else if ((this.a > 0) && (this.b == this.b_max)) {
                emptyB();

            }





        }
    }


    void fillA() {

        this.a = this.a_max;
        //System.out.println("{" + this.a + "," + this.b + "}");

    }

    void fillB() {
        this.b = this.b_max;
        //System.out.println("{" + this.a + "," + this.b + "}");
    }

    void transferAtoB() {

        int fin = 0;

        while(fin != 1) {

            this.b += 1;
            this.a -= 1;

            if((this.b == this.b_max) || (this.a == 0)) { fin = 1;}

        }

        //System.out.println("{" + this.a + "," + this.b + "}");

    }

    void emptyA() {

        this.a=0;
        //System.out.println("{" + this.a + "," + this.b + "}");

    }

    void emptyB() {
        this.b=0;
        //System.out.println("{" + this.a + "," + this.b + "}");
    }



    public static void main(String args[]) {

        WaterJug w = new WaterJug();
        w.checkGoal();
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.generala;

/**
 *
 * @author Marcelo
 */
public class Generala {

    
    protected int[] dice;

    public Generala(int... dice) {
        this.dice = dice;
    }

    public static int chance(int... dice) {
        int total = 0;

        for (int i = 0; i < dice.length; i++) {
            total += dice[i];
        }
        return total;
    }

    // '(int... dice)' es similar a tener public static int generala(int d1, int d2, int d3 , etc) pero permite realizar operaciones como -> for (int die : dice)
    //es una forma de decir que el metodo puede aceptar 1 o más parametros de tipo int ... lista de parametros dinamicos.
    public static int generala(int... dice) {
        int[] counts = new int[6];
        for (int die : dice) {
            counts[die - 1]++;
        }
        for (int i = 0; i != 6; i++) {
            if (counts[i] == 5) {
                return 50;
            }
        }
        return 0;
    }

    public static int ones(int... dice) {
        int sum = 0;
        for (int i = 0; i < dice.length; i++) {
            if (dice[i] == 1) {
                sum++;
            }
        }

        return sum;
    }

    public static int twos(int... dice) {
        int sum = 0;
        for (int i = 0; i < dice.length; i++) {
            if (dice[i] == 2) {
                sum += 2;
            }
        }
        return sum;
    }

    public static int threes(int... dice) {
        int sum = 0;

        for (int i = 0; i < dice.length; i++) {
            if (dice[i] == 3) {
                sum += 3;
            }
        }
        return sum;
    }

    public int fours() {
        int sum = 0;

        for (int i = 0; i < dice.length; i++) {
            if (dice[i] == 4) {
                sum += 4;
            }
        }
        return sum;
    }

    public int fives() {
        int sum = 0;

        for (int i = 0; i < dice.length; i++) {
            if (dice[i] == 5) {
                sum += 5;
            }
        }
        return sum;
    }

    public int sixes() {
        int sum = 0;

        for (int i = 0; i < dice.length; i++) {
            if (dice[i] == 6) {
                sum += 6;
            }
        }
        return sum;
    }

    public static int score_pair(int... dice) {
        int[] counts = new int[6];
        for (int i = 0; i < dice.length; i++) {
            counts[dice[i] - 1]++;
        }
        for (int i = 0; i != 6; i++) {
            if (counts[6 - i - 1] >= 2) {
                return (6 - i) * 2;
            }
        }
        return 0;
    }

    public static int two_pair(int... dice) {
        int[] counts = new int[6];
        for (int i = 0; i < dice.length; i++) {
            counts[dice[i] - 1]++;
        }
        int acum = 0;
        int score = 0;
        for (int i = 0; i < 6; i += 1) {
            if (counts[6 - i - 1] >= 2) {
                acum++;
                score += (6 - i);
            }
        }
        if (acum == 2) {
            return score * 2;
        } else {
            return 0;
        }
    }

    public static int four_of_a_kind(int... dice) {
        int[] tallies = new int[6];;

        for (int i = 0; i < dice.length; i++) {
            tallies[dice[i] - 1]++;
        }
        for (int i = 0; i < 6; i++) {
            if (tallies[i] >= 4) {
                return (i + 1) * 4;
            }
        }
        return 0;
    }

    public static int three_of_a_kind(int... dice) {
        int[] tallies = new int[6];

        for (int i = 0; i < dice.length; i++) {
            tallies[dice[i] - 1]++;
        }
        for (int i = 0; i < 6; i++) {
            if (tallies[i] >= 3) {
                return (i + 1) * 3;
            }
        }
        return 0;
    }

    public static int smallStraight(int... dice) {
        int[] tallies = new int[6];
        int acum = 0;
        for (int i = 0; i < dice.length; i++) {
            tallies[dice[i] - 1]++;

        }
        for (int i = 0; i < 5; i++) {
            if (tallies[i] == 1) {
                acum++;
            }

        }

        if (acum == 5) {
            return 15;
        } else {
            return 0;
        }
    }

    public static int largeStraight(int... dice) {
        int[] tallies = new int[6];
        int acum = 0;
        for (int i = 0; i < dice.length; i++) {
            tallies[dice[i] - 1]--;

        }
        for (int i = 0; i < 6; i++) {
            if (tallies[i] == (-1)) {
                acum++;

            }

        }

        if (acum == 5) {
            return 20;
        } else {
            return 0;
        }

    }

    public static int fullHouse(int... dice) {

        boolean isTwo = false;
        boolean isThree = false;
        int valueTwo = 0;
        int valueThree = 0;

        int[] tallies = new int[6];
        for (int i = 0; i < dice.length; i++) {
            tallies[dice[i] - 1]++;
        }

        for (int i = 0; i < tallies.length; i++) {
            if (tallies[i] == 2) {
                isTwo = true;
                valueTwo = i + 1;
            }
            if (tallies[i] == 3) {
                isThree = true;
                valueThree = i + 1;
            }
        }

        if (isTwo && isThree) {
            return valueTwo * 2 + valueThree * 3;
        } else {
            return 0;
        }
    }
}

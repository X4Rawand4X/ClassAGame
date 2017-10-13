package com.example.TicTaeTo;

import android.widget.Button;


public class GameEngine {
    boolean test;
    boolean test2;
    Button[][] buttons;
    String[][] theTests;
    String[] rowTest;
    String[] coloumnTest;
    String diagonalTest;
    String revdiagonalTest;

    public GameEngine(Button[][] buttons) {
        this.buttons = buttons;
        this.gettingTests();
    }

    public void setButtons(Button[][] buttons) {
        this.buttons = buttons;
        this.gettingTests();
    }

    public int[] computerMove(String TestCondition) {
        //this Test
        int[] moveIndex = new int[2]; /// this returns the index for the third O, which the coloumm and the row index
        moveIndex[0] = -1;
        for (int i = 0; i < 3; i++) {

            if (rowTest[i].replace(" ", "").contains(TestCondition)) {
                moveIndex[0] = i;
                moveIndex[1] = rowTest[i].indexOf(" ");
            } else if (coloumnTest[i].replace(" ", "").contains(TestCondition)) {
                moveIndex[1] = i;
                moveIndex[0] = coloumnTest[i].indexOf(" ");
            }

        }
        if (diagonalTest.replace(" ", "").contains(TestCondition)) {

            moveIndex[0] = diagonalTest.indexOf(" ");
            moveIndex[1] = diagonalTest.indexOf(" ");

        } else if (revdiagonalTest.replace(" ", "").contains(TestCondition)) {


            int revInd = revdiagonalTest.indexOf(" ");
            moveIndex[1] = revInd;
            if (revInd == 0)
                moveIndex[0] = 2;
            else if (revInd == 1)
                moveIndex[0] = 1;
            else if (revInd == 2)
                moveIndex[0] = 0;

        }
        return moveIndex;
    }

    public void gettingTests() {
        rowTest = new String[3];

        coloumnTest = new String[3];

        diagonalTest = new String();
        revdiagonalTest = new String();
        for (int i = 0, c = buttons.length - 1; i < buttons.length; i++, c--)  //c is only used in reverse diagonal
        {
            rowTest[i] = new String();
            coloumnTest[i] = new String();
            for (int j = 0; j < 3; j++) {
                rowTest[i] += (buttons[i][j].getText().toString().equals("") ? " " : buttons[i][j].getText().toString()); // Iterating cell by cell from left to right
                coloumnTest[i] += (buttons[j][i].getText().toString().equals("") ? " " : buttons[j][i].getText().toString());
                ; // Iterating cell by cell from up to down
            }
            diagonalTest += (buttons[i][i].getText().toString().equals("") ? " " : buttons[i][i].getText().toString()); // Iterating Diagonal
            revdiagonalTest += (buttons[c][i].getText().toString().equals("") ? " " : buttons[c][i].getText().toString()); // iterating reverse Diagonal

        }


    }

    public Button[][] clear() {


        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                buttons[i][j].setText("");
                buttons[i][j].setClickable(true);
            }
        }
        return buttons;
    }

    public boolean isWin() {
        // here we assign the four kind of tests to a 8-sized String array
        String[] eightTests = new String[8];
        int counter = 0;
        for (int i = 0; i < rowTest.length; i++) {
            eightTests[counter] = rowTest[i];  // the rows test
            eightTests[counter + 1] = coloumnTest[i]; /// the coulmn test
            counter += 2;
        }
        eightTests[6] = diagonalTest;  /// the diagonal test
        eightTests[7] = revdiagonalTest; //  the reverse diagonal test

        for (int i = 0; i < eightTests.length; i++) {
            if (eightTests[i].contains("XXX") || eightTests[i].contains("OOO")) {
                return true;
            }
        }
        return false;
    }


    public boolean isDraw() {
        test = true;

        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {

                if (buttons[i][j].getText().toString().equals("")) {
                    test = false;
                }

            }
        }

        return test;


    }

}
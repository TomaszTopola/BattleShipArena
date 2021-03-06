package me.tomasztopola.tests;

import me.tomasztopola.api.Test;
import me.tomasztopola.utils.BoardGenerator;

/**
 * Simple automated test for board generator
 */
public class BoardTest implements Test {

    final private BoardGenerator boardGenerator;

    public BoardTest(BoardGenerator boardGenerator){
        this.boardGenerator = boardGenerator;
    }

    public void run(){
        for(int i=0; i<100; i++){
            boardGenerator.generate();
            boardGenerator.print();
        }
    }
}

package me.tomasztopola;

import me.tomasztopola.clients.tomasztopola.NewHope;
import me.tomasztopola.competition.Contest;
import me.tomasztopola.competition.OneVsOne;
import me.tomasztopola.utils.BoardGenerator;

public class Main {

    public static void main(String[] args) {
//        competition();
        oneVsOne();
    }

    private static void competition(){
        Contest contest = new Contest();
        contest.addCompetitor( new NewHope(17));
    }

    private static void oneVsOne(){
        OneVsOne competition;
        competition = new OneVsOne(new NewHope(17), new NewHope(17));
        competition.runBattle();
    }

    private static void testBoardGenerator(){
        BoardGenerator board = new BoardGenerator();
        for(int i=0; i<100; i++){
            System.out.println("Generated board No. " + i);
            board.generate();
            board.print();
        }
    }
}

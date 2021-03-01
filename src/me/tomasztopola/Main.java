package me.tomasztopola;

import me.tomasztopola.clients.tomasztopola.NewHope;
import me.tomasztopola.competition.Contest;
import me.tomasztopola.competition.OneVsOne;

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
}

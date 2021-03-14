package me.tomasztopola;

import me.tomasztopola.clients.JustRandomClient;
import me.tomasztopola.clients.NotSoSimpleClient;
import me.tomasztopola.competition.Competition;
import me.tomasztopola.competition.OneVsOne;

public class Battle {

    public static void main(String[] args) {
//        competition();
        oneVsOne();
    }

    private static void competition(){
        Competition competition = new Competition();

        competition.addCompetitor(new JustRandomClient());
        competition.addCompetitor(new JustRandomClient());

        competition.run();
    }

    private static void oneVsOne(){
        OneVsOne competition;
        competition = new OneVsOne();

        competition.addCompetitor(new JustRandomClient());
        competition.addCompetitor(new NotSoSimpleClient());

        competition.run();
    }


}

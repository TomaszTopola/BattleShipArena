package me.tomasztopola.competition;

import me.tomasztopola.Battle;
import me.tomasztopola.api.BattleShipClient;
import me.tomasztopola.api.Contest;
import me.tomasztopola.rules.Rules;

import java.util.List;
import java.util.Map;

public class Competition implements Contest {
    private Map<BattleShipClient, Integer> scores;


    public void addCompetitor(BattleShipClient client){
        Rules.assertClientRules(client);
    }

    public void run(){

    }

    private void assignScores(BattleShipClient winner){
        scores.merge(winner, 1, Integer::sum);
    }

    public void printScores(){

    }

    @Override
    public BattleShipClient getWinner() {
        return null;//TODO auto-generated method.
    }
}
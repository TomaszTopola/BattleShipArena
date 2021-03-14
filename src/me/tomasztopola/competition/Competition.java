package me.tomasztopola.competition;

import me.tomasztopola.api.BattleShipClient;
import me.tomasztopola.rules.Rules;

import java.util.List;
import java.util.Map;

public class Competition {

    private List<BattleShipClient> competitors;
    private Map<String, Integer> scores;

    public void addCompetitor(BattleShipClient client){
        Rules.assertClientRules(client);
        competitors.add(client);
    }
/*
    public void runCompetition(){
        for(int i=0; i<competitors.size(); i++){
            OneVsOne battle;
            for(int j=0; j<competitors.size()-1; j++){
                 battle = new OneVsOne(competitors.get(i), competitors.get(i+1));
                 battle.run();
                 BattleShipClient winner = battle.getWinner();
            }
        }
    }
*/
    public void run() {
    }
}
package me.tomasztopola.competition;

import me.tomasztopola.api.BattleShipClient;
import me.tomasztopola.rules.Rules;

import java.util.List;

public class Contest {

    private List<BattleShipClient> competitors;

    public void addCompetitor(BattleShipClient client){
        Rules.assertClientRules(client);
        competitors.add(client);
    }

    public void runCompetition(){

    }
}

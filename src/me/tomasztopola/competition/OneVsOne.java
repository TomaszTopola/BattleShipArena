package me.tomasztopola.competition;

import me.tomasztopola.api.BattleShipClient;
import me.tomasztopola.rules.Rules;

public class OneVsOne{

    BattleShipClient client1;
    BattleShipClient client2;

    public OneVsOne(BattleShipClient client1, BattleShipClient client2){
        this.client1 = client1;
        this.client2 = client2;
    }

    public void runBattle(){
        // Init logs
        System.out.println("Starting One vs One battle");
        System.out.println(client1.getBotName() + "     vs      " + client2.getBotName() + "\n");

        //check if clients follow given rules;
        Rules.assertClientRules(client1);
        Rules.assertClientRules(client2);

        // run battle
        int countRounds = 0;

        while (true) { //this sets while as infinite (unless condition was met)
            client1.receiveAttack(client2.attack());
            client2.receiveAttack(client2.attack());

            System.out.println(client1.getBotName() + ": " + client1.getFloatingShips());
            System.out.println(client2.getBotName() + ": " + client2.getFloatingShips());

            if(client1.getFloatingShips() == 0 || client2.getFloatingShips() == 0) break;
            countRounds += 1;
        }

        // get floating ships
        int floatingShips1 = client1.getFloatingShips();
        int floatingShips2 = client2.getFloatingShips();

        // print win message
        if(floatingShips1== 0 && floatingShips2 > 0)
            System.out.println(client2.getBotName() + " wins in " +  countRounds + " rounds!");
        else if( floatingShips2 == 0 && floatingShips1 > 0)
            System.out.println(client1.getBotName() + " wins in " +  countRounds + " rounds!");
        else if( floatingShips1 == 0 && floatingShips2 == 0)
            System.out.println("It's a draw! They somehow killed each other at the same time.");
        else
            System.out.println("Something went wrong. Battle stopped before bots lost all their ships.");
    }
}

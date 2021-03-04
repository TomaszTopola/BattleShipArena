package me.tomasztopola.clients;

import me.tomasztopola.api.ClientData;
import me.tomasztopola.api.SimpleClient;
import me.tomasztopola.rules.Rules;
import me.tomasztopola.utils.Location;

import java.util.Random;

public class NotSoSimpleClient extends SimpleClient {

    private final Random r = new Random();

    @Override
    public Location attack(ClientData opponent) {
        return new Location(r.nextInt(Rules.getBoardSize()), r.nextInt(Rules.getBoardSize()));
    }
}

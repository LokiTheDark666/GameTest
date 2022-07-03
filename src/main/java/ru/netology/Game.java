package ru.netology;

import java.util.ArrayList;
import java.util.Collection;

public class Game {

    private Collection<Player> players;

    public Game() {
        this.players = new ArrayList<>();
    }

    public Collection<Player> findAll() {
        return players;
    }

    public void add(Player player) {
        players.add(player);
    }

    public void register(Player player) {
        player.isRegistered = true;
    }

    public Player findByName(String name) {
        for (Player player : players) {
            if (player.getName() == name) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);
        if (!player1.isRegistered) {
            throw new NotRegisteredException("Player: " + playerName1 + " is not registered!");
        }
        if (!player2.isRegistered) {
            throw new NotRegisteredException("Player: " + playerName2 + " is not registered!");
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }
        if (player1.getStrength() < player2.getStrength()) {
            return 2;
        }
        return 0;
    }


}
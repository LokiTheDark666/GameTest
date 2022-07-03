package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GameTest {


    Game game = new Game();

    Player player1 = new Player(1, "Vasya", 1);
    Player player2 = new Player(2, "Petya", 10);
    Player player3 = new Player(3, "Dima", 10);
    Player player4 = new Player(4, "Sasha", 15);


    @Test

    public void shouldAddPlayers() {
        game.add(player1);
        game.add(player2);
        Collection<Player> actual = game.findAll();
        Collection<Player> expected = List.of(player1, player2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindPlayer() {
        game.add(player1);
        game.add(player2);
        Player actual = game.findByName("Petya");
        Player expected = player2;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindNoPlayersCollection() {
        Collection<Player> actual = game.findAll();
        Collection<Player> expected = List.of();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWinFirstPlayer() {
        game.add(player2);
        game.add(player1);
        game.register(player2);
        game.register(player1);
        int actual = game.round("Petya", "Vasya");
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWinSecondPlayer() {
        game.add(player3);
        game.add(player4);
        game.register(player3);
        game.register(player4);
        int actual = game.round("Dima", "Sasha");
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldBeDraw() {
        game.add(player3);
        game.add(player2);
        game.register(player3);
        game.register(player2);
        int actual = game.round("Dima", "Petya");
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void shouldFindNoPlayer() {
        Player actual = game.findByName("Sofia");
        Player expected = null;
        Assertions.assertEquals(expected, actual);
    }

}

package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void player1Win() {
        Player Ivan = new Player(1, "Иван", 200);
        Player Petr = new Player(2, "Петр", 100);
        Game game = new Game();
        game.register(Ivan);
        game.register(Petr);
        int actual = game.round("Иван", "Петр");
        int expected = 1;

        Assertions.assertEquals(actual, expected);

    }

    @Test
    public void player2Win() {
        Player Ivan = new Player(1, "Иван", 200);
        Player Petr = new Player(2, "Петр", 300);
        Game game = new Game();
        game.register(Ivan);
        game.register(Petr);
        int actual = game.round("Иван", "Петр");
        int expected = 2;

        Assertions.assertEquals(actual, expected);

    }

    @Test
    public void playerNoWin() {
        Player Ivan = new Player(1, "Иван", 200);
        Player Petr = new Player(2, "Петр", 200);
        Game game = new Game();
        game.register(Ivan);
        game.register(Petr);
        int actual = game.round("Иван", "Петр");
        int expected = 0;

        Assertions.assertEquals(actual, expected);

    }

    @Test
    public void playerNoExist() {
        Player Ivan = new Player(1, "Иван", 200);
        Player Petr = new Player(2, "Петр", 200);
        Game game = new Game();
        game.register(Ivan);
        game.register(Petr);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Кот", "Петр")
        );
    }
}
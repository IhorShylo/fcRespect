package com.shylo.fcrespect.backend.data;

import com.shylo.fcrespect.backend.model.Player;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Component
public class PlayersRepository {
    private static final List<Player> players = Arrays.asList(
            new Player("Бабич Александр", LocalDate.of(1991, 2, 5), "Midfielder", "Babich.jpg"),
            new Player("Брусиловский Дмитрий", LocalDate.of(1991, 5, 3), "Midfielder", "Brusilovskiy.jpg"),
            new Player("Двирный Александр", LocalDate.of(1985, 1, 1), "Defender", "Dvirnuy.jpg"),
            new Player("Д.Денис", LocalDate.of(1988, 3, 5), "Goalkeaper", "Den.jpg"),
            new Player("Федя", LocalDate.of(1993, 8, 18), "Midfielder", "Fedya.jpg"),
            new Player("Козырь Антон", LocalDate.of(1989, 6, 6), "Midfielder", "Kozyr.jpg"),
            new Player("Лозница Богдан", LocalDate.of(1988, 10, 12), "Defender", "Loznytsa.jpg"),
            new Player("Лысый Андрей", LocalDate.of(1988, 6, 7), "Midfielder", "Lysyi.jpg"),
            new Player("Рускевич Максим", LocalDate.of(1985, 11, 26), "Forward", "Maks.jpg"),
            new Player("Осадчий Сергей", LocalDate.of(1991, 7, 14), "Defender", "Osadchyi.jpg"),
            new Player("Лубяный Павел", LocalDate.of(1990, 1, 20), "Midfielder", "Pasha.jpg"),
            new Player("Шило Игорь", LocalDate.of(1989, 12, 2), "Defender", "Shylo.jpg"),
            new Player("Сороченко Дмитрий", LocalDate.of(1988, 5, 11), "Midfielder", "Sorochenko.jpg"),
            new Player("Кужелев Анатолий", LocalDate.of(1993, 4, 4), "Forward", "Tolik.jpg")
    );

    public Player getPlayerByImgName(String imgName) {
        for (Player player : players) {
            if (player.getImageName().equals(imgName)) return player;
        }
        return null;
    }

    public List<Player> getAllPlayers() {
        return players;
    }
}

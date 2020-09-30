package ca.carleton.comp;

import ca.carleton.comp.game.PiratenKapern;
import ca.carleton.comp.game.Player;
import ca.carleton.comp.game.TestPlayer;
import ca.carleton.comp.network.ClientChannel;

public class GameClient {

    public GameClient(String playerName) {
        ClientChannel clientChannel = new ClientChannel();
        PiratenKapern piratenKapern = new PiratenKapern();

        TestPlayer testPlayer = new TestPlayer(piratenKapern, clientChannel);
        testPlayer.initPlayer(playerName);
        testPlayer.play();
    }

    public GameClient() {
        ClientChannel clientChannel = new ClientChannel();
        PiratenKapern piratenKapern = new PiratenKapern();
        Player player = new Player(piratenKapern, clientChannel);
        player.initPlayer();
        player.play();
    }


    public static void main(String[] args) {
        if (args.length > 0) {
            new GameClient(args[0]);
        } else {
            new GameClient();
        }

    }

}

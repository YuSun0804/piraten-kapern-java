package ca.carleton.comp;

import ca.carleton.comp.game.PiratenKapern;
import ca.carleton.comp.game.Player;
import ca.carleton.comp.network.ClientChannel;

public class GameClient {

    public GameClient() {
        ClientChannel clientChannel = new ClientChannel();
        PiratenKapern piratenKapern = new PiratenKapern();
        new Player(piratenKapern, clientChannel).play();
    }



    public static void main(String[] args) {
        new GameClient();
    }

}

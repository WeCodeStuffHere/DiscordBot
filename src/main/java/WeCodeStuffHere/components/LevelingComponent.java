package WeCodeStuffHere.components;

import WeCodeStuffHere.database.models.Player;
import WeCodeStuffHere.database.repositories.PlayerRepository;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import javax.inject.Inject;


public class LevelingComponent extends Component  {
    private final PlayerRepository playerRepository;
    @Inject
    public LevelingComponent(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public void onReady(ReadyEvent event) {
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (playerRepository.ifExists(event.getAuthor().getId()))  {
            System.out.println(":)");
           playerRepository.setExperience (event.getAuthor().getId(), playerRepository.getExperience(event.getAuthor().getId()) + 25);

        }
        else {
            playerRepository.createPlayer(event.getAuthor().getId(), 0, 0);
        }
    }
}

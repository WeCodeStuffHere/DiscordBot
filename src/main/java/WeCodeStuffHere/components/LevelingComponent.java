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
        System.out.println("Leveling Component is ready");
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (playerRepository.ifExists(event.getAuthor().getId()))  {
            System.out.println(":)");
           playerRepository.setExperience (event.getAuthor().getId(), playerRepository.getExperience(event.getAuthor().getId()) + 25);
           playerRepository.setLevel(event.getAuthor().getId(),  getExperienceForLevel((int) playerRepository.getLevel(event.getAuthor().getId())));
        }
        else {
            playerRepository.createPlayer(event.getAuthor().getId(), 0, 0);
        }
    }


    public static int getExperienceForLevel(int level) {
        int SCALE = 500;
        return (int) Math.sqrt(SCALE * level);
    }
}


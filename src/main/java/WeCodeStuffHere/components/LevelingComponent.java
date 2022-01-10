package WeCodeStuffHere.components;

import WeCodeStuffHere.database.models.Player;
import WeCodeStuffHere.database.repositories.PlayerRepository;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import javax.inject.Inject;

import static WeCodeStuffHere.modules.fixingJavaSyntax.*;


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
           playerRepository.setExperience (event.getAuthor().getId(), playerRepository.getExperience(event.getAuthor().getId()) + 1);
            if(getExperienceForLevel(Math.round(playerRepository.getLevel(event.getAuthor().getId()))) <= playerRepository.getExperience(event.getAuthor().getId())) {
                playerRepository.setLevel(playerRepository.getLevel(event.getAuthor().getId()) + 1, event.getAuthor().getId());
            }
        }
        else {
            playerRepository.createPlayer(event.getAuthor().getId(), 0, 0);
            print("Creating a new player :D");
        }
    }


    public static int getExperienceForLevel(int level) {
        int SCALE = 500;
        print(String.valueOf(Math.sqrt(SCALE * level)));
        return (int) Math.sqrt(SCALE * level);
    }
}


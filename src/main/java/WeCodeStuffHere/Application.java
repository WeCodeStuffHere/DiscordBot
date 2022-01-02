package WeCodeStuffHere;

import WeCodeStuffHere.components.Component;
import WeCodeStuffHere.components.ComponentFactory;
import WeCodeStuffHere.components.DaddyComponent;
import WeCodeStuffHere.components.FormattingTutorialComponent;
import WeCodeStuffHere.database.models.Player;
import WeCodeStuffHere.database.repositories.PlayerRepository;
import WeCodeStuffHere.modules.annotations.JDABotBuilder;
import WeCodeStuffHere.modules.annotations.Token;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.inject.Inject;
import javax.security.auth.login.LoginException;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private final JDABuilder jdaBuilder;
    private PlayerRepository playerRepository;
    private final ComponentFactory componentFactory;
    private final List<Class<? extends Component>> components = new ArrayList<>() {
        {
            add(DaddyComponent.class);
            add(FormattingTutorialComponent.class);
        }
    };

    @Inject
    public Application(
            @JDABotBuilder JDABuilder jdaBuilder,
            ComponentFactory componentFactory,
            PlayerRepository playerRepository
    ) {
        this.jdaBuilder = jdaBuilder;
        this.componentFactory = componentFactory;
        this.playerRepository = playerRepository;
    }

    public void run() throws LoginException {
        createMockData();
        JDA jda = jdaBuilder.build();

        // Initialize and start all components.
        for (Class<? extends Component> component : components) {
            jda.addEventListener(componentFactory.create(component));
        }
    }

    public void createMockData() {
        playerRepository.createPlayer("Player1", 0);
        playerRepository.createPlayer("Player2", 1);
        playerRepository.createPlayer("Player3", 2);
        playerRepository.createPlayer("Player4", 3);
        playerRepository.createPlayer("Player5", 4);

        List<Player> players = playerRepository.getAllPlayers();
        for (Player player : players) {
            System.out.print(player.getName() + " ");
            System.out.print(player.getExperience() + " \n");
        }

        Player player = playerRepository.getPlayer("Player4");
        System.out.println(player.getName() + " has " + player.getExperience() + " experience");
    }
}

package WeCodeStuffHere;

import WeCodeStuffHere.components.*;
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
    private final PlayerRepository playerRepository;
    private final ComponentFactory componentFactory;
    private final List<Class<? extends Component>> components = new ArrayList<>() {
        {
            add(DaddyComponent.class);
            add(FormattingTutorialComponent.class);
            add(LevelingComponent.class);
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

        JDA jda = jdaBuilder.build();

        // Initialize and start all components.
        for (Class<? extends Component> component : components) {
            jda.addEventListener(componentFactory.create(component));
        }
    }


}

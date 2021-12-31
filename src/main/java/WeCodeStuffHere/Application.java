package WeCodeStuffHere;

import WeCodeStuffHere.components.Component;
import WeCodeStuffHere.components.ComponentFactory;
import WeCodeStuffHere.components.DadComponent;
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
    private final String token;
    private final ComponentFactory componentFactory;
    private final List<Class<? extends Component>> components = new ArrayList<>() {
        {
            add(DadComponent.class);
        }
    };

    @Inject
    public Application(
            @JDABotBuilder JDABuilder jdaBuilder,
            @Token String token,
            ComponentFactory componentFactory
    ) {
        this.jdaBuilder = jdaBuilder;
        this.token = token;
        this.componentFactory = componentFactory;
    }

    public void run() throws LoginException {
        JDA jda = jdaBuilder.build();

        // Initialize and start all components.
        for (Class<? extends Component> component : components) {
            new Thread(componentFactory.create(component)).start();
        }
    }
}

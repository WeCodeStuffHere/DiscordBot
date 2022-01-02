package WeCodeStuffHere.components;

import WeCodeStuffHere.database.repositories.PlayerRepository;
import com.google.inject.Provider;

import javax.inject.Inject;

public class ComponentFactory {
    private final Provider<PlayerRepository> playerRepositoryProvider;

    @Inject
    public ComponentFactory(Provider<PlayerRepository> playerRepositoryProvider) {
        this.playerRepositoryProvider = playerRepositoryProvider;
    }

    public Component create(Class<? extends Component> component) {
        if (component == DaddyComponent.class) {
            return new DaddyComponent(
                    playerRepositoryProvider.get()
            );
        }
        if (component == FormattingTutorialComponent.class) {
            return new FormattingTutorialComponent(
                    playerRepositoryProvider.get()
            );
        }

        throw new UnsupportedOperationException("Factory has not defined how the given class has to be created");
    }
}

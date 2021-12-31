package WeCodeStuffHere.components;

import WeCodeStuffHere.modules.annotations.JDABotBuilder;
import net.dv8tion.jda.api.JDABuilder;

import javax.inject.Inject;

public class ComponentFactory {
    private final JDABuilder jdaBuilder;

    @Inject
    public ComponentFactory(@JDABotBuilder JDABuilder jdaBuilder) {
        this.jdaBuilder = jdaBuilder;
    }

    public Component create(Class<? extends Component> component) {
        if (component == DadComponent.class) {
            return new DadComponent(jdaBuilder);
        }

        throw new UnsupportedOperationException("Factory has not defined how the given class has to be created");
    }
}

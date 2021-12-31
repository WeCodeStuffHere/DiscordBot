package WeCodeStuffHere.components;

public class ComponentFactory {

    public Component create(Class<? extends Component> component) {
        if (component == DadComponent.class) {
            return new DadComponent();
        }

        throw new UnsupportedOperationException("Factory has not defined how the given class has to be created");
    }
}

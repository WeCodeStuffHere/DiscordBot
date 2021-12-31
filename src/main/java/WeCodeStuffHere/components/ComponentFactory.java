package WeCodeStuffHere.components;

public class ComponentFactory {

    public Component create(Class<? extends Component> component) {
        if (component == DaddyComponent.class) {
            return new DaddyComponent();
        }

        throw new UnsupportedOperationException("Factory has not defined how the given class has to be created");
    }
}

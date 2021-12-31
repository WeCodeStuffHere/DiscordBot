package WeCodeStuffHere.components;

import WeCodeStuffHere.modules.annotations.JDABotBuilder;
import net.dv8tion.jda.api.JDABuilder;

import javax.inject.Inject;

public class DadComponent implements Component {

    @Inject
    public DadComponent(@JDABotBuilder JDABuilder jdaBuilder) {

    }

    public void run() {
        System.out.println("Hi depressed, I am dad");
    }
}

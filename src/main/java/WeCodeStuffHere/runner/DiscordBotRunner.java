package WeCodeStuffHere.runner;

import WeCodeStuffHere.Application;
import com.google.inject.Guice;

public class DiscordBotRunner {
    public static void main(String[] args) {
        Guice.createInjector().getInstance(Application.class).run();
    }
}

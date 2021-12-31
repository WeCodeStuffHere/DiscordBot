package WeCodeStuffHere.runner;

import WeCodeStuffHere.Application;
import WeCodeStuffHere.modules.ConfigModule;
import com.google.inject.Guice;

import javax.security.auth.login.LoginException;

public class DiscordBotRunner {
    public static void main(String[] args) throws LoginException {
        Guice.createInjector(
                new ConfigModule()
        ).getInstance(Application.class).run();
    }
}

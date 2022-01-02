package WeCodeStuffHere.components;

import WeCodeStuffHere.database.repositories.PlayerRepository;
import com.google.inject.Inject;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DaddyComponent extends Component {
    private final PlayerRepository playerRepository;
    private final List<String> triggers = new ArrayList<>() {
        {
            add("i am");
            add("im");
            add("i'm");
            add("my name is");
            add("i call myself");
        }
    };

    @Inject
    public DaddyComponent(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public void onReady(ReadyEvent event)
    {
        if (event != null)
            System.out.println("Hi depressed, I'm dad!");
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
        if (event.getAuthor().isBot()) {
            return;
        }
        String message = event.getMessage().getContentDisplay().toLowerCase();
        Optional<String> potentialTrigger = triggers.stream().filter(message::contains).findFirst();

        if (potentialTrigger.isPresent()) {
            String trigger = potentialTrigger.get();

            if (message.length() != trigger.length()) {
                String dadJoke = message.substring(message.indexOf(trigger) + trigger.length() + 1);
                MessageChannel channel = event.getChannel();
                channel.sendMessage("Hi " + dadJoke + ", I'm Dad!").queue();
            }
        }
    }
}

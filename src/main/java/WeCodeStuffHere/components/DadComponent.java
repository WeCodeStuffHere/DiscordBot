package WeCodeStuffHere.components;

import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DadComponent extends Component {
    private final List<String> triggers = new ArrayList<>() {
        {
            add("i am");
            add("i'm");
            add("my name is");
        }
    };

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
        List<String> triggersInMessage = triggers.stream()
                .filter(message::contains)
                .collect(Collectors.toList());

        if (triggersInMessage.size() > 0) {
            String trigger = triggersInMessage.get(0);
            String dadJoke = message.substring(message.lastIndexOf(trigger) + trigger.length() + 1);
            MessageChannel channel = event.getChannel();
            channel.sendMessage("Hi " + dadJoke + ", I'm Dad!").queue();
        }
    }
}

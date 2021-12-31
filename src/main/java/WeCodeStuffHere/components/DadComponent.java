package WeCodeStuffHere.components;

import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class DadComponent extends Component {

    @Override
    public void onReady(ReadyEvent event)
    {
        if (event != null)
            System.out.println("Hi depressed, I'm dad!");
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
        System.out.printf("[%s]: %s\n", event.getAuthor().getName(), event.getMessage().getContentDisplay());
    }
}

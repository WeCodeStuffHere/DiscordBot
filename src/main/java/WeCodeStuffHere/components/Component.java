package WeCodeStuffHere.components;

import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public abstract class Component extends ListenerAdapter {
    public abstract void onReady(ReadyEvent event);

    public abstract void onMessageReceived(MessageReceivedEvent event);
}

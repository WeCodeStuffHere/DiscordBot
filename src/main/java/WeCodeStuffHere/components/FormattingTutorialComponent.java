package WeCodeStuffHere.components;


import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.ReadyEvent;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;

public class FormattingTutorialComponent extends Component {



    @Override
    public void onReady(ReadyEvent event) {
        if (event != null)
            System.out.println("Hi queens:)");
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) {
            return;
        }
        if(event.getMessage().getContentRaw().startsWith("-formatting")) {
           MessageChannel channel = event.getChannel();
           EmbedBuilder eb = new EmbedBuilder();
            eb.setTitle("Discord Formatting Options.", null);
            eb.setColor(Color.pink);
            eb.addField("Code Blocks", "To add a codeblock you need 3 \"´\" symbols on the starting of your code and the ending of your code. \n Example: ```print(\"Hello World!\")``",  true);
            eb.setFooter("If u see any typos or missing stuff in this command please make a issue on the github ty <3            code not ready dont make a issue this  is for future");
            channel.sendMessageEmbeds(eb.build()).queue();
        }
    }
}


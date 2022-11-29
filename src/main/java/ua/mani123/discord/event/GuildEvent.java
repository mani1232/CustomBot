package ua.mani123.discord.event;

import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import org.jetbrains.annotations.NotNull;
import ua.mani123.CBot;
import ua.mani123.discord.action.filter.filterUtils;
import ua.mani123.discord.interaction.interactionUtils;
import ua.mani123.discord.interaction.interactions.CommandInteraction;

import java.util.ArrayList;

public class GuildEvent extends ListenerAdapter {

    @Override
    public void onGuildReady(@NotNull GuildReadyEvent event) {
        ArrayList<CommandData> commandData = new ArrayList<>();
        for (CommandInteraction command : interactionUtils.getCommands()) {
            if (command.isOnlyGuild() && filterUtils.filterCheck(command.getFilters(), event)) {
                commandData.add(command.getCommand());
            }
        }
        if (commandData.size() > 0) {
            event.getGuild().updateCommands().addCommands(commandData).queue();
            CBot.getLog().info(commandData.size() + " commands added to guild: " + event.getGuild().getName());
        }
    }
}

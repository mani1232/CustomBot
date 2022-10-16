package ua.mani123;

import ch.qos.logback.classic.Logger;
import ua.mani123.config.configUtils;
import ua.mani123.discord.action.actionUtils;
import ua.mani123.discord.interaction.interactionUtils;

public class CBot {

    private static Logger log;

    public static void main(String[] args) {
        log = Utils.initLogger();
        getLog().info("Starting CustomBot");
        configUtils.init();
        Utils.initPlaceholders();
        interactionUtils.initCmd(configUtils.getCommandInteraction().getList("interaction"));
        actionUtils.init(configUtils.getActions());
        Runtime.getRuntime().addShutdownHook(new Thread(configUtils::saveAll, "Shutdown-thread"));
        getLog().info("Done!");
    }

    public static Logger getLog() {
        return log;
    }
}
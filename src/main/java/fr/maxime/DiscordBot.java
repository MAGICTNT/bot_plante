package fr.maxime;

import fr.maxime.entity.Bot;
import fr.maxime.utils.MyLogger;
import fr.maxime.utils.ReaderConfig;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class DiscordBot extends ListenerAdapter {
    private static final MyLogger MY_LOGGER = new MyLogger("DiscordBot");
    private static final ReaderConfig CONFIG = new ReaderConfig("src/main/resources/config.json");

    public static void main(String[] args) {
        try {
            Bot bot = new Bot(CONFIG.returnValueByKey("TOKEN_KEY"));
            bot.botCommand(CONFIG.returnValueByKeyList("COMMAND_SLASH"), CONFIG.returnValueByKeyList("COMMAND_SLASH_OPTION"));
            MY_LOGGER.info("je suis en route 🤖");
        } catch (Exception e) {
            MY_LOGGER.warn(e.getMessage());
        }
    }
}
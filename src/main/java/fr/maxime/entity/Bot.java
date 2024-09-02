package fr.maxime.entity;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.requests.GatewayIntent;
//import org.example.DiscordBot;
//import org.example.botClass.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Bot {
    String key;
    JDA jda;

    public Bot(String key) {
        this.jda = JDABuilder.createDefault(key)
                .enableIntents(GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_MESSAGE_TYPING, GatewayIntent.DIRECT_MESSAGES, GatewayIntent.MESSAGE_CONTENT)
                .build();
        jda.addEventListener(
//                new DiscordBot(),
//                new SlashCommand(),
//                new SlashCommands(),
//                new FormInteratctions(),
//                new ButtonInteractions()
        );

    }


    public void botCommand(ArrayList<Map<String, String>> commandList, ArrayList<Map<String, String>> commandListOption) {
        Map<String, CommandData> commands = new HashMap<>();
        for (Map<String, String> map : commandList) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                for (Map<String, String> mapOption : commandListOption) {
                    for (Map.Entry<String, String> entryOption : mapOption.entrySet()) {
                        if (entry.getKey().equals(entryOption.getKey())) {
                            commands.put(entry.getKey(), Commands.slash(entry.getKey(), entry.getValue())
                                    .addOption(OptionType.STRING, "name","description"));
                        }
                    }
                }
                commands.put(entry.getKey(), Commands.slash(entry.getKey(), entry.getValue()));
            }
        }

        jda.updateCommands()
                .addCommands(commands.values())
                .queue();
    }


}

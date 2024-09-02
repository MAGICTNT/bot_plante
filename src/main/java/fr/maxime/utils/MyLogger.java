package fr.maxime.utils;

import fr.maxime.enums.Color;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyLogger {
    String nameLogger;

    public MyLogger(String nameLogger) {
        this.nameLogger = nameLogger;
    }

    private void headerLog(String tag) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String timer = dtf.format(LocalDateTime.now());
        StringBuilder sb = new StringBuilder();
        sb.append("+--" + timer.replaceAll(".", "-") + "--+--" + tag.toUpperCase().replaceAll(".", "-") + "--+\n");
        sb.append("|  " + timer + "  |  " + tag.toUpperCase() + "  |\n");
        sb.append("+--" + timer.replaceAll(".", "-") + "--+--" + tag.toUpperCase().replaceAll(".", "-") + "--+");
        System.out.println(sb.toString());
    }

    public void info(String message) {
        System.out.println(Color.BLEU_CLAIR);
        headerLog("info");
        System.out.println("<" + nameLogger + "> " + message);
        System.out.println(Color.REBOOTCOLOR);
    }
    public void warn(String message) {
        System.out.println(Color.ROUGE);
        headerLog("warn");
        System.out.println("<" + nameLogger + "> " + message);
        System.out.println(Color.REBOOTCOLOR);
    }

    public void control(String message) {
        System.out.println(Color.JAUNE + message+ Color.REBOOTCOLOR);
    }
}

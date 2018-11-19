package com.company;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class Bot extends TelegramLongPollingBot {
    private static final String BOT_NAME = "Rahivnytsia";
    private static final String BOT_TOKEN = "773119310:AAHqWWQlBiCOEeiI01DI5hfT1Dj0B2wER9Y";


    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();
            long chatId = update.getMessage().getChatId();
            String text = message.getText();

            SendMessage sendMessage = new SendMessage();
            sendMessage.setText(text);
            sendMessage.setChatId(chatId);
            if (text.equals("/start")) {
                sendMessage.setText("Hi, " + message.getFrom().getFirstName() + '\n' + "Write, what you want to calculate. Use the example: 1 + 1");

            } else {
                double result;
                String[] numb = text.split(" ");
                try {
                    double n1 = Double.parseDouble(numb[0]);
                    double n2 = Double.parseDouble(numb[2]);
                    switch (numb[1]) {
                        case "+":
                            result = n1 + n2;
                            String r = "" + result;
                            sendMessage.setText(r);
                            break;
                        case "-":
                            result = n1 - n2;
                            String r1 = "" + result;
                            sendMessage.setText(r1);
                            break;
                        case "*":
                            result = n1 * n2;
                            String r2 = "" + result;
                            sendMessage.setText(r2);
                            break;
                        case "/":
                            result = n1 / n2;
                            if (n2 == 0) {
                                sendMessage.setText("You can`t divide by 0");
                            } else {
                                String r3 = "" + result;
                                sendMessage.setText(r3);
                            }
                            break;
                        default:
                            sendMessage.setText("Please, check what you wrote, and try again");
                            break;
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    sendMessage.setText("Please, check what you wrote, and try again");
                }
            }
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }


    }

    @Override
    public String getBotUsername() {
        return BOT_NAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }


}

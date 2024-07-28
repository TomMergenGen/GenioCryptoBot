package kz.genio.geniocryptobot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage.SendMessageBuilder;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.api.objects.webapp.WebAppInfo;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.springframework.stereotype.Component;



import java.util.ArrayList;
import java.util.List;

public class GenioBot extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "geniocryptobot";
    }

    @Override
    public String getBotToken() {
        return "7406261214:AAFbvTvVLabSCvZEw1GO_aV2hQ3f4Ed7SYI";
    }


    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String userMessage = update.getMessage().getText();
            SendMessage response = new SendMessage();
            response.setChatId(String.valueOf(update.getMessage().getChatId()));

            if (userMessage.equalsIgnoreCase("/start")) {
                response.setText("Добро пожаловать! Нажмите 'Play' для запуска мини-приложения.");
                response.setReplyMarkup(getInlineKeyboard());
            } else {
                response.setText("Неизвестная команда.");
            }

            try {
                execute(response);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    private InlineKeyboardMarkup getInlineKeyboard() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        InlineKeyboardButton playButton = new InlineKeyboardButton();
        playButton.setText("Play");

        // Устанавливаем информацию о Web App, URL указывает на ваше веб-приложение
        playButton.setWebApp(new WebAppInfo("https://1165-176-64-11-4.ngrok-free.app"));

        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
        keyboardButtonsRow1.add(playButton);

        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(keyboardButtonsRow1);

        inlineKeyboardMarkup.setKeyboard(rowList);

        return inlineKeyboardMarkup;
    }
    }




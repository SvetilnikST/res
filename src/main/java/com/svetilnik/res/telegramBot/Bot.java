package com.svetilnik.res.telegramBot;

import com.svetilnik.res.entity.City;
import com.svetilnik.res.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class Bot extends TelegramLongPollingBot {

    @Autowired
    private CityService cityService;

    @PostConstruct
    public void registerBot() {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(this);
        } catch (TelegramApiException e) {

        }
    }

    @Override
    public void onUpdateReceived(Update update) {
        try {
            if (update.hasMessage() && update.getMessage().hasText()) {
                Message inMessage = update.getMessage();
                SendMessage outMessage = new SendMessage();
                outMessage.setChatId(inMessage.getChatId());

                String inMess = inMessage.getText().toUpperCase();
                List<City> list = cityService.findByName(inMess);

                String message = "";

                if (!list.isEmpty()) {

                    message = list.get(0).getMessage();
                } else {
                    message = "Извините, но про это город я ещё ничего не знаю. Но перейдя по этому адресу (https://testpst.herokuapp.com/) вы можете добавить" +
                            "информацию о нём.";
                }
                outMessage.setText(message);
                execute(outMessage);
            }
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "for_res_bot";
    }

    @Override
    public String getBotToken() {
        return "928012313:AAGJ1BAWp8xocDhVj4S6Z7D0gGLjXW1GtEY";
    }
}

package com.example.project;


import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
//TELEGRAM POLLING BOT DOCUMENT
// GAFK NEW BOT
public class GafkNewsBot extends TelegramLongPollingBot {

    private static final String BOT_NAME ="GafkNews";
    private static  final String BOT_TOKEN ="5266687942:AAHeXv-n5CNajmjVzwygBw8h00LP6yn8XeU";
    NewsGafk newsGafk = new NewsGafk();
    @Override
    public String getBotUsername() {
        return BOT_NAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
        InlineKeyboardMarkup inlineKeyboardMarkup;
        inlineKeyboardMarkup = InlineKeyboard.makeMenuKeyboard();


            if (update.hasMessage() && update.getMessage().hasText()) {
                try {
                    Message inMess = update.getMessage();//Читаем смс если оно есть
                    String chatId = inMess.getChatId().toString();// Читаем чат ид
                String response = parseMessage(inMess.getText());//Парсим
                SendMessage outMess = new SendMessage();
                outMess.setChatId(chatId);//Прикрепляем ид куда отправить
                outMess.setText(response);//Прикрепляем СМС
                outMess.setReplyMarkup(inlineKeyboardMarkup);//Прикрепляем клавиатуру
                execute(outMess);} // Отправляем ответ

             catch(TelegramApiException e){
                e.printStackTrace();
            }
        } else if (update.hasCallbackQuery()) {
                try {

                    CallbackQuery callbackQuery = update.getCallbackQuery();
                    String data = callbackQuery.getData();
                    Message message = callbackQuery.getMessage();
                    SendMessage sendMessage =  new SendMessage();
                    String response = parseMessage(data);
                    sendMessage.setText(response);
                    sendMessage.setChatId(String.valueOf(message.getChatId()));
                    sendMessage.setReplyMarkup(inlineKeyboardMarkup);
                    execute(sendMessage);

                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            }


    private String parseMessage(String textMsg) {
        String response;
        if (textMsg.equals("/start"))
            response = newsGafk.start();
        else if(textMsg.equals("/help"))
            response = newsGafk.helpMenu();
        else if (textMsg.equals("/lastNews"))
            response = newsGafk.lastNews();
        else if (textMsg.equals("/schedule"))
            response = newsGafk.schedule();
        else if (textMsg.equals("/socialMediaLinks"))
            response = newsGafk.socialMediaLinks();
        else if (textMsg.equals("/callSchedule"))
            response = newsGafk.callSchedule();
        else
            response = newsGafk.help();
        return response;


    }

}



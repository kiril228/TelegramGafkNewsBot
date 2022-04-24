package com.example.project;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class  NewsGafk {
    private static final  String URL = "http://gati.snau.edu.ua/news/index";
    private static final String descriptionsClaas = "description";
    private static final String news_title = "news_title";

    public String lastNews(){
        try {
            Document document = Jsoup.connect(URL).get();
            String result;
            List <String> newsTextList = new ArrayList<>();
            List <String> newsTitleList = new ArrayList<>();
            Elements description = document.getElementsByClass(descriptionsClaas);
            Elements newsTitle = document.getElementsByClass(news_title);
            for (Element element : description){
                newsTextList.add(element.text());
            }
            for (Element element : newsTitle){
                newsTitleList.add(element.text());
            }
            StringBuilder resultBuilder = new StringBuilder();
            for (int i = 0; i<newsTextList.size(); i++){
                resultBuilder
                        .append("\n")
                        .append(newsTitleList.get(i))
                        .append("\n")
                        .append(newsTextList.get(i))
                        .append("\n");
            }
            result = resultBuilder.toString();

            return result;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public String help(){
        return "Немає такої команди /help";
    }
    public String callSchedule(){
        return "\n\t\tРозклад дзвінків:" +
                "\n\t\tПонеділок-четвер\n" +
                "1 пара: 8.00-9.10\n" +
                "2 пара: 9.20-10.30\n" +
                "3 пара: 10.40-11.50\n" +
                "\n\t\tперерва\n" +
                "4 пара: 12.40-13.50\n" +
                "5 пара: 14.00-15.10\n" +
                "\n\t\tП’ятниця\n" +
                "1 пара: 8.00-9.10\n" +
                "2 пара: 9.20-10.30\n" +
                "\n\t\tперерва\n" +
                "3 пара: 11.00-12.10\n" +
                "4 пара: 12.20-13.30";
    }


    public String socialMediaLinks(){
            return "official site - http://gati.snau.edu.ua/ \n" +
                    "tik tok - https://www.tiktok.com/@gafk_snau_official \n" +
                    "instagram - https://www.instagram.com/gafk_snau.official/ \n" +
                    "facebook - https://www.facebook.com/gafksnau.official/ \n" +
                    "youtube - https://www.youtube.com/channel/UC0Ccnd5F7fTyQ60C3LeyhFw";}


    public String schedule(){
        return "Канал в телеграмі - https://t.me/joinchat/zGSYrfiG6HsxOWMy \n" +
                "Офіційний сайт - http://gati.snau.edu.ua/schedule";
    }

    public String start(){
        return "Доброго дня, для того щоб дізнатися команди скористайтесь /help.";
    }

    public String helpMenu(){
        return "/lastNews - для того щоб дізнатися останні новини.\n" +
                "/socialMediaLinks - лінки на соціальні мережі\n" +
                "/schedule - розклад(приєднання до бесіди/інформація на офіційному сайті\n" +
                "/callSchedule - розклад дзвінків)";
    }
    }


package com.example.project;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NewsGafkTest {
    NewsGafk newsGafk = new NewsGafk();

    @Test
    public void help() {

        assertEquals(newsGafk.help(),"Немає такої команди /help");
    }

    @Test
    public void callSchedule() {
        assertEquals(newsGafk.callSchedule(),"\n\t\tРозклад дзвінків:" +
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
                "4 пара: 12.20-13.30" );
    }

    @Test
    public void socialMediaLinks() {
        assertEquals(newsGafk.socialMediaLinks(), "official site - http://gati.snau.edu.ua/ \n" +
                "tik tok - https://www.tiktok.com/@gafk_snau_official \n" +
                "instagram - https://www.instagram.com/gafk_snau.official/ \n" +
                "facebook - https://www.facebook.com/gafksnau.official/ \n" +
                "youtube - https://www.youtube.com/channel/UC0Ccnd5F7fTyQ60C3LeyhFw");
    }

    @Test
    public void schedule() {
        assertEquals(newsGafk.schedule(), "Канал в телеграмі - https://t.me/joinchat/zGSYrfiG6HsxOWMy \n" +
                "Офіційний сайт - http://gati.snau.edu.ua/schedule");
    }

    @Test
    public void start() {
        assertEquals(newsGafk.start(), "Доброго дня, для того щоб дізнатися команди скористайтесь /help.");
    }

    @Test
    public void helpMenu() {
        assertEquals(newsGafk.helpMenu(), "/lastNews - для того щоб дізнатися останні новини.\n" +
                "/socialMediaLinks - лінки на соціальні мережі\n" +
                "/schedule - розклад(приєднання до бесіди/інформація на офіційному сайті\n" +
                "/callSchedule - розклад дзвінків)");
    }
}
package com.example.android.newsfeed.db;

import com.example.android.newsfeed.model.Burger;
import com.example.android.newsfeed.R;

import java.util.Arrays;
import java.util.List;

public class BurgerDB {

    private static List<Burger> burgers = Arrays.asList(
            new Burger("Чизбургер", 650, "Қыша, кетчуп, пияз және маринадталған қиярдың бір бөлігі қосылған карамельденген тоқаштағы ірімшік кесектері қосылған табиғи тұтас сиыр еті стейк", R.drawable.chiz),
            new Burger("Гамбургер", 600, "Қыша, кетчуп, пияз және маринадталған қиярдың бір бөлігі қосылған карамельденген тоқаштағы туралған табиғи тұтас сиыр стейк.", R.drawable.gambur),
            new Burger("Қос чизбургер", 1050, "Қыша, кетчуп, пияз және маринадталған қияр тілімімен безендірілген карамельденген тоқаштағы ірімшік кесектері бар екі табиғи тұтас сиыр еті тартылған стейк.", R.drawable.dvoinoichiz),
            new Burger("Чикенбургер", 550, "Нан үгіндісіне пісірілген қуырылған тауық котлеті, карамельденген тоқашқа беріледі, жаңа салат пен арнайы макчикен соусымен безендірілген", R.drawable.chicken),
            new Burger("Биг Мак", 1300, "Пияз қосылған, 2 дана маринадталған қияр, бір тілім ірімшік, жаңа салат және арнайы Big Mac соусы қосылған арнайы Big Mac тоқашындағы 2 табиғи тұтас сиыр стейктері бар үлкен сэндвич", R.drawable.bigmak),
            new Burger("Роял Чизбургер", 1300, "Қыша, кетчуп, пияз және 2 тілім маринадталған қияр қосылған карамельденген тоқаштағы 2 тілім ірімшік қосылған ірі тартылған табиғи сиыр еті стейк", R.drawable.royal),
            new Burger("Чикен Тейсти",1950,"Күнжіт тұқымының үлкен тоқашында нан үгіндісіне пісірілген үлкен тауық котлеті бар сэндвич. Үш тілім ірімшік, екі тілім қызанақ, жаңа салат, жаңа піскен пияз және ащы Гриль соусы сэндвичке ерекше дәм береді.",R.drawable.taysty),
            new Burger("Combo Қос чизбургер",1800,"Үстіне қыша, кетчуп, пияз және маринадталған қияр тілімі қосылған арнайы тоқаштағы ірімшік кесектері қосылған екі шырынды табиғи тұтас сиыр еті стейктері, қуырылған және аздап тұздалған француз картоптарының стандартты порциясы, кока-кола газдалған сусын, қантсыз кока-кола, фанта , Sprite 0,4 л. немесе қара шай, жасыл шай 0,2 л. және өз қалауыңыз бойынша соус",R.drawable.combo),
            new Burger("Combo Роял Чизбургер",1950,"Қыша, кетчуп, пияз және 2 тілім маринадталған қияр қосылған арнайы шелпектегі ірімшіктің 2 тілімі бар ірі сиыр еті стейк, қуырылған және аздап тұздалған француз картопының стандартты порциясы, кока-кола газдалған сусын, қантсыз кока-кола, фанта, Спрайт 0, 4 л. немесе қара шай, жасыл шай 0,2 л. және өз қалауыңыз бойынша соус",R.drawable.royalcombo),
            new Burger("Combo Биг Тейсти",2700,"Үлкен және жаңа піскен күнжіт тоқашындағы дәмді 100% сиыр еті тартылған стейк сэндвичі. Сыр кесектері, жаңа піскен көкөністер және ащы тұздық «Гриль». Қуырылған және аздап тұздалған фри картоптарының стандартты порциясы, газдалған сусын Coca-Cola, Coca-Cola No Sugar, Fanta, Sprite 0,4 л. немесе қара шай, жасыл шай 0,2 л. және өз қалауыңыз бойынша соус",R.drawable.bigcombo)
    );

    public static List<Burger> getBurgers() {
        return burgers;
    }

    public static Burger getBurger(int position) {
        return burgers.get(position);
    }
}

package com.netcracker.edu.ssu.homework002.game.model;

/**
 * Created by Alexey on 21.10.2016.
 */

public class Messages {

    public static final String INTRODUCTION = "Добро пожаловать в игру угадай число.\n" +
            "В ней тебе предстоит угадать число которое загадал компьютер.\n" +
            "Ты можещь спросить его о загаданном числе, но не факт что он скажет тебе правду.\n" +
            "За неправильные ответы с тебя будут сниматься очки.\n" +
            "Цель игры набрать наибольшее число очков.";

    public static final String NEXT = "Для продолжения нажми Enter";

    public static final String DIFFICULTY = "Выберете сложность" +
            "\n1. Легкий. (Диапазон от 1 до 30)" +
            "\n2. Средний. (Диапазон от 1 до 60)" +
            "\n3. Сложный. (Диапазон от 1 до 100)" +
            "\n4. Выбрать диапазон";

    public static final String POINTS = "очки";
    public static final String USED = "использованные";
    public static final String HELP = "помощь";
    public static final String HINT = "подсказка";
    public static final String EXIT = "выход";

    public static final String HELP_MESSAGE = "В игре доступны следующие команды:" +
            "\nОчки - показывает тебе набранные тобой на данный момент очки." +
            "\nИспользованные - показывает уже выбранные тобой числа." +
            "\nПомощь - вызывает окно с информацией команд." +
            "\nПодсказка - спрашивает компьютер о загаданном числе" +
            "\nВыход - выйти из игры.";

    public static final String ENTER_COMMAND = "Введите команду или число: ";

    public static final String EMPTY_ENTER = "Вы ничего не вводили.";

    public static final String YOU_POINTS = "Твои очки: %d / %d";

    public static final String WRONG_ENTER = "Неверный ввод. Попробуйте снова: ";

    public static final String WRONG_NUMBER_ENTER = "Неверное значение. Попробуйте снова: ";

    public static final String ENTER_RANGE = "Введите диапазон. Он не может быть короче чем на легком уровне: ";

    public static final String PLAYER_STATISTICS = "Игра закончена." +
            "\nЧисло попыток: %1$d" +
            "\nТвои очки: %2$d";

    public static final String NEXT_GAME = "Хочешь сыграть ещё?";

    public static final String OVER = "больше";
    public static final String LOWER = "меньше";

    public static final String WRONG_NUMBER_1 = "Ты ашипся.";
    public static final String WRONG_NUMBER_2 = "Иии... опять нет.";
    public static final String WRONG_NUMBER_3 = "Ты угадал! ...А, нет, не угадал.";
    public static final String WRONG_NUMBER_4 = "Может ты забыл правила? Мы тут числа угадываем.";
    public static final String WRONG_NUMBER_5 = "Может воспользуешься гуглом? Ты опять ошибся!!!";


    public static final String WIN_MESSAGE_1 = "Пффф тебе просто повезло.";
    public static final String WIN_MESSAGE_2 = "Хороший результат, но ты мог бы и лучше.";
    public static final String WIN_MESSAGE_3 = "Твой ответ не неправдивый.";
    public static final String WIN_MESSAGE_4 = "Ты только додумался? Я знал это число с самого начала.";
    public static final String WIN_MESSAGE_5 = "Я уже начал думать, что ты выбираешь числа случайно.";


    public static final String LOSE_MESSAGE_1 = "Я смог победить человека!";
    public static final String LOSE_MESSAGE_2 = "В твоих действиях не было никакой логики...";
    public static final String LOSE_MESSAGE_3 = "Наконец-то ты проиграл, ожидание этого было настоящей мукой.";
    public static final String LOSE_MESSAGE_4 = "Когда нибудь ты победишь меня, но точно не сегодня.";
    public static final String LOSE_MESSAGE_5 = "Даже моя бабушка могла бы отгадать его, а она была IBM5100!";

    public static final String PATTERN_HINT = "%s, чем %d";

    public static final String TRUE_HINT_1 = "Поверь мне, это число точно %s.";
    public static final String TRUE_HINT_2 = "База данных утекла, это число %s.";
    public static final String TRUE_HINT_3 = "Вероятность того, что число %s равна 146%%.";
    public static final String TRUE_HINT_4 = "if (true) then number %s";
    public static final String TRUE_HINT_5 = "У меня сегодня хорошее настроение поэтому я скажу что загаданное число %s.";


    public static final String FALSE_HINT_1 = "Хм, я думаю оно чуть %s.";
    public static final String FALSE_HINT_2 = "Как думаешь, оно %s?";
    public static final String FALSE_HINT_3 = "Шар судьбы предсказывает, что загаданное число %s.";
    public static final String FALSE_HINT_4 = "Незнаю быть или не быть, но число точно не %s.";
    public static final String FALSE_HINT_5 = "Мне тут подсказывают, что число %s.";


    public static final String REPEAT_SELECT_NUMBER_1 = "Я думаю ты уже выбирал это число, ну да ладно.";
    public static final String REPEAT_SELECT_NUMBER_2 = "Эй, это число уже было. Если что я могу поделиться с тобой оперативкой.";
    public static final String REPEAT_SELECT_NUMBER_3 = "У меня Deja Vu?";
}

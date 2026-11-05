import java.util.Scanner;
import java.util.Locale;

public class SmartphoneStore {
    private static final Scanner sc = new Scanner(System.in).useLocale(Locale.US);
    private static final String LOGIN = "admin";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) {
        System.out.println("====================================");
        System.out.println("      SMARTPHONE STORE SYSTEM");
        System.out.println("====================================");
        if (!login()) {
            System.out.println("Доступ запрещён. Завершение программы.");
            return;
        }

        int choice;
        do {
            showMenu();
            choice = readInt("Выберите раздел: ", 0, 10);
            switch (choice) {
                case 1 -> catalog();
                case 2 -> customerStatus();
                case 3 -> ageCategory();
                case 4 -> discountCalculator();
                case 5 -> financeAnalysis();
                case 6 -> scoreAnalysis();
                case 7 -> riskCheck();
                case 8 -> serviceTariff();
                case 9 -> recommendationModule();
                case 10 -> finalReport();
                case 0 -> System.out.println("Спасибо за посещение Smartphone Store!");
                default -> System.out.println("Ошибка выбора. Попробуйте ещё раз.");
            }
            if (choice != 0) pause();
        } while (choice != 0);
    }

    private static void showMenu() {
        System.out.println("\\n----------- ГЛАВНОЕ МЕНЮ -----------");
        System.out.println("1. Каталог смартфонов");
        System.out.println("2. Проверка статуса клиента");
        System.out.println("3. Возрастная категория");
        System.out.println("4. Расчёт скидки");
        System.out.println("5. Анализ финансов");
        System.out.println("6. Оценка результата");
        System.out.println("7. Проверка риска покупки");
        System.out.println("8. Расчёт стоимости услуги");
        System.out.println("9. Персональная рекомендация");
        System.out.println("10. Итоговый отчёт");
        System.out.println("0. Выход");
        System.out.println("------------------------------------");
    }

    private static boolean login() {
        System.out.println("Для входа в систему введите учётные данные.");
        String login = readText("Логин: ");
        String password = readText("Пароль: ");
        if (LOGIN.equals(login) && PASSWORD.equals(password)) {
            System.out.println("Вход выполнен успешно.");
            return true;
        } else {
            System.out.println("Неверный логин или пароль!");
            return false;
        }
    }

    private static void catalog() {
        System.out.println("\\n--- КАТАЛОГ СМАРТФОНОВ ---");
        System.out.println("1. Samsung Galaxy A55 — 180000 ₸");
        System.out.println("2. iPhone 13 — 250000 ₸");
        System.out.println("3. Xiaomi Redmi Note 13 — 110000 ₸");
        System.out.println("4. Google Pixel 8 — 290000 ₸");
        System.out.println("5. Samsung Galaxy S24 — 420000 ₸");
        int model = readInt("Выберите модель (1-5): ", 1, 5);
        String[] names = {"Samsung Galaxy A55", "iPhone 13", "Xiaomi Redmi Note 13",
                "Google Pixel 8", "Samsung Galaxy S24"};
        int[] prices = {180000, 250000, 110000, 290000, 420000};
        System.out.println("Вы выбрали: " + names[model - 1] + ", цена: " + prices[model - 1] + " ₸");
    }

    private static void customerStatus() {
        System.out.println("\\n--- СТАТУС КЛИЕНТА ---");
        System.out.println("1. Активный  2. Неактивный  3. Заблокированный");
        int status = readInt("Выберите статус (1-3): ", 1, 3);
        if (status == 1) {
            System.out.println("Статус: активный. Покупки разрешены.");
        } else if (status == 2) {
            System.out.println("Статус: неактивный. Необходимо подтвердить данные.");
        } else {
            System.out.println("Статус: заблокированный. Доступ к покупкам ограничен.");
        }

        int indicator = readInt("Введите показатель активности (0-100): ", 0, 100);
        if (indicator < 30) System.out.println("Низкая активность.");
        else if (indicator < 70) System.out.println("Средняя активность.");
        else System.out.println("Высокая активность.");
    }

    private static void ageCategory() {
        System.out.println("\\n--- ВОЗРАСТНАЯ КАТЕГОРИЯ ---");
        int age = readInt("Введите возраст: ", 0, 120);
        if (age < 7) System.out.println("Категория: ребёнок дошкольного возраста.");
        else if (age < 18) System.out.println("Категория: несовершеннолетний.");
        else if (age < 60) System.out.println("Категория: взрослый.");
        else System.out.println("Категория: пенсионный возраст.");

        boolean hasAccount = readYesNo("Есть аккаунт магазина? (да/нет): ");
        boolean verified = readYesNo("Аккаунт подтверждён? (да/нет): ");
        if (hasAccount && verified) System.out.println("Можно оформить заказ онлайн.");
        else System.out.println("Для онлайн-заказа требуется аккаунт и подтверждение.");

        boolean premium = readYesNo("Покупка на сумму от 300000 ₸? (да/нет): ");
        boolean loyal = readYesNo("Клиент постоянный? (да/нет): ");
        if (premium || loyal) System.out.println("Клиент получает специальное предложение.");
        else System.out.println("Доступна стандартная цена.");

        boolean blocked = readYesNo("Клиент заблокирован? (да/нет): ");
        if (!blocked) System.out.println("Клиент не заблокирован — доступ открыт.");
        else System.out.println("Доступ закрыт.");
    }

    private static void discountCalculator() {
        System.out.println("\\n--- РАСЧЁТ СКИДКИ ---");
        double amount = readDouble("Сумма покупки (₸): ", 0, 100000000);
        boolean regular = readYesNo("Постоянный клиент? (да/нет): ");
        double discount = 0;
        if (amount >= 500000) discount = 15;
        else if (amount >= 300000) discount = 10;
        else if (amount >= 150000) discount = 5;

        if (regular && amount >= 100000) discount += 3;
        if (discount > 18) discount = 18;
        double finalPrice = amount * (1 - discount / 100);
        System.out.printf(Locale.US, "Скидка: %.1f%%\\nИтоговая стоимость: %.2f ₸\\n", discount, finalPrice);
    }

    private static void financeAnalysis() {
        System.out.println("\\n--- АНАЛИЗ ФИНАНСОВ ---");
        double income = readDouble("Введите доход (₸): ", 0, 100000000);
        double expenses = readDouble("Введите расходы (₸): ", 0, 100000000);
        double balance = income - expenses;
        System.out.printf(Locale.US, "Баланс: %.2f ₸\\n", balance);
        if (balance > 0) System.out.println("Финансовый статус: профицит.");
        else if (balance == 0) System.out.println("Финансовый статус: баланс без остатка.");
        else System.out.println("Финансовый статус: дефицит. Рекомендуется сократить расходы.");
    }

    private static void scoreAnalysis() {
        System.out.println("\\n--- ОЦЕНКА РЕЗУЛЬТАТА ---");
        int points = readInt("Введите баллы (0-100): ", 0, 100);
        if (points >= 90) System.out.println("Оценка: 5. Отлично, результат пройден.");
        else if (points >= 75) System.out.println("Оценка: 4. Хорошо, результат пройден.");
        else if (points >= 50) System.out.println("Оценка: 3. Удовлетворительно, результат пройден.");
        else System.out.println("Оценка: 2. Результат не пройден.");
    }

    private static void riskCheck() {
        System.out.println("\\n--- ПРОВЕРКА РИСКА ПОКУПКИ ---");
        int budget = readInt("Бюджет (₸): ", 0, 100000000);
        int phonePrice = readInt("Цена смартфона (₸): ", 0, 100000000);
        int monthlyIncome = readInt("Ежемесячный доход (₸): ", 0, 100000000);
        boolean hasDebt = readYesNo("Есть задолженность? (да/нет): ");
        boolean emergencySavings = readYesNo("Есть финансовый резерв? (да/нет): ");

        if (budget >= phonePrice) {
            if (!hasDebt) {
                if (emergencySavings) System.out.println("Риск низкий: покупка укладывается в бюджет.");
                else System.out.println("Риск средний: покупка возможна, но резерв желательно создать.");
            } else {
                System.out.println("Риск средний: сначала оцените задолженность.");
            }
        } else if (monthlyIncome >= phonePrice && !hasDebt) {
            System.out.println("Риск средний: можно накопить, но покупка сейчас превышает бюджет.");
        } else {
            System.out.println("Риск высокий: рекомендуется выбрать модель дешевле.");
        }
    }

    private static void serviceTariff() {
        System.out.println("\\n--- УСЛУГИ И ТАРИФЫ ---");
        System.out.println("1. Настройка смартфона — 5000 ₸");
        System.out.println("2. Перенос данных — 7000 ₸");
        System.out.println("3. Установка защитного стекла — 3000 ₸");
        System.out.println("4. Комплексная настройка — 12000 ₸");
        System.out.println("5. Диагностика — 2500 ₸");
        int service = readInt("Выберите услугу (1-5): ", 1, 5);
        int base = switch (service) {
            case 1 -> 5000;
            case 2 -> 7000;
            case 3 -> 3000;
            case 4 -> 12000;
            case 5 -> 2500;
            default -> 0;
        };
        boolean urgent = readYesNo("Срочное выполнение? (да/нет): ");
        boolean warranty = readYesNo("Добавить гарантию на услугу? (да/нет): ");
        double total = base + (urgent ? base * 0.25 : 0) + (warranty ? 1500 : 0);
        System.out.printf(Locale.US, "Стоимость услуги: %.2f ₸\\n", total);
    }

    private static void recommendationModule() {
        System.out.println("\\n--- ПЕРСОНАЛЬНАЯ РЕКОМЕНДАЦИЯ ---");
        int budget = readInt("Ваш бюджет (₸): ", 0, 100000000);
        int camera = readInt("Важность камеры (1-5): ", 1, 5);
        int gaming = readInt("Важность игр (1-5): ", 1, 5);
        int battery = readInt("Важность батареи (1-5): ", 1, 5);
        int storage = readInt("Желаемая память (ГБ: 64, 128, 256, 512): ", 64, 512);
        boolean compact = readYesNo("Нужен компактный смартфон? (да/нет): ");

        int score = camera + gaming + battery + (storage >= 256 ? 1 : 0) + (compact ? 1 : 0);
        String level;
        if (score <= 8) level = "низкий";
        else if (score <= 12) level = "средний";
        else level = "высокий";
        System.out.println("Уровень требований: " + level + ".");

        if (budget < 120000) {
            System.out.println("Рекомендация: Xiaomi Redmi Note 13 — бюджетный вариант.");
        } else if (budget < 220000) {
            if (battery >= 4 && gaming <= 3) System.out.println("Рекомендация: Samsung Galaxy A55 — баланс батареи и функций.");
            else System.out.println("Рекомендация: Xiaomi Redmi Note 13 — выгодная покупка.");
        } else if (budget < 320000) {
            if (camera >= 4) System.out.println("Рекомендация: Google Pixel 8 — акцент на камеру (может потребоваться поиск выгодной цены).");
            else if (compact) System.out.println("Рекомендация: iPhone 13 — компактный вариант.");
            else System.out.println("Рекомендация: iPhone 13 — универсальная модель.");
        } else {
            if (gaming >= 4 && storage >= 256) System.out.println("Рекомендация: Samsung Galaxy S24 — производительность и память.");
            else System.out.println("Рекомендация: Google Pixel 8 или Samsung Galaxy S24.");
        }
        System.out.println("Учитывайте реальные цены, наличие и характеристики в магазине.");
    }

    private static void finalReport() {
        System.out.println("\\n========== ИТОГОВЫЙ ОТЧЁТ ==========");
        System.out.println("Система: Smartphone Store System");
        System.out.println("Модули: каталог, статус, возраст, скидки, финансы, оценка, риск, услуги, рекомендации.");
        System.out.println("Использованы: if-else, else-if, вложенные if, &&, ||, !, switch.");
        System.out.println("Ввод проверяется на пустые значения и допустимые диапазоны.");
        System.out.println("Решение: пользователь может выбрать нужный модуль через главное меню.");
        System.out.println("====================================");
    }

    private static String readText(String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = sc.nextLine().trim();
            if (!value.isEmpty()) return value;
            System.out.println("Ошибка: значение не должно быть пустым.");
        }
    }

    private static int readInt(String prompt, int min, int max) {
        while (true) {
            String input = readText(prompt);
            try {
                int value = Integer.parseInt(input);
                if (value >= min && value <= max) return value;
                System.out.println("Ошибка: введите число от " + min + " до " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: необходимо ввести целое число.");
            }
        }
    }

    private static double readDouble(String prompt, double min, double max) {
        while (true) {
            String input = readText(prompt).replace(',', '.');
            try {
                double value = Double.parseDouble(input);
                if (Double.isFinite(value) && value >= min && value <= max) return value;
                System.out.println("Ошибка: число должно быть от " + min + " до " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: необходимо ввести число.");
            }
        }
    }

    private static boolean readYesNo(String prompt) {
        while (true) {
            String input = readText(prompt).toLowerCase(Locale.ROOT);
            if (input.equals("да") || input.equals("д") || input.equals("yes") || input.equals("y")) return true;
            if (input.equals("нет") || input.equals("н") || input.equals("no") || input.equals("n")) return false;
            System.out.println("Ошибка: ответьте «да» или «нет».");
        }
    }

    private static void pause() {
        System.out.println("\\nНажмите Enter, чтобы вернуться в меню...");
        sc.nextLine();
    }
}

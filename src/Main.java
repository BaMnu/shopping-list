import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<String> productsList = new ArrayList<>();
        System.out.println("Доступные операции:" + "\n1 [Добавить товар]" + "\n2 [Показать список]" +
                "\n3 [Удалить товар]" + "\n4 [Поиск товара по списку]" + "\nend [Выход из программы]\n");

        while (true) {
            System.out.println("Выберите операцию:");
            String insert = sc.nextLine();
            try {
                if (insert.equals("end")) {
                    break;
                } else if (Integer.parseInt(insert) > 4) {
                    System.out.println("Ошибка! Введен неверный номер для операции. Попробуйте снова.");
                    continue;
                }
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Ошибка! Введено неверное слово для операции. " +
                        "Перезпустите программу и попробуйте снова.");
            }

            switch (insert) {
                case "1":
                    System.out.println("Введите наименование товара:");

                    String insertNewName = sc.nextLine();
                    if (productsList.contains(insertNewName)) {
                        System.out.println("Такое наименование уже есть в списке");
                    } else {
                        productsList.add(insertNewName);
                        System.out.println("Кол-во наименований в списке:\n" + productsList.size());
                    }
                    break;

                case "2":
                    System.out.println("Список покупок:");
                    printList(productsList);
                    break;

                case "3":
                    System.out.println("Список покупок:");
                    printList(productsList);
                    System.out.println("Введите номер или наименование для удаления из списка:");
                    String name = sc.nextLine();

                    int index;
                    if (isNumeric(name)) {
                        index = Integer.parseInt(name) - 1;
                        System.out.println("Наименование " + "'" + productsList.get(index) +
                                "'" + " удалено из спискаа покупок.");
                        productsList.remove(index);
                    } else if (productsList.contains(name)) {
                        System.out.println("Наименование " + "'" + name + "'" + " удалено из списка покупок.");
                        productsList.remove(name);
                    } else {
                        System.out.println("Наименование не найдено. " +
                                "Попробуйте выполнить операцию снова. " +
                                "Проверьте корректность введенного наименования в списке.");
                    }
                    printList(productsList);
                    break;

                case "4":
                    System.out.println("Введите текст для поиска: ");
                    String searchingName = sc.nextLine().toLowerCase();
                    System.out.println("Найдено:");

                    for (String element : productsList) {
                        String elementLow = element.toLowerCase();
                        if (elementLow.contains(searchingName)) {
                            System.out.println((productsList.indexOf(element) + 1) + "." + " " + element);
                        }
                    }
                    break;
            }
        }
        System.out.println("Программа завершена. Благодарим за использование.");
        sc.close();
    }

    public static boolean isNumeric(String input) throws NumberFormatException {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void printList(List<String> list) {
        for (String listElement : list) {
            System.out.println((list.indexOf(listElement) + 1) + "." + " " + listElement);
        }
    }
}
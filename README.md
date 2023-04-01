    Практикум SDET:  UI-Тест XYZ Bank
    
        Тест классы: src/test/java/cases
    
        Объекты элементов страниц: src/test/java/pageObjects
        
        Методы инициализации и конфиг: src/test/java/utils 
        
        Конфиг*: src/test/resources/conf.properties
                *(В конфиге находится тексты проверок, тестовые имена пользователей и тд.)
        
        Зависимости, версии:
            •JVM - 11
            •allure - 2.17.2
            •aspectj - 1.9.6
            •selenium - 4.0.0
            •selenium-http-jdk-client - 4.8.1
            •junit4 - 2.17.1
        
        Директория для отчетов Allur: target/allure-results


    1.ID: UI-XYZ-Bank №1
    
        Заголовок: Создание клиента (Customer)

        Предусловия: 
            •      Открыть браузер

        Шаги:
            •	Открыть страницу https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager
            •	Нажать на кнопку “Add Customer”
            •	Записать в поле «First Name:» текст «test»
            •	Записать в поле «Last Name:» текст «test»
            •	Записать в поле «Post Code:» текст «123»
            •	Нажать на кнопку “Add Customer”

        Ожидаемый результат:
            •	Сообщение «Customer added successfully with customer id: ID_Клиента»
        
        Постусловия:
            •	Перейти на страницу https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager/list
            •	Удалить созданный аккаунт, нажав на кнопку Delete
            •	Закрыть браузер
        
        Статус:
            •	Success
    
    2.ID: UI-XYZ-Bank №2
        Заголовок: Сортировка клиентов по имени (First Name)
        
        Предусловия: 
            •      Открыть браузер
        
        Шаги:
            •       Открыть страницу https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager
            •	Нажать на кнопку “Customers”
            •	Дважды нажать на текст шапки первой колонки (First Name)
        
        Ожидаемый результат:
            •	Имена отсортированы в алфавитном порядке
            •	Имена отсортированы в обратном алфавитном порядке
        
        Постусловия:
            •	Закрыть браузер 
        
        Статус:
            •	Success
    
    3.ID: UI-XYZ-Bank №3
    
        Заголовок: Поиск клиента
        
        Предусловия: 
            •      Открыть браузер
        
        Шаги:
            •	Открыть страницу https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager
            •	Нажать на кнопку “Customers”
            •	Ввести в поле Search Customer текст “ Neville”
        
        Ожидаемый результат:
            •	Выведена одна строка где в ячейке колонки First Name присутствует текст Neville
        
        Постусловия:
            •	Закрыть браузер
        
        Статус:
            •	Success
        

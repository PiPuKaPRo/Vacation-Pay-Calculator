# Vacation-Pay-Calculator
Калькулятор отпускных. <br> 
Приложение "Калькулятор отпускных".
Микросервис на SpringBoot + Java 11 c одним API:
GET "/calculacte"

Минимальные требования: Приложение принимает твою среднюю зарплату за 12 месяцев и количество дней отпуска - отвечает суммой отпускных, которые придут сотруднику.
Доп. задание: При запросе также можно указать точные дни ухода в отпуск, тогда должен проводиться рассчет отпускных с учётом праздников и выходных.


## Нерабочими праздничными днями (государственными праздниками) в Российской Федерации являются (статья 112 ТК РФ):

* 1 - 6 и 8 января - Новогодние каникулы;
* 7 января - Рождество Христово;
* 23 февраля - День Защитника Отечества;
* 8 марта - Международный женский день;
* 1 мая - День Весны и Труда;
* 9 мая - День Победы;
* 12 июня - День России;
* 4 ноября - День народного единства.
  
## Стек технологий
* Java 11;
* Spring Boot 3.

## Работа с приложением
Написаны unit тесты для базовой проверки расчетов.
```
http://localhost:8080/api/swagger-ui/index.html
```

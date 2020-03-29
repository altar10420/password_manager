Napisz program, który posłuży Ci jako menadżer haseł.
Program powinien mieć następujące funkcjonalności:

- Po podaniu adresu strony oraz nazwy użytkownika program zwraca zapisane dla danego loginu hasło
- Jeśli dla takiej domeny/loginu program nie posiada hasła, użytkownik otrzymuje odpowiedni komunikat
- Program potrafi na żądanie wygenerować nowe hasło (losowy ciąg znaków alfanumerycznych,
 można zaimplementować samemu lub użyć jakiegoś gotowego rozwiązania z sieci)
- Użytkownik ma możliwość dodania nowego hasła dla wybranej pary domena/login
    - Program nie przyjmuje duplikatów. Jeśli wpis istnieje, powinien poprosić użytkownika
     o to czy chce nadpisać hasło.
- Program potrafi wyświetlić pełny raport, posortowany po adresach domen,
 a następnie po loginach. Raport wyświetla Adres domeny, Login oraz zapamiętane hasło
- Wszystkie dane trzymamy w pamięci w odpowiednich strukturach danych (tj. bez bazy danych)
    - Dla chętnych: dane trzymane w pliku, podczas startu aplikacji,
     jeśli taki plik istnieje, program wczytuje zapisane dane z tego pliku (persystencja)
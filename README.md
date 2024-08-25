# Bezpieczeństwo

## Opis

`Bezpieczeństwo` to plugin dla Minecrafta, który pozwala graczom zgłaszać problemy na serwerze oraz umożliwia administratorom przeglądanie i zarządzanie zgłoszeniami. Dzięki temu pluginowi możesz efektywnie monitorować i rozwiązywać problemy zgłaszane przez graczy.

## Funkcje

- **Zgłaszanie Problemów**: Gracze mogą zgłaszać problemy używając komendy `/report`.
- **Przeglądanie Zgłoszeń**: Administratorzy mogą przeglądać zgłoszenia za pomocą komendy `/reports`.
- **Rozwiązywanie Zgłoszeń**: Administratorzy mogą oznaczać zgłoszenia jako rozwiązane za pomocą komendy `/resolve`.

## Instalacja

1. **Pobierz plik `.jar`**:
   - Przejdź do katalogu `libs` (jeśli jest dostępny) i skopiuj plik `Bezpieczeństwo.jar`.

2. **Dodaj plik `.jar` do swojego serwera Minecraft**:
   - Skopiuj plik `Bezpieczeństwo.jar` do katalogu `plugins` na swoim serwerze Minecraft.

3. **Restartuj serwer**:
   - Uruchom ponownie serwer Minecraft, aby załadować plugin.

## Użycie

### Komendy

- `/report <powód>` - Umożliwia graczom zgłaszanie problemów. 
  - **Przykład**: `/report Gracz nie przestrzega zasad`

- `/reports` - Umożliwia administratorom przeglądanie wszystkich zgłoszeń.
  - **Uprawnienia**: `bezpieczenstwo.viewreports`

- `/resolve <numer>` - Umożliwia administratorom oznaczenie zgłoszenia jako rozwiązane.
  - **Przykład**: `/resolve 1`
  - **Uprawnienia**: `bezpieczenstwo.resolve`

### Uprawnienia

- `bezpieczenstwo.viewreports` - Pozwól przeglądać zgłoszenia.
  - **Domyślnie**: Op (Operator)

- `bezpieczenstwo.resolve` - Pozwól oznaczać zgłoszenia jako rozwiązane.
  - **Domyślnie**: Op (Operator)

## Licencja

Projekt jest udostępniany na licencji [MIT](LICENSE). Zobacz plik `LICENSE` dla szczegółowych informacji.

## Kontrybucje

Jeśli masz pomysły na nowe funkcje, znalazłeś błąd lub chciałbyś pomóc w rozwoju projektu, możesz zgłosić problem lub zaproponować zmiany, otwierając zgłoszenie lub pull request na GitHubie.

## Kontakt

Jeśli masz pytania dotyczące projektu, możesz skontaktować się ze mną przez [email](mailto:biuroxwihard@gmail.com) lub otworzyć zgłoszenie na GitHubie.



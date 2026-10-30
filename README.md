# Lumora Addon Template

Vorlage für eigene Addons für den **Lumora Client**. Sie enthält die öffentliche **Lumora API 1.1.0** als Quellcode und
ein fertiges Beispiel-Addon (Session Timer: ein HUD-Widget mit der Zeit in der aktuellen Welt, ein Keybind, eine
Einstellung und eine Benachrichtigung).

Die API hat keine Abhängigkeiten und keine Minecraft-Klassen. Ein Addon, das nur die API nutzt, läuft deshalb mit
**derselben JAR in allen Lumora-Versionen** (1.8.9 bis 26.3).

## Loslegen

1. Oben auf **Use this template → Create a new repository** klicken.
2. Das neue Repository klonen und bauen:

   ```bash
   ./gradlew build
   ```

   Unter Windows `gradlew.bat build`. Benötigt wird ein JDK 21 oder neuer.
3. Die JAR aus `addon/build/libs/` in den `mods`-Ordner der Lumora-Instanz kopieren
   (`%APPDATA%\LumoraClient\instances\<version>\mods`) und den Client starten. Das Addon erscheint im Lumora-Hub
   unter **Addons**, sein Widget im **HUD-Editor**.

## Eigenes Addon daraus machen

- `addon/src/main/resources/fabric.mod.json`: `id`, `name`, `description`, `authors` anpassen.
- `addon/src/main/resources/lumora-addon.json`: `id`, `name`, `entrypoint` und die benötigten `permissions`.
- Paket `dev.lumora.example.timer` umbenennen, `addon.group` in `gradle.properties` und den JAR-Namen in
  `addon/build.gradle.kts` setzen.
- Übersetzungen liegen unter `addon/src/main/resources/assets/<addon-id>/lang/`.

## Aufbau

| Ordner | Inhalt |
|---|---|
| `lumora-api/` | Öffentliche Lumora API: Addons, Events, Einstellungen, HUD-Widgets, Keybinds, Benachrichtigungen, Menüs |
| `addon/` | Beispiel-Addon, nutzt die API nur zur Compile-Zeit (`compileOnly`), zur Laufzeit liefert der Client sie |
| `docs/` | Anleitungen und API-Referenz |
| `.github/workflows/` | Baut das Projekt bei jedem Push und lädt die Addon-JAR als Artefakt hoch |

## Dokumentation

- [Ein Addon erstellen](docs/CREATE_ADDON.md)
- [Ein HUD-Widget erstellen](docs/CREATE_WIDGET.md)
- [HUD-Editor](docs/HUD_EDITOR.md)
- [API-Referenz](docs/API_REFERENCE.md)

## API in anderen Projekten nutzen

Braucht ein Addon Minecraft-Klassen (eine Loom-Mod für eine bestimmte Version), kann es die API aus dem lokalen
Maven-Repository beziehen:

```bash
./gradlew :lumora-api:publishToMavenLocal
```

```groovy
repositories { mavenLocal { content { includeGroup 'dev.lumora' } } }
dependencies { compileOnly 'dev.lumora:lumora-api:1.1.0' }
```

Die API nicht in die eigene JAR einbetten: der Lumora-Client bringt sie mit.

## Lizenz

GNU General Public License v3.0, siehe [LICENSE](LICENSE).

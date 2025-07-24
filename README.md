[![DeepSource](https://app.deepsource.com/gh/dumbdemon/Personal-Bot-Template.svg/?label=active+issues&show_trend=true&token=WJ9wLg1ztwJLUVXMVmWRDBdI)](https://app.deepsource.com/gh/dumbdemon/Personal-Bot-Template/)
[![DeepSource](https://app.deepsource.com/gh/dumbdemon/Personal-Bot-Template.svg/?label=resolved+issues&show_trend=true&token=WJ9wLg1ztwJLUVXMVmWRDBdI)](https://app.deepsource.com/gh/dumbdemon/Personal-Bot-Template/)

[![CodeFactor](https://www.codefactor.io/repository/github/dumbdemon/personal-bot-template/badge)](https://www.codefactor.io/repository/github/dumbdemon/personal-bot-template)</br>

# Personal Discord User Bot Template (JDA)

Make a personal user bot without any of the hard work.</br></br>

## Features

- Uses [JDA v5.6.1](https://github.com/discord-jda/JDA).
- A system tray icon (if supported) for easy shut down.
- Templates for slash commands, buttons, modals, and dropdown menus.
- Yaml style config.

## How to start

You may skip to step 18, if you already have it open in an IDE.

1. Head to [Discord developer portal](https://discord.com/developers/applications).
2. Click `New Application` button and follow on-screen instructions.
3. Fill out any details in the `General Information` tab, if desired.
4. On the left, head to `Installation` tab.
5. Under `Installation Contexts`, unselect `Guild Install`.
6. On the left, head to `Bot` tab.
7. Under `Authorization Flow`, toggle off `Public Bot`.
8. Click `Reset Token`.
9. Click `Yes, do it!`
10. Click `Copy`. Save this token. ***DO NOT SHARE THIS TOKEN WITH ANYONE! NEITHER I NOR A DISCORD REP WILL ASK IT OF YOU!***
11. Download and install an IDE, if you haven't already. EX. [IntelliJ Community Edition](https://www.jetbrains.com/idea/download/), [Eclipse](https://eclipseide.org/), or [VS Code](https://code.visualstudio.com/).
12. Download and install [Git Bash](https://git-scm.com/downloads), if you haven't already.
13. Download and install [Java for Desktops](https://www.java.com/en/), if you haven't already.
14. Create a repo of this by clicking the `Use this template` button at the top.
15. Click `<> Code` and copy the link under the `HTTPS` tab.
16. In a folder of your choice (do not use a cloud folder as it is not necessary), right-click an empty area and click `Open Git Bash here`.
17. Type `git clone` then paste by hitting `SHIFT` + `INS` then press `ENTER`. Wait till it's done processing.
18. Open the folder in your IDE.
19. Create a copy of `config.yaml.example` and rename it to `config.yaml`.
20. Open amd populate the `main` block and choose your logging options.
21. Head to `src/main/java/com/terransky/psersonalBot/interactions` in the file viewer and expand all subfolders there.
22. Create a new java file in any folder extending to the appropriate type. `ButtonComponent` for Buttons, `ModalComponent` for Modals, `SelectMenuString` for String dropdown, `SelectMenuEntity` for Role/User dropdown, or `SlashCommand` for Slash Commands. Make sure the constructor is public and requires no arguments. See `Ping.java` or `InvalidButton.java` for an example.
23. Override the [SlashCommand.execute()](https://github.com/dumbdemon/Personal-Bot-Template/blob/5846662e39919fca048db42c82ba661b856c252b/src/main/java/com/terransky/psersonalBot/core/interactions/SlashCommand.java#L96) function and populate the body.
24. Open the `InteractionsHandler.java` file and in the constructor of the type you have made type `addInteraction();` and call the constructor of the object you have made.
25. Test by running the bot. **NOTE: Commands may not populate immediately**. You may have to wait up to an hour. You can try refreshing Discord by hitting `CTRL` + `R` on the desktop app, or `F5` on the web app.
26. Repeat steps 21 - 24 as needed.
27. Add a PNG image to `src/main/resources` named `icon.png`. This will be the icon that will be displayed in the system tray. Image must be 16 x 16 pixels. You may add a larger image and it will be automatically resized; however, there will be loss of detail.
28. Head to your Gradle tasks and run the `shadowjar` task. This will create a `jar` file in `build/libs`.

After this you now have a jar file you can use to start the bot.

## Start bot on Startup

If you plan on using the bot consistently, it is recommended to have the bot start on startup. These instructions are for Windows machines.
1. Open the `autostart.bat` in Notepad by right-clicking and select `Edit`. Or if you have your IDE open, you can edit it there.
2. Replace the `C:\Path\to\jarfile\TheJar.jar` with the path to the jar from earlier.
3. Right-click the Windows button, and open command prompt as admin.
4. Copy the file path of `autostart.bat`.
5. Type `mklink "C:\Path\to\autorun.bat" "C:\ProgramData\Microsoft\Windows\Start Menu\Programs\StartUp\autorun.bat"`
6. Close command prompt

This will create a symbolic link to the autorun file. Think of it as a "super" shortcut. This will allow you to edit the file without having to move the file every time. If you don't want it to autostart anymore, simply head to `C:\ProgramData\Microsoft\Windows\Start Menu\Programs\StartUp` and delete the `autorun.bat` file.

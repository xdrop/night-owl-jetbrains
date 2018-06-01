### Jetbrains Night Owl 🌌  

> Night owl *theme* for IntelliJ and Webstorm :jack_o_lantern:

Adaption of the [Night Owl](https://marketplace.visualstudio.com/items?itemName=sdras.night-owl) VSCode theme for Webstorm and IntelliJ based on [Material UI Jetbrains](https://github.com/ChrisRM/material-theme-jetbrains) and [Rainbow Brackets](https://github.com/izhangzhihao/intellij-rainbow-brackets). Due to the *syntax highlighting* for Jetbrain IDE's being slightly different the highlighting won't 100% reproduce that of the VS Code plugin, but it's very similar. You can [vote](https://youtrack.jetbrains.com/issue/IDEABKL-5473) to help with this.

![Screenshot](screenshot.png)

Screenshot font: **Fira Code 14pt *(+font ligatures)***

### Support

So far there is support for Javascript and React, feel free to PR for more :smile:

- [x] Javascript
- [x] ReactJS
- [ ] Typescript
- [ ] Vue
- [ ] Angular

### Installation

Installation **is not** very easy, due to Jetbrains Material UI not having released custom theme imports yet, and having to Jetbrains not having approved Rainbow Brackets yet. If you find a simpler way of installing this you are more than welcome to PR. :star2:

1. Install [Material Theme UI](https://plugins.jetbrains.com/plugin/8006-material-theme-ui)

2. Go to **Tools** > **Material Theme** > **Material Theme Chooser** >  **Palenight Theme** (to trigger dark config)

3. [Download](#) this repo and go to `Preferences` under `Plugins` and click `Install Plugin from Disk`

   ![Step 2](instructions1.png)

4. Point it to `rainbow-brackets.zip` and **install**

5. **Restart** your IDE

6. Copy `Material Night Owl.icls` to your IntelliJ or Webstorm `colors` folder in the settings directory 
    - `C:\Users\<User>\.<IntelliOrWebstormJDirectory>\config\colors` (Windows)
    - `~/Library/Preferences/IntelliJIdeaOrWebstormXXXX.X/colors/` (macOS)
    - `~/.<IntelliJOrWebstormDirectory>/config/colors/` (Linux)

7. Paste (and replace) `rainbow_brackets.xml` , `material_theme.xml`, `material_custom_theme.xml` under:

    - `C:\Users\<User>\.<IntelliOrWebstormJDirectory>\config\options` (Windows)
    - `~/Library/Preferences/IntelliJIdeaOrWebstormXXXX.X/options/` (macOS)
    - `~/.<IntelliJOrWebstormDirectory>/config/options/` (Linux)
    - **Note**: If there wasn't a `rainbow_brackets.xml` there already then you didn't restart. Make sure you do before pasting

8. **Restart** your IDE

9. Set **Preferences** > **Appeareance & Behaviour** > **Material Theme** > **Tab Height** > **42**

10. **Preferences** > **Editor** > **Color Scheme** > **Material Night Owl**

11. Turn off code folding outline : **Editor** > **General** > **Code Folding** > **Show code folding outline** (off)

12. Turn off indent guides: **Editor** > **General** > **Show indent guides** (off)

13. Hide toolbars: **View** > (**Toolbar, Tool buttons, Status Bar, Navigation Bar**) > **Untick all**

14. Restart one last time and you are done!



Adjust as needed from Material UI settings in Preferences, or adjust colors from Color Scheme in Preferences.
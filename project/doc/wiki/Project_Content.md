PROJECT CONTENT
===============
Ermon project contains a wiki (ahem), an issue tracker, and three main branches: master, development, and **API branch -gh-pages-**.
First two are created to follow [this approach](https://nvie.com/posts/a-successful-git-branching-model/) of a Git workflow.
Last one hosts the HTML of **Ermon's** [API](https://amcajal.github.io/ermon/) -generated using Javadoc from NetBeans IDE, and modified later manually to add certain features- allowing the access to it as a web page. 

The project content is organized in the following [5S Methodology](https://en.wikipedia.org/wiki/5S_(methodology)) directory hierarchy. The goal is to provide a directory structure that
is easy to follow and where "everything has a place, and there is a place for everything".

![Ermon_directory_layout](@TODO)

Below, a description of each folder:

- The **root directory** contains the repository "front end" files: the installation script (setup.sh), the VCS files (README, LICENSE and git files);
as well as the *Project* directory, containing the project data (source code, makefiles, requirements, tests, traceability data, etc.) and the *Download*
directory, with ready-to-go executables aimed to non-developers and casual users.
- **Project** directory is then divided in the main "triforce":
    - **Doc** folder contains all documentation files: media (images, sounds), the wiki pages, and templates (script templates, source code templates).
    - **Scripts** folder contains all scripts used in the project, of any kind and no matter the purpose.
    - **Dev** folder, based in the primal [Waterfall Model](https://en.wikipedia.org/wiki/Waterfall_model). Here is where the "core" of the project
    is found. In this case, there is a module for both the GUI of the application and its logic. Besides, an integration folder where the ant files
    and related outputs are stored. The "media" folder under this directory contains the images, sounds, or text files required by the final application.
    Do not confuse this "media" folder with the one under "Doc" (the later contains the images for the wiki).

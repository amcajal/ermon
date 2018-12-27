PROJECT CONTENT
===============
Ermon project contains a wiki (ahem), an issue tracker, and two main branches: master and development.

The project content is organized in the following [5S Methodology](https://en.wikipedia.org/wiki/5S_(methodology)) directory hierarchy. The goal is to provide a directory structure that
is easy to follow and where "everything has a place, and there is a place for everything".

![Ermon_dir_structure](@TODO)

Below, a description of each folder:

@TODO
- The **root directory** contains the repository "front end" files: the installation script, the VCS files (README, LICENSE, yaml and git files)
and the *Project* directory, containing the project data (source code, makefiles, requirements, tests, traceability data, etc.)
- **Project** directory provides a *def* folder and a *prototype* folder:
    - The *def* folder contains the DEFinitive project - the data that is being developed and tested to be released.
    - The *prototype* folder contains any state of the art component, proof of concept, initial test, learning data or research in progress.
	The prototype folder is used as a "sandbox", a place to play and break things without any consequence.
- Inside the **definitive** folder, several ones can appear. Because the current project only comprises software, only the *SW* folder appears.
- **SW** folder is then divided in the main "triforce":
    - **Doc** folder contains all documentation files: media (images, sounds), the wiki pages, and templates (script templates, source code templates).
    - **Scripts** folder contains all scripts used in the project, of any kind and no matter the purpose.
    - **Dev** folder, based in the primal [Waterfall Model](https://en.wikipedia.org/wiki/Waterfall_model) provides a folder for each process of the development methodology.
    Here is where the requirements, the design, the source code and the tests are stored.

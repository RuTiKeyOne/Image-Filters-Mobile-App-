# Description files

Here is a detailed description of the project files, this will help you better understand the architecture.

Name            | Description
:-------------------------:|:-------------------------:
build.grable  | Contains all the libraries connected to the project and necessary for correct operation.
Activity  | Contains all the activity class of the application. All the logic of interaction between view and viewmodel is implemented here.
Adapter | Contains an adapter that implements the logic of displaying a list of filters.
Helper | This package contains class FileSaveHelper, which implementations of logic save image.
Interfaces | Contains the interfaces used in the application.
Model | Contains classes of models required for data storage. filterData stores a list of filters.
Repository | This package contains interface and class, which implementation him. Class contains logic prepare image and use in EditImageActive. 
ViewModel | Contains the viewmodel classes needed to implement the mvvm pattern.
notes(androidTest) | Contains test classes that test the logic of the application, there are more than 100 of them in total and they all give a positive result.
notes(test) | Contains classes that test the logic of non-view classes.
drawable | Contains resources used in the markup and application.
layout | Contains view layout used in application.
strings | Contains text variables, which are selected depending on the language installed on the device.

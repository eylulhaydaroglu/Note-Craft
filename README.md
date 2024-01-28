Welcome to NoteCraft, your go-to note-taking application designed for seamless organization and quick access to your thoughts. This Android app employs Room, a robust local database library, to ensure efficient storage and retrieval of your notes. The application consists of two essential screens: a list view displaying your notes and a detailed view for editing or creating new ones. Key features include the ability to add, edit, and delete notes, complete with user-friendly validation to ensure essential fields are filled. The app ensures data persistence, displaying your previously saved notes even after closing and reopening the application.

Project Highlights:

Room Database Setup:

AppDatabase.kt: Implements the Room database using the Singleton pattern for efficient access.
NoteDao.kt: Defines Data Access Object (DAO) operations for adding, updating, deleting, and reading notes.
NoteEntity.kt: Represents a single note as a data class annotated with @Entity for database mapping.
Repository and ViewModel:

NoteRepository.kt: Acts as an intermediary between the ViewModel and DAO, providing methods for CRUD operations.
DetailViewModel.kt: Manages data operations, initializes the Room database, and exposes LiveData for the list of notes.
Fragments and Views:

ListFragment.kt: Displays a list of notes, configures RecyclerView with ListAdapter, and allows navigation to the detail fragment for adding new notes.
DetailFragment.kt: Allows users to edit note titles and content, featuring seamless navigation, data validation, and confirmation dialogs.
UpdateFragment.kt: Enables editing or deleting existing notes, incorporating validation and confirmation dialogs for a smooth user experience.
User Interaction and Navigation:

User-Friendly UI: Carefully designed interfaces with buttons for adding, editing, and deleting notes.
Data Persistence: Ensures previously saved notes are displayed upon reopening the application.
Confirmation Dialogs: Implemented to request user confirmation before deleting a note.
In summary, NoteCraft provides a robust architecture for note management, with features ensuring a smooth user experience, efficient data handling, and seamless navigation between different app functionalities. Dive into organized note-taking with NoteCraft!

![image](https://github.com/eylulhaydaroglu/Note-Craft/assets/113473234/fd50b5d1-30df-4396-b18e-a12c451a976b)

![image](https://github.com/eylulhaydaroglu/Note-Craft/assets/113473234/1b6644ac-2b5f-473a-9a79-c9754cd3e84b)

![image](https://github.com/eylulhaydaroglu/Note-Craft/assets/113473234/45f10b1d-e7dc-4924-ab2c-5de264f18ef6)

![image](https://github.com/eylulhaydaroglu/Note-Craft/assets/113473234/12b81e81-a8b1-4506-a2cf-5bed7e96c0fe)

![image](https://github.com/eylulhaydaroglu/Note-Craft/assets/113473234/a6f7ff02-940c-46b0-ab15-7b793529d626)

![image](https://github.com/eylulhaydaroglu/Note-Craft/assets/113473234/d6a7abb2-a51e-4d1a-b5d8-55c8220f423f)

![image](https://github.com/eylulhaydaroglu/Note-Craft/assets/113473234/98478097-198e-455c-909b-cd2fa57433fd)



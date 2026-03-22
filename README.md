# ChatterBox User Guide

![alt text](image.png)
ChatterBox is a personal assistant chatbot designed to help you keep track of various tasks including ToDos, Deadlines, and Events. It features both a Command Line Interface (CLI) and a Graphical User Interface (GUI).

## Quick Start

1. Ensure you have Java 17 or above installed on your computer
2. Download the latest `chatterbox.jar` file
3. Place the file in a folder you want to use as the application's home directory
4. Double-click the file or run `java -jar chatterbox.jar` in a terminal
5. Type your commands in the text box at the bottom and press Enter or click Send

## Features

**Adding a todo:** `todo`
Adds a simple task with no specific date or time.

- **Format:** `todo DESCRIPTION`
- **Example:** `todo read book`

````
Got it. I've added this task:
  [T][ ] read book
Now you have 1 tasks in the list.
```

**Adding a deadline:** `deadline`
Adds a task with a specific date.
- **Format:** `deadline DESCRIPTION /by YYYY-MM-DD`
- **Example:** `deadline return book /by 2026-03-25`

```
Got it. I've added this task:
  [D][ ] return book (by: Mar 25 2026)
Now you have 2 tasks in the list.
```

**Adding an event:** `event`
Adds a task with a start and end date/time.
- **Format:** `event DESCRIPTION /from START_TIME /to END_TIME`
- **Example:** `event project meeting /from 2026-03-17T14:00 /to 2026-03-17T16:00`

```Got it. I've added this task:
  [E][ ] project meeting (from: Mar 17 2026 14:00 to: Mar 17 2026 16:00)
Now you have 3 tasks in the list.
```

**Listing all tasks:** `list`
Shows all tasks currently stored in your list
- **Format:** `list`

```
Here are the tasks in your list:
1. [T][ ] read book
2. [D][ ] return book (by: Mar 25 2026)
3. [E][ ] project meeting (from: Mar 17 2026 14:00 to: Mar 17 2026 16:00)
```

**Marking a task as done:** `mark`
Marks a specific task as completed
- **Format:** `mark INDEX`
- **Example:** `mark 1`

```
Nice! I've marked this task as done:
  [T][X] read book
```

**Unmarking a task:** `unmark`
Marks a completed tasks as not done yet
- **Format:** `unmark INDEX`
- **Example:** `unmark 1`

```
OK, I've marked this task as not done yet:
  [T][ ] read book
```

**Deleting a task:** `delete`
Removes the specific task from the list
- **Format:** `delete INDEX`
- **Example:** `delete 2`

```
Noted. I've removed this task:
  [D][ ] return book (by: Mar 25 2026)
Now you have 2 tasks in the list.
```

**Tagging a task:** `tag`
Adds a custom tag to a task for easier categorization
- **Format:** `tag INDEX TAG_NAME`
- **Example:** `tag 1 urgent`

```
I've added the tag #urgent to this task:
  [T][ ] read book #urgent
```

**Finding tasks:** `find`
Searches for tasks whose description contains the given keyboard
- **Format:** `find KEYWORD`
- **Example:** `find book`

```
Here are the matching tasks in your list:
1. [T][ ] read book #urgent
```

**Exiting the program:** `bye`
Exits the ChatterBox application
- **Format:** `bye`


````

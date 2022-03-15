#  Sudoku Mobile App

Simple sudoku mobile app. 

![](https://github.com/MonaLizaTurbo/SudokuMobile/blob/master/readme_pictures/sudokuMobile.png)
![](https://github.com/MonaLizaTurbo/SudokuMobile/blob/master/readme_pictures/sudokuMobile3.png)

It automatically downloads levels from Firebase Realtime Database. After opening, it checks if the
phone has current version of database by comparing internal database version number with this which is
on the server. If it's older, application will updates list of levels. On the server, levels are 
stored in JSON file which looks like this:

```
{
  "database_version" : {
    "version" : "4"
  },
  "levels" : {
    " 2   8  47 9  6    6    3   5 8 4 1    152     2 6    5      8       142 8  1 6 3" : {
      "difficulty" : "2",
      "level" : " 2   8  47 9  6    6    3   5 8 4 1    152     2 6    5      8       142 8  1 6 3",
      "solved" : "125378964739546821864291375956834217378152496412967538541623789693785142287419653"
    },
    "34512 68 789 56 2461 4895371   487 645 79231889 61   5 34865971571934 6  6 2 1  3" : {
      "difficulty" : "3",
      "level" : "34512 68 789 56 2461 4895371   487 645 79231889 61   5 34865971571934 6  6 2 1  3",
      "solved" : "345127689789356124612489537123548796456792318897613245234865971571934862968271453"
    },
    "8   5     62  31   3 1 9       7253 2 5 984 6 4961       9 4 8   78  35     3   1" : {
      "difficulty" : "1",
      "level" : "8   5     62  31   3 1 9       7253 2 5 984 6 4961       9 4 8   78  35     3   1",
      "solved" : "891256743562743198734189265618472539275398416349615872153924687927861354486537921"
    }
  }
}
```

The puzzles are sorted by their level of difficulty. If you started playing any puzzle, it will have a ``continue``
label. You can reset level by holding it for a while.

![](https://github.com/MonaLizaTurbo/SudokuMobile/blob/master/readme_pictures/sudokuMobile2.png)

In game you have board and a set of buttons for inserting values. ``pencil`` button allow you to insert
up to two smaller numbers to help you solve the puzzle.

![](https://github.com/MonaLizaTurbo/SudokuMobile/blob/master/readme_pictures/sudokuMobile3.png)
![](https://github.com/MonaLizaTurbo/SudokuMobile/blob/master/readme_pictures/sudokuMobile4.png)

After completing the puzzle, you'll be greeted with a screen telling you how long it took.

![](https://github.com/MonaLizaTurbo/SudokuMobile/blob/master/readme_pictures/sudokuMobile5.png)

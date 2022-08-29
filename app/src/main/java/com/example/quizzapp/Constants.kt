package com.example.quizzapp

object Constants {
    fun getQuestions(): ArrayList<Question> {
        val questionList = ArrayList<Question>()

        val q1 = Question(
            1, "Command which is used to print the currently logged-in user",
            "getTerminalName", "whoami", "currentloggeduser", "touch",
            2
        )
        questionList.add(q1)

        val q2 = Question(
            2, "Command which is used to list all the files present in current directory",
            "ps",
            "gs",
            "ls",
            "ds",
            3
        )
        questionList.add(q2)

        val q3 = Question(
            3,
            "Command which is used to get current directory?",
            "gs",
            "pwd",
            "dir",
            "getdir",
            4
        )
        questionList.add(q3)

        val q4 = Question(
            4,
            "Command which is used to create new directory?",
            "mdir",
            "mkfr",
            "mkdir",
            "fdir",
            3
        )
        questionList.add(q4)

        val q5 = Question(
            5,
            "Command which is used to clear terminal?",
            "clear",
            "delete",
            "clean",
            "clrscr",
            1
        )
        questionList.add(q5)

        val q6 = Question(
            6,
            "Command which is used to change current directory?",
            "chdir",
            "cdir",
            "cd",
            "nd",
            3
        )
        questionList.add(q6)

        val q7 = Question(
            7,
            "Command that leads to previous directory",
            "cd/",
            "cd ..",
            "cd/ ..",
            "/cd",
            2
        )
        questionList.add(q7)

        val q8 = Question(
            8,
            "Command which enables us to write on the text file in the directory",
            "write",
            "txtedit",
            "edit",
            "nano",
            4
        )
        questionList.add(q8)

        val q9 = Question(
            9,
            "Command which reads data from the file and gives their content as output",
            "con",
            "cat",
            "read",
            "concatinate",
            2
        )
        questionList.add(q9)

        val q10 = Question(
            10,
            "Which command in linux refers to 'remove'?",
            "rm",
            "rem",
            "remove",
            "del",
            1
        )
        questionList.add(q10)


        return questionList
    }
}
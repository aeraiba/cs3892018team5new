package pace.cs3892018team5.dev.chinesefortuneaide;

public class Questions {
    String[] myQuestions;
    String[][] myChoices;
    String[] myAnswers;

    public Questions(){


    }

    public void setQuestions()
    {
        myQuestions[0] = "My Question 1";
        myQuestions[2]= "My Question 2";
        myQuestions[3] = "My Questions 3";
    }

    public void setChoices()
    {
     myChoices[0][0] = "true";
     myChoices[0][1] = "false";
     myChoices[1][0] = "true";
     myChoices[1][1] = "false";
     myChoices[2][0] = "true";
     myChoices[2][1] = "false";


    }

    public void setAnsers()
    {
        myAnswers[0] = "true";
        myAnswers[1] = "false";
        myAnswers[2] = "true";
    }

    public String getQuestion(int index)
    {
        String tempQuestion = myQuestions[index];
        return tempQuestion;
    }

    public String getChoice1(int index)
    {
        String tempQuestion = myQuestions[index];
        return tempQuestion;
    }

    public String getChoice2(int index)
    {
        String tempQuestion = myChoices[index][1];
        return tempQuestion;
    }

    public String getChoice3(int index)
    {
        String tempQuestion = myChoices[index][2];
        return tempQuestion;
    }

    public String getCorrectAnwer(int index)
    {
        String answer = myAnswers[index];
        return answer;
    }



}

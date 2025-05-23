import javax.swing.JOptionPane;
public class Enrollment {
    private final String student;
    private final String course;
    private final int[] score = new int[3];


    public void setScore(int score1, int score2, int score3){
        int[] scores = new int[3];
        scores[0] = score1;
        scores[1] = score2;
        scores[2] = score3;
        for(int i=0; i<=this.score.length-1; i++) {
            if (scores[i] >= 0 && scores[i] <= 10) {
                this.score[i] = scores[i];
            }else if(scores[i] < 0) {
                this.score[i] = 0;
            }else{
                this.score[i] = 10;
            }
        }
    }
    private double finalAverage() {
        return (this.score[0] + this.score[1] + this.score[2])/3.0;
    }
    private double finalAverage(double weighted1, double weighted2, double weighted3){
        return ((this.score[0] * weighted1) + (this.score[1] * weighted2) + (this.score[2] * weighted3))/(weighted1 + weighted2 + weighted3);
    }
    public void studentStatus(){
        double average = this.finalAverage();
        if(average >= 6){
            JOptionPane.showMessageDialog(null, "Student Name: " + this.student+ "\nCourse: " + this.course + "\nFinal Average: " + average + "\nStatus: Passed!");
        }else if(average >= 3){
            JOptionPane.showMessageDialog(null, "Student Name: " + this.student + "\nCourse: " + this.course + "\nFinal Average: " + average + "\nStatus: Remediation!");
        }else{
            JOptionPane.showMessageDialog(null, "Student Name: " + this.student + "\nCourse: " + this.course + "\nFinal Average: " + average + "\nStatus: Failed!");
        }
    }

    public Enrollment(String studentName, String courseName) {
        this.student = studentName;
        this.course = courseName;
    }
    public static void main(String[] args) {
        Enrollment student1 = new Enrollment("Student1", "Math");
        Enrollment student2 = new Enrollment("Student2", "English");
        Enrollment student3 = new Enrollment("Student3", "Physics");

        student1.setScore(7,9,10);
        student1.studentStatus();

        student2.setScore(-1,10,4);
        student2.studentStatus();

        student3.setScore(-1,5,2);
        student3.studentStatus();

    }
}

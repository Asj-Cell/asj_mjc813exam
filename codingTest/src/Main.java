import java.util.ArrayList;
public class Main {
    public static void main(String[] args) throws Exception{
        
        ArrayList<ClassS> school = new ArrayList<>();
        double totalko =0;
        double totalen =0;
        double totalma =0;
        double totalso =0;
        double totalsc =0;
        double totalAll =0;
        for (int i = 0; i < 7; i++) {
            school.add(new ClassS());
        }
        for (int i = 0; i < 7; i++) {
            System.out.println((i+1)+"반의 국어 평균: "+school.get(i).koAver());
            totalko += school.get(i).koAver();
            System.out.println((i+1)+"반의 영어 평균: "+school.get(i).enAver());
            totalen += school.get(i).enAver();
            System.out.println((i+1)+"반의 수학 평균: "+school.get(i).maAver());
            totalma += school.get(i).maAver();
            System.out.println((i+1)+"반의 사회 평균: "+school.get(i).soAver());
            totalso +=school.get(i).soAver();
            System.out.println((i+1)+"반의 과학 평균: "+school.get(i).scAver());
            totalsc += school.get(i).scAver();
            System.out.println((i+1)+"반의 전체 평균: "+school.get(i).totalAver());
            totalAll +=school.get(i).totalAver();
            System.out.println((i+1)+"반의 1등 평균: "+school.get(i).max());
        }
        System.out.println("전교생 국어 평균: "+totalko/7);
        System.out.println("전교생 영어 평균: "+totalen/7);
        System.out.println("전교생 수학 평균: "+totalma/7);
        System.out.println("전교생 사회 평균: "+totalso/7);
        System.out.println("전교생 과학 평균: "+totalsc/7);
        System.out.println("전교생 전체 평균: "+totalAll/7);

    }
    static class Student {
        int kor;
        int en;
        int ma;
        int so;
        int sc;
        public Student() {
            this.kor = make();
            this.en = make();
            this.ma = make();
            this.so = make();
            this.sc = make();
        }
       int make() {
            return (int)(Math.random()*60)+41;
       }
        double aver() {
            return (double)(kor+en+so+sc+ma)/5;
        }
    }
    static class ClassS {
        Student[] classes = new Student[30];
        double totalAver=0;
        double koAver=0;
        double maAver=0;
        double enAver=0;
        double soAver=0;
        double scAver=0;
        double max;
        public ClassS() {
            for (int i = 0; i < classes.length; i++) {
                classes[i]= new Student();
            }
        }
        public double koAver() {
            for (int i = 0; i < classes.length; i++) {
                koAver += classes[i].kor;
            }
            koAver= koAver/classes.length;
            return koAver;
        }
        public double enAver() {
            for (int i = 0; i < classes.length; i++) {
                enAver += classes[i].en;
            }
            enAver= enAver/classes.length;
            return enAver;
        }
        public double maAver() {
            for (int i = 0; i < classes.length; i++) {
                maAver += classes[i].ma;
            }
            maAver= maAver/classes.length;
            return maAver;
        }
        public double soAver() {
            for (int i = 0; i < classes.length; i++) {
                soAver += classes[i].so;
            }
            soAver= soAver/classes.length;
            return soAver;
        }
        public double scAver() {
            for (int i = 0; i < classes.length; i++) {
                scAver += classes[i].sc;
            }
            scAver= scAver/classes.length;
            return scAver;
        }
        public double totalAver() {
            for (int i = 0; i < classes.length; i++) {
                totalAver += classes[i].aver();
            }
            totalAver = totalAver/classes.length;
            return totalAver;
        }
        public double max() {
            for (int i = 0; i < classes.length; i++) {
                if (classes[i].aver() > max) {
                    max=classes[i].aver();
                }
            }
            return max;
        }
    }
}
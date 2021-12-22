package MyComparable;

import java.util.Arrays;

class Stu implements Comparable<Stu>{
    String name;
    String number;
    double score;
    public Stu(String name, String number, double score) {
        this.name = name;
        this.number = number;
        this.score = score;
    }

    @Override
    public String toString() {
        return "TestStu{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(Stu o) {
        if(this.score<o.score){
            return 1;
        }else if(this.score==o.score){
            return 0;
        }else{
            return -1;
        }
    }
}

public class MyComparable {
    public static void main(String[] args) {
        Stu[] students=new Stu[5];
        students[0]=new Stu("zhangsan","0002",98.76);
        students[1]=new Stu("lisi","0001",98.45);
        students[2]=new Stu("wangwu","0003",78.56);
        students[3]=new Stu("wangermazi","0005",89.56);
        students[4]=new Stu("wangyi","0004",90.87);
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
    }
}
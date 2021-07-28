package HashTable;

import java.util.*;

/*
* 这里想说的意思是，如果两个self-defined的 object，没有重写equals那么即便他们在理论上是相同的，也不会
* 表现为是相同的。另外，对于hashmap，如果用object作为索引，我们也要重写hashcode，因为hashmap是运用hashcode
* 来进行索引的，如果不对hashcode进行重写，那么即便是两个在equals意义下是相同的obj，也无法索引到相同的value！*/
public class HashCode {
    static class Student {
        private String name;

        public Student(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return Objects.equals(name, student.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        Student st1 = new Student("Cspiration");
        Student st2 = new Student("Cspiration");
        System.out.println(st1.equals(st2));

        Map<Student, Integer> map = new HashMap<>();
        map.put(st1, 3);
        System.out.println(map.get(st2));
        Set<Student> set = new HashSet<>();
        set.add(st1);
        System.out.println(set.contains(st2));
        //st1.setName("Jim");
        System.out.println(set.contains(st2)  + " " + set.contains(st1));
        System.out.println(st1.equals(st2));
        System.out.println(set.toString());
        Student st3 = new Student("Cspiration");
        System.out.println(set.contains(st3));
    }
}

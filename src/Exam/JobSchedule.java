package Exam;

import java.util.*;

public class JobSchedule {
    public static int leastTime(char[] tasks , int n) {
        if (tasks == null || tasks.length == 0) return 0;
        Queue<Character> coolDown = new LinkedList<>();
        Set<Character> withinCoolDown = new HashSet<>();
        int res = 0;
        int taskNum = 0;
        while (taskNum != tasks.length) {
            char curTask = tasks[taskNum];
            if (coolDown.size() > n) {
                char reActive = coolDown.poll();
                withinCoolDown.remove(reActive);
            }
            if (!withinCoolDown.add(curTask)) {
                coolDown.offer('-');
            } else {
                coolDown.offer(curTask);
                taskNum++;
            }
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        char[] tasks = new char[] {'1','2','1','1','3','3','8','3','9'};
        System.out.println(leastTime(tasks, 2));
    }
}
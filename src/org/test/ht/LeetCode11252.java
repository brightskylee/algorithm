package org.test.ht;

import static java.lang.Math.pow;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LeetCode11252 {

    private static class Node {

        LinkedList<Integer> people;
        int skill_set;

        public Node(LinkedList<Integer> people, int skill_set) {
            this.people = people;
            this.skill_set = skill_set;
        }

        public Integer getLastPerson() {
            return people.isEmpty() ? -1 : people.getLast();
        }
    }

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {

        Map<Integer, Integer> peopleSkills = new HashMap<>();

        Map<String, Integer> skillMap = new HashMap<>();
        for(int i=0;i<req_skills.length;i++) {
            skillMap.put(req_skills[i], 1<<i);
        }

        for(int i=0;i<people.size();i++) {
            Integer skillVal = 0;
            for(String s : people.get(i)) {
                skillVal += skillMap.get(s);
            }
            peopleSkills.put(i, skillVal);
        }

        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(new LinkedList<>(), 0));
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.skill_set == pow(2, req_skills.length) - 1) {
                return toArray(current.people);
            }

            int latestPeopleIndex = current.getLastPerson();
            while (++latestPeopleIndex < people.size()) {
                if ((current.skill_set | peopleSkills.get(latestPeopleIndex)) > current.skill_set) {
                    LinkedList<Integer> newPeople = new LinkedList<>(current.people);
                    newPeople.add(latestPeopleIndex);
                    queue.add(new Node(newPeople, current.skill_set | peopleSkills.get(latestPeopleIndex)));
                }
            }
        }
        throw new IllegalStateException("No such combo");
    }

    private static int[] toArray(List<Integer> indexes) {
        int[] res = new int[indexes.size()];

        for(int i=0;i<indexes.size();i++) {
            res[i] = indexes.get(i);
        }
        return res;
    }
}

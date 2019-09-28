package org.test.ht;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LeetCode1125 {

    private static final List<Integer> NO_SOLUTION = Arrays
            .asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {

        long reqSkills = Math.round(Math.pow(2, req_skills.length)) - 1;

        List<Integer> peopleSkills = new ArrayList<>();

        Map<String, Integer> skillMap = new HashMap<>();
        for (int i = 0; i < req_skills.length; i++) {
            skillMap.put(req_skills[i], 1 << i);
        }

        for (int i = 0; i < people.size(); i++) {
            Integer skillVal = 0;
            for (String s : people.get(i)) {
                skillVal += skillMap.get(s);
            }
            peopleSkills.add(skillVal);
        }

        return toArray(smallestSufficientTeam(reqSkills, peopleSkills.size(), peopleSkills));
    }

    public List<Integer> smallestSufficientTeam(long reqSkills, int peopleCount, List<Integer> peopleSkills) {

        if (peopleCount == 50) {
            System.out.println("Start time " + LocalDateTime.now());
        }

        if (reqSkills == 0) {
            return Collections.emptyList();
        }

        if (peopleCount == 0) {
            return NO_SOLUTION;
        }

        List<Integer> newPeopleSkills = new ArrayList<>(peopleSkills);
        newPeopleSkills.remove(0);

        List<Integer> includingFirst;
        List<Integer> notIncludingFirst;


        if (peopleCount == 50) {
            System.out.println("Right before including first " + LocalDateTime.now());
        }

        includingFirst = (reqSkills & peopleSkills.get(0)) == 0 ?
                NO_SOLUTION :
                smallestSufficientTeam(reqSkills ^ peopleSkills.get(0) & reqSkills, peopleCount - 1, newPeopleSkills);


        if (peopleCount == 50) {
            System.out.println("Right before not including first " + LocalDateTime.now());
        }

        long newPeopleSkillAggregate = 0;
        for(Integer skill : newPeopleSkills) {
            newPeopleSkillAggregate |= skill;
        }

        notIncludingFirst = (newPeopleSkillAggregate - (newPeopleSkillAggregate^reqSkills)) == reqSkills ? smallestSufficientTeam(reqSkills, peopleCount - 1, newPeopleSkills) : NO_SOLUTION;

//        notIncludingFirst = smallestSufficientTeam(reqSkills, peopleCount - 1, newPeopleSkills);

        if (peopleCount == 50) {
            System.out.println("Start after not including first " + LocalDateTime.now());
        }

        if (includingFirst == NO_SOLUTION && notIncludingFirst == NO_SOLUTION) {
            return NO_SOLUTION;
        }

        List<Integer> results;

        if (includingFirst.size() + 1 < notIncludingFirst.size()) {
            results = includingFirst.stream().map(index -> index + 1).collect(Collectors.toList());
            results.add(0, 0);
        } else {
            results = notIncludingFirst.stream().map(index -> index + 1).collect(Collectors.toList());
        }


        if (peopleCount == 50) {
            System.out.println("end time " + LocalDateTime.now());
        }

        return results;
    }

    private static int[] toArray(List<Integer> indexes) {
        int[] res = new int[indexes.size()];

        for (int i = 0; i < indexes.size(); i++) {
            res[i] = indexes.get(i);
        }
        return res;
    }

    public static void main(String[] args) {

        String[] req_skills = { "vgzp","urfys","nvkjkzxrfn","pqznypwpcv","bdfmsjlddbinqo","xvgkyzqpmzwcxol","twlau","vybgxpyq","edpuw","w" };
        String[][] people = {{"xvgkyzqpmzwcxol"},{"w"},{"urfys","w"},{"urfys"},{"bdfmsjlddbinqo"},{"xvgkyzqpmzwcxol"},{},{},{"w"},{"vgzp","w"},{"nvkjkzxrfn","bdfmsjlddbinqo","edpuw"},{"urfys"},{"bdfmsjlddbinqo","xvgkyzqpmzwcxol","twlau"},{"nvkjkzxrfn","bdfmsjlddbinqo","vybgxpyq"},{"vgzp","edpuw"},{"urfys","xvgkyzqpmzwcxol"},{"bdfmsjlddbinqo","w"},{"nvkjkzxrfn","bdfmsjlddbinqo","w"},{"bdfmsjlddbinqo","vybgxpyq"},{"urfys","bdfmsjlddbinqo"},{"vgzp"},{"nvkjkzxrfn","xvgkyzqpmzwcxol"},{"nvkjkzxrfn"},{"vgzp","edpuw"},{},{"bdfmsjlddbinqo"},{"vgzp","nvkjkzxrfn","xvgkyzqpmzwcxol"},{"vgzp","bdfmsjlddbinqo","edpuw","w"},{"xvgkyzqpmzwcxol","vybgxpyq","w"},{"pqznypwpcv","vybgxpyq"},{"vybgxpyq"},{"twlau"},{"vgzp"},{"vgzp","twlau","edpuw"},{"nvkjkzxrfn","bdfmsjlddbinqo"},{"bdfmsjlddbinqo"},{"vgzp"},{"urfys"},{"nvkjkzxrfn"},{"nvkjkzxrfn","edpuw"},{"vgzp","nvkjkzxrfn"},{},{"vgzp","nvkjkzxrfn"},{"xvgkyzqpmzwcxol"},{},{"nvkjkzxrfn","xvgkyzqpmzwcxol","vybgxpyq"},{"vybgxpyq"},{"nvkjkzxrfn"},{"nvkjkzxrfn","edpuw"},{"vgzp"}};


        List<List<String>> peopleList = new ArrayList<>();
        for(String[] l : people) {
            peopleList.add(Arrays.asList(l));
        }
        LeetCode1125 leetCode1125 = new LeetCode1125();
        int[] res = leetCode1125.smallestSufficientTeam(req_skills, peopleList);
        for (int index : res) {
            System.out.println(index);
        }
    }
}

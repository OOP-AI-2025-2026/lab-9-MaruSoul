package ua.opnu;

import java.util.*;

public class Task {
    public static void main(String[] args) {

    }

    public void removeShorterStrings(List<String> list) {
        for (int leftI = 0; leftI < list.size() - 1; leftI++) {
            int rightI = leftI + 1;

            if (list.get(leftI).length() <= list.get(rightI).length()) {
                list.remove(leftI);
            } else {
                list.remove(rightI);
            }
        }
    }

    public void stutter(List<String> list) {
        for (int i = 0; i < list.size(); i+= 2) {
            list.add(i + 1, list.get(i));
        }
    }

    public void switchPairs(List<String> list) {
       for (int leftI = 0; leftI <= list.size() - 2; leftI+= 2) {
           int rightI = leftI + 1;
           String temp = list.get(leftI);
           list.set(leftI, list.get(rightI));
           list.set(rightI, temp);
       }
    }

    public void removeDuplicates(List<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            int j = i + 1;
            while (j < list.size() && list.get(j).equals(list.get(i))) {
                list.remove(j);
            }
        }
    }

    public void markLength4(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == 4) {
                list.add(i, "****");
                i = i + 1;
            }
        }
    }

    public boolean isPalindrome(Queue<Integer> queue) {
        Deque<Integer> copy = new ArrayDeque<>(queue);

        while (copy.size() >= 2) {
            if (!copy.removeFirst().equals(copy.removeLast())) {
                return false;
            }
        }

        return true;
    }

    public void reorder(Queue<Integer> queue) {
        Deque<Integer> copy = new ArrayDeque<>();
        while (!queue.isEmpty()) {
            int first = queue.poll();
            if (first < 0) {
                copy.addFirst(first);
            } else  {
                copy.addLast(first);
            }
        }

        queue.addAll(copy);
    }

    public void rearrange(Queue<Integer> queue) {
        Deque<Integer> copy = new ArrayDeque<>();
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            Integer first = queue.poll();
            if (first != null) {
                if (first % 2 == 0) {
                    queue.add(first);
                } else  {
                    copy.addLast(first);
                }
            }
        }

        queue.addAll(copy);
    }

    public int maxLength(Set<String> set) {
        int max = 0;
        for (String s : set) {
            if (s.length() > max) {
                max = s.length();
            }
        }

        return max;
    }

    public void removeEvenLength(Set<String> set) {
        set.removeIf(s -> s.length() % 2 == 0);
    }

    public int numInCommon(List<Integer> list1, List<Integer> list2) {
        int result = 0;

        Set<Integer> listSet1 = new HashSet<>(list1);
        Set<Integer> listSet2 = new HashSet<>(list2);

        if (list1.isEmpty() || list2.isEmpty()) {
            return result;
        }

        for (int i : listSet1) {
            if (listSet2.contains(i)) {
                result++;
            }
        }

       return result;
    }

    public boolean isUnique(Map<String, String> map) {
        return new HashSet<>(map.values()).size() == map.size();
    }

    public Map<String, Integer> intersect(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> result = new HashMap<>();
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            if (Objects.equals(map2.get(key), value)) {
                result.put(key, value);
            }
        }

        return result;
    }

    public Map<String, Integer> reverse(Map<Integer, String> map) {
        Map<String, Integer> result = new HashMap<>();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            Integer newValue = entry.getKey();
            String newKey = entry.getValue();

            result.put(newKey, newValue);
        }

        return result;
    }

    public int rarest(Map<String, Integer> map) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if (frequencyMap.containsKey(value)) {
                frequencyMap.put(value, frequencyMap.get(value) + 1);
            } else {
                frequencyMap.put(value, 1);
            }
        }

        Integer minFrequency = map.size();
        Integer rarestValue = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() < minFrequency) {
                minFrequency = entry.getValue();
                rarestValue = entry.getKey();
            } else if ( Objects.equals(entry.getValue(), minFrequency) && entry.getKey() < rarestValue) {
                rarestValue = entry.getKey();
            }
        }

        return rarestValue;
    }

    public int maxOccurrences(List<Integer> list) {
       Integer max = 1;

       if (list.isEmpty()) {
           return 0;
       }

        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (Integer integer : list) {
            if (frequencyMap.containsKey(integer)) {
                frequencyMap.put(integer, frequencyMap.get(integer) + 1);
                if (frequencyMap.get(integer) > max) {
                    max = frequencyMap.get(integer);
                }
            } else {
                frequencyMap.put(integer, 1);
            }
        }

       return max;
    }

}

import java.util.*;

public class FindEquals {

    public FindEquals() {

    }

    public Map<String, Integer> countEquals (ArrayList <String> list, ArrayList <String> clearList){
        Map<String,Integer> mapCounterEquals = new HashMap<>();

        for (int i = 0; i < clearList.size(); i++) {
            int count = 0;
            for (int j = 0; j < list.size(); j++) {
                if (clearList.get(i).equals(list.get(j))) count++;
            }
            mapCounterEquals.put(clearList.get(i),count);
        }
        return mapCounterEquals;
    }

    public ArrayList<String> clearEquals(ArrayList <String> list){
        Set<String> set = new HashSet<>(list);
        list.removeAll(list);
        list.addAll(set);
        return list;
    }

    public ArrayList<String> assignMas(String[] arrWords) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < arrWords.length; i++) {
            list.add(i,arrWords[i]);
        }
        return list;
    }
}

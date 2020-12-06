import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private Map <String, List<Integer>> phoneMap = new HashMap<>();
    public PhoneBook() {

    }
    public void add(String surname, Integer number){
            List<Integer> numbers = new ArrayList<>();
            numbers.add(number);
            phoneMap.put(surname, numbers);
    }

    public Map<String, List<Integer>> show(){
        return phoneMap;
    }

    public List<Integer> get(String surname){
        return phoneMap.get(surname);
    }


}

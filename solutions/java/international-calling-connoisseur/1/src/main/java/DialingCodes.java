import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class DialingCodes {

    final HashMap<Integer, String> codes = new HashMap<>();

    public Map<Integer, String> getCodes() {
        return Map.copyOf(codes);
    }


    public void setDialingCode(Integer code, String country) {
        codes.put(code, country);
    }

    public String getCountry(Integer code) {
        return codes.get(code);
    }

    public void addNewDialingCode(Integer code, String country) {
        if(codes.containsKey(code) || codes.containsValue(country)){
            return;
        }

        codes.putIfAbsent(code, country);
    }

    public Integer findDialingCode(String country) {
        var foundCountries = codes.entrySet().stream().collect(Collectors.filtering(e -> Objects.equals(e.getValue(), country), Collectors.toList()));
        if (foundCountries.isEmpty()) {
            return null;
        }
        return foundCountries.getFirst().getKey();
    }

    public void updateCountryDialingCode(Integer code, String country) {
        Integer currCode = findDialingCode(country);
        codes.remove(currCode);
        codes.put(code, country);
    }
}

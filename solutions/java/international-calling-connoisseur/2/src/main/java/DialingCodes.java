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
        if (codes.containsKey(code) || codes.containsValue(country)) {
            return;
        }

        codes.putIfAbsent(code, country);
    }

    public Integer findDialingCode(String country) {
        return codes.entrySet().stream()
                .filter(e -> Objects.equals(e.getValue(), country))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }

    public void updateCountryDialingCode(Integer code, String country) {
        codes.values().removeIf(country::equals);
        codes.put(code, country);
    }
}

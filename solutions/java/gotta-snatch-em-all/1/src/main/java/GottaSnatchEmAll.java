import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class GottaSnatchEmAll {

    static Set<String> newCollection(List<String> cards) {
        return new HashSet<>(cards);
    }

    static boolean addCard(String card, Set<String> collection) {
        return collection.add(card);
    }

    static boolean canTrade(Set<String> myCollection, Set<String> theirCollection) {
        HashSet<String> myClone = new HashSet<String>(myCollection);
        HashSet<String> theirClone = new HashSet<String>(theirCollection);

        myClone.removeAll(theirCollection);
        theirClone.removeAll(myCollection);

        boolean myCloneHasElements = !myClone.isEmpty();
        boolean theirCloneHasElements = !theirClone.isEmpty();

        return myCloneHasElements && theirCloneHasElements;
    }

    static Set<String> commonCards(List<Set<String>> collections) {
        return collections.stream().reduce(new HashSet<String>(collections.getFirst()), (setA, setB) -> {
            setA.retainAll(setB);
            return setA;
        });
    }

    static Set<String> allCards(List<Set<String>> collections) {
        return collections.stream().flatMap(Collection::stream).collect(Collectors.toSet());
    }
}

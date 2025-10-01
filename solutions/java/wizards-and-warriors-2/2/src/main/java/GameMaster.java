public class GameMaster {

    public String describe(Character character) {
        return "You're a level ".concat(String.valueOf(character.getLevel()))
                        .concat(" ").concat(character.getCharacterClass())
                        .concat(" with ")
                        .concat(String.valueOf(character.getHitPoints())).concat(" hit points.");    }


    public String describe(Destination destination){
        String destinationName = destination.getName();
        String destinationPop = String.valueOf(destination.getInhabitants());

        return "You've arrived at " + destinationName + ", which has " + destinationPop + " inhabitants.";
    }

    public String describe(TravelMethod travelMethod){
        String travelMethodName = travelMethod.name();

        return "You're traveling to your destination "
                .concat(travelMethodName.equals("WALKING") ? "by " : "on ")
                .concat(travelMethodName.toLowerCase())
                .concat(".");
    }

    public String describe(Character character, Destination destination, TravelMethod travelMethod){
        return describe(character) + " " + describe(travelMethod) + " " + describe(destination);
    }

    public String describe(Character character, Destination destination){
        return describe(character, destination, TravelMethod.WALKING);
    }

}

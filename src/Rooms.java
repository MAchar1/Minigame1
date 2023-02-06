import java.util.ArrayList;

public class Rooms {
    private int roomNumber;
    private ArrayList<Integer> exits;
    private ArrayList<Character> directions;
    private String description;
    private boolean visited;

    public Rooms(int roomNumber, ArrayList<Integer> exits, ArrayList<Character> directions, String description, boolean visited) {
        this.roomNumber = roomNumber;
        this.directions = directions;
        this.exits = exits;
        this.description = description;
        this.visited = visited;
    }

//    public int checkNextRoom(String nextRoom){
//        for (int i = 0; i < directions.length(); i++) {
//            if (directions.contains(nextRoom)){
//                return exits.get(i);
//            }
//        }
//        return 0;
//    }

    // Getters and setters for each attribute
    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public ArrayList<Integer> getExits() {
        return exits;
    }

    public void setExits(ArrayList<Integer> exits) {
        this.exits = exits;
    }

    public ArrayList<Character> getDirections() {
        return directions;
    }

    public void setDirections(ArrayList<Character> directions) {
        this.directions = directions;
    }
}
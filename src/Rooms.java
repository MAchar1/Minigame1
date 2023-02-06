import java.util.ArrayList;

public class Rooms {
    private int roomNumber;
    //there are two ArrayLists, one with the exit room, and the other is the direction the player must travel to get to that room. Both are read in the txt file.
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

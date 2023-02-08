import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//This is the controller class that controls the game

public class UIController extends CannotGoThereException{
    private final ArrayList<Rooms> roomsList = new ArrayList<>();
    private Scanner reader;
    private int currentRoom;

    public void addRoom(Rooms rm){
        roomsList.add(rm);
    }

    public int getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(int currentRoom) {
        this.currentRoom = currentRoom;
    }

    public static void main(String[] args) {
        UIController ui = new UIController();
        //opening the text file
        File file = new File("src/Rooms.txt");
        //Using Scanner to read data from the text file
        Scanner fileReader = null;
        try {
            fileReader = new Scanner(file);
        } catch (FileNotFoundException e){
            System.out.println("The Game has glitched :(");
        }
        //this reads the file and takes all of the info in the text file and creates the room objects.

        while (fileReader!= null && fileReader.hasNext()) {
            String roomNumberString = fileReader.nextLine();
            int roomNumber = Integer.parseInt(roomNumberString);
            String description = fileReader.nextLine();
            String visitedString = fileReader.nextLine();
            boolean visited = Boolean.parseBoolean(visitedString);
            //here i create two ArrayLists, the first an ArrayList with all the other rooms connected to the room.
            //the second ArrayList is one that records the cardinal direction the player type to go to the connected room, all matching in index.
            String initialDirections = fileReader.nextLine();
            ArrayList<Integer> exits = new ArrayList<>();
            ArrayList<Character> directions = new ArrayList<>();
            for (int i = 0; i < initialDirections.length(); i = i + 2) {
                int firstExit = initialDirections.charAt(i) - 48;
                exits.add(firstExit);
                directions.add(initialDirections.charAt(i + 1));
            }
            Rooms rm = new Rooms(roomNumber, exits, directions, description, visited);
            ui.addRoom(rm);
        }

        //this begins the game loop
        Scanner input = new Scanner(System.in);
        System.out.println("The game is beginning. In order to move you must type \"N, S, E, or W\" ");
        ui.setCurrentRoom(0);
        //this is the game loop
        while (ui.getCurrentRoom() < ui.roomlist.size() - 1){
            //initializing the room
            System.out.println(ui.roomsList.get(ui.getCurrentRoom()).getDescription());
            ui.roomsList.get(ui.currentRoom).setVisited(true);
            System.out.println("You can go:");
            System.out.println(ui.roomsList.get(ui.currentRoom).getDirections());
            boolean valid = true;
            //moving to a new room + validation that it can work.
            while (valid) {

                try {
                    //get the direction to the new room from user and saves in the correct format.
                    String nextRoom = input.next();
                    Character nextRoomChar = nextRoom.toUpperCase().charAt(0);
                    //finds the direction ArrayList from Rooms and see if the given direction is an available direction
                    //if it is it sets the current room to the matching room in the exits Arraylist.
                    int indexOfExit = ui.roomsList.get(ui.getCurrentRoom()).getDirections().indexOf(nextRoomChar);
                    ui.setCurrentRoom(ui.roomsList.get(ui.getCurrentRoom()).getExits().get(indexOfExit));
                    valid = false;
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Buddy you cannot go there.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            System.out.println("You won!");
        }
    }
}

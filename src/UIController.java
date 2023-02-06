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
        while (ui.getCurrentRoom() < 6){
            //initializing the room
            System.out.println(ui.roomsList.get(ui.getCurrentRoom()).getDescription());
            ui.roomsList.get(ui.currentRoom).setVisited(true);
            System.out.println("N/S/E/W?");
            String nextRoom = input.next();
            Character nextRoomChar = nextRoom.charAt(0);
            boolean valid = true;
            //moving to a new room + validation that it can work.
            while (valid) {

                try {
                    int indexOfExit = ui.roomsList.get(ui.getCurrentRoom()).getDirections().indexOf(nextRoomChar);
                    ui.setCurrentRoom(ui.roomsList.get(ui.getCurrentRoom()).getExits().get(indexOfExit));
                    valid = false;
                } catch (CannotGoThereException e) {
                    System.out.println("Buddy you cannot go there.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            System.out.println("You won!");
        }
    }
}

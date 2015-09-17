import dungeons.RoomGenerator;
import dungeons.Room;


public class Main {

	public static void main(String[] args) {
		RoomGenerator generator = new RoomGenerator();
		Room room = generator.generate();
		System.out.println(room.getDescription());
	}

}

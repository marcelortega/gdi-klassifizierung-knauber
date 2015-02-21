
public class RunGame {
	
	public static void main(String[] args) {
		HangManGame game = new HangManImpl();
		new HangManMainWindow(game);
	}
	
}

public class Main {
	public static void main(String[] args) {
		System.out.println(
                "Hallo lieber Student.\n" +
                "Willkommen bei deinem Notenmanager.\n" +
                "Waehle eine Aktion aus:");
        new StartAction().execute();
	}
}

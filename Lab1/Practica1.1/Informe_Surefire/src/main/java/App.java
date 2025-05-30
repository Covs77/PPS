public class App {
    public static void main(String[] args) {
        Greeting greetings = new Greeting();
        Farewell farewell = new Farewell();
        Bye bye = new Bye();

        System.out.println(greetings.getMessage());
        System.out.println(farewell.getMessage());
        System.out.println(bye.getMessage());
    }
}


import java.util.Scanner;

public class User {
    private String username;

    public void setUsername() {
        Scanner scannerusername = new Scanner(System.in);
        System.out.println("Ingrese su nombre de usuario:");
        String input = scannerusername.nextLine();
        if (!input.isEmpty()) {
            this.username = input;
            System.out.println("El usuario es:" + username);
        } else {
            System.out.println("No se ingreso un nobmre de usuario correcto");
        }
        scannerusername.close();
    }

    public String getUsername() {
        return this.username;

    }
}
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GitHubApi {
    private static final String BASEURL = "https://api.github.com/users/";

    public static void main(String[] args){
        
        User user = new User();
        user.setUsername();
        String username = user.getUsername();

        String urlString = BASEURL + username;
        String events = "/events";
        System.out.println("User:" + username);

        try {
            URL url = new URL(urlString + events);
            System.out.println("Esta es la url:" + url);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            System.out.println("Codigo de respuesta" + responseCode);
            if(responseCode == HttpURLConnection.HTTP_OK){
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder content = new StringBuilder();
                while ((inputLine = in.readLine()) != null ) {
                    content.append(inputLine);
                }
            in.close();
            System.out.println("Respuesta de la API:" + content.toString());
            }
        } catch (Exception e) {
         e.printStackTrace();
        }
    }

}
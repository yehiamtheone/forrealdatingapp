package forrealdatingapp;

import java.io.IOException;

import forrealdatingapp.Scenes.LoginWindow;
import forrealdatingapp.Scenes.MatchesPage;
import forrealdatingapp.chatScenes.ChatZone;
import io.github.cdimascio.dotenv.Dotenv;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class App extends Application{
    
    public static LoginWindow loginWindow = new LoginWindow();
    public static MatchesPage matchesPage = new MatchesPage();
    
    String token_id;
    public static boolean isTokenOnline = false;
    @Override
    public void start(Stage primaryStage) throws IOException{
       
        loginWindow.showLoginWindow(primaryStage, token_id);

    }
    @Override
    public void stop() {
        // if(ChatZone.messageCounters != null && !ChatZone.messageCounters.isEmpty()){
        //     if(token_id != null){
        //         UsersRouteRequests.UpdateCounter(token_id);
                
        //     }
        // }
        TokenManager tokenManager = new TokenManager();
        if (token_id != null && !isTokenOnline){
            tokenManager.clearToken(token_id);  // Clear the token when the app stops

        }
        ChatZone.closeConnection();
        Platform.exit();  // Exit the JavaFX application
    }
    public static <T extends Pane> void BackToLoginBtn(T div, Stage stage){
        Button backButton = new Button("back to login/sign up screen");
        backButton.setOnAction((actionEvent) -> {
        loginWindow.showLoginWindow(stage,null);

        });
        div.getChildren().add(backButton);
        

        


    }
    public static String getEnv(String key) {
        Dotenv dotenv = Dotenv.load();
        return  System.getenv(key) != null ? System.getenv(key) : dotenv.get(key);
       

    }
    
    
    public static void main(String[] args) throws Exception {
        // // delete later
        // TokenManager tokenManager = new TokenManager();
        // tokenManager.clearToken();

        launch(args);
        
    }
}

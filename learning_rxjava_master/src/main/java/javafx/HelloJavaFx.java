package javafx;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * @author by5388  on 2018/12/28.
 */

public class HelloJavaFx extends Application {
    private int count = 0;

    @Override
    public void start(Stage stage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                count++;
                btn.setText("点击" + count);
                System.exit(0);
            }
        });
        ObservableList<String> strList = FXCollections.observableArrayList("红色", "黄色", "绿色");
        ListView<String> listView = new ListView<>(strList);
        listView.setItems(strList);
        listView.setPrefSize(400, 50);


        StackPane root = new StackPane();
        root.getChildren().add(listView);
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 300, 250);

        stage.setTitle("Hello World!");
        stage.setScene(scene);
        stage.show();
    }
}

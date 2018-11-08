package ch2;

import io.reactivex.Observable;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ch2_13_1 extends Application {
    static int i = 0;

    @Override
    public void start(Stage stage) throws Exception {
        ToggleButton toggleButton = new ToggleButton("TOGGLE ME");
        Button button = new Button("按钮");

        Label label = new Label();
        Label label2 = new Label();

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                label2.setText(String.valueOf(i));
                i++;
            }
        });

        Observable<Boolean> selectedStates =
                valuesOf(toggleButton.selectedProperty());
        selectedStates.map(selected -> selected ? "DOWN" : "UP")
                .subscribe(label::setText);
        VBox vBox = new VBox(toggleButton, button, label, label2);
        stage.setScene(new Scene(vBox));
        stage.show();
    }

    private static <T> Observable<T> valuesOf(final
                                              ObservableValue<T> fxObservable) {
        return Observable.create(observableEmitter -> {
//emit initial state
            observableEmitter.onNext(fxObservable.getValue());
//emit value changes uses a listener
            final ChangeListener<T> listener = (observableValue, prev,
                                                current) -> observableEmitter.onNext(current);
            fxObservable.addListener(listener);
        });
    }
}
package lambdas;

import com.google.common.collect.ImmutableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.List;


public class LambdaVsAnonymousInnerClass {

    //thread local
    static ThreadLocal<DateFormat> dateFormat = ThreadLocal.withInitial(SimpleDateFormat::new);

    private static final ThreadLocal<DateFormat> formatters = new ThreadLocal<DateFormat>() {
        protected DateFormat initialValue() {
            return new SimpleDateFormat("dd-MMM-yyyy");
        }
    };

    public static void main(String[] args) {

        //event handling

        firstButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent obj) {
                System.out.println(obj);
            }
        });

        secondButton.setOnAction(obj -> System.out.println(obj));

        thirdButton.setOnAction(System.out::println);


        //sorting

        buttons.sort(new Comparator<Button>() {
            @Override
            public int compare(Button o1, Button o2) {
                return o1.getText().compareToIgnoreCase(o2.getText());
            }
        });

        buttons.sort((o1, o2) -> o1.getText().compareToIgnoreCase(o2.getText()));


    }


    static Button firstButton = new Button("A");
    static Button secondButton = new Button("B");
    static Button thirdButton = new Button("C");
    static List<Button> buttons = ImmutableList.of(firstButton, secondButton, thirdButton);
}

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
//UI class
public class FxmlDocController {
    CalendarHelper helper; //helper for the class calendar.
    final int BTN_SIZE = 30; //size of the buttons
    @FXML
    private Label lbl;
    @FXML
    private GridPane grid;
    @FXML
    private HBox hbox;
    @FXML
    private VBox vbox;
    //when the application is loaded first.
    @FXML
    protected void initialize(){
        helper = new CalendarHelper();
        hbox.setAlignment(Pos.CENTER);
        vbox.setAlignment(Pos.CENTER);
        initBoard();
    }
    public void initBoard(){
        //init the grid
        grid.setVisible(true);
        grid.getChildren().clear();
        grid.setAlignment(Pos.CENTER);
        //init containers
        for(int i = 0; i < CalendarHelper.DAYS_IN_WEEK; i++){
            ColumnConstraints cc = new ColumnConstraints();
            cc.setHgrow(Priority.ALWAYS);
            cc.setFillWidth(true);
            grid.getColumnConstraints().add(cc);
        }
        for(int j = 0; j < CalendarHelper.WEEKS_IN_MONTH + 1; j++){
            RowConstraints cc = new RowConstraints();
            cc.setVgrow(Priority.ALWAYS);
            cc.setFillHeight(true);
            grid.getRowConstraints().add(cc);
        }

        fillWithButtons();
        lbl.setText(helper.getMonthYear());//sets the label text to the current month and year.
    }
    //fills grid with new generated buttons.
    public void fillWithButtons(){
        for(int i = 0; i < CalendarHelper.DAYS_IN_WEEK; i++){
            Label lbl = new Label();
            lbl.setText(helper.getDay(i));
            lbl.setAlignment(Pos.CENTER);
            grid.add(lbl, i, 0);
        }
        for(int i = 0; i < CalendarHelper.WEEKS_IN_MONTH; i ++){
            for(int j = 0; j < CalendarHelper.DAYS_IN_WEEK; j++){
                Button btn = new Button();
                btn.setVisible(false);
                btn.setPrefWidth(BTN_SIZE);
                btn.setPrefHeight(BTN_SIZE);
                btn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        handleButton(event);
                    }
                });

                if(helper.getLabel(j, i) != -1){
                    btn.setText("" + helper.getLabel(j, i));
                    btn.setVisible(true);
                }
                grid.add(btn, j, i + 1);
            }
        }
    }
    //displays next month.
    @FXML
    protected void nextMonth(ActionEvent actionEvent){
        helper.nextMonth();
        initBoard();
    }
    //displays prev month.
    @FXML
    protected void prevMonth(ActionEvent actionEvent){
        helper.prevMonth();
        initBoard();
    }
    //when a button is pressed we create a JFrame with the date info and text for the date.
    public void handleButton(ActionEvent event){
        int day = Integer.parseInt(((Button)event.getSource()).getText());
        TextJframe frame = new TextJframe(day, helper);
    }
}
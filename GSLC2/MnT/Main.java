package MnT;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
    //Menu//
    /*   1.      How do you create a menu bar, menu, menu item, check menu item, and radio menu item?
         2.      How do you place a menu into a menu bar? How do you place a menu item, check menu item, and radio menu item into a menu?
         3.      Can you place a menu item into another menu item or a check menu or a radio menu item into a menu item?
         4.      How do you associate an image with a menu, menu item, check menu item, and radio menu item?
         5.      How do you associate an accelerator CTRL+O with a menu item, check menu item, and radio menu item? */

    //TableView//
    /*   1.      How do you create a table view? How do you create a table column? How do you add a table column to a table view?
         2.      What is the data type for a TableView’s data model? How do you associate a data model with a TableView?
         3.      How do you set a cell value factory for a TableColumn?
         4.      How do you set an image in a table column header? */

    private TableView<Person> tv;
    private ObservableList<Person> data = FXCollections.observableArrayList();
    private ObservableList<Person> fdata = FXCollections.observableArrayList();
    private RadioMenuItem m1111, m1112;
    private CheckMenuItem m1121, m1122;

    @Override
    public void start(Stage primaryStage) {
        Label l = new Label("Lecturer : CTRL + O\nStudent : CTRL + Y\nToggle Male : CTRL + M\nToggle Female : CTRL +F");
        GridPane gp = new GridPane();
        gp.addRow(0, l);
        gp.addRow(1, ctv());
        gp.setAlignment(Pos.CENTER);

        BorderPane bp = new BorderPane();
        bp.setTop(cmb());
        bp.setCenter(gp);
        filter();

        Scene sc = new Scene(bp, 1920, 1080);
        primaryStage.setScene(sc);
        primaryStage.setTitle("GSLC2");
        primaryStage.show();}

    private MenuBar cmb(){
        MenuBar mb = new MenuBar();

        Image gear = new Image("/gear.png");
        ImageView gearView = new ImageView(gear);
        gearView.setFitHeight(16);
        gearView.setFitWidth(16);

        Image roles = new Image("/conference.png");
        ImageView rolesView = new ImageView(roles);
        rolesView.setFitHeight(16);
        rolesView.setFitWidth(16);

        Image view = new Image("/eye.png");
        ImageView viewView = new ImageView(view);
        viewView.setFitHeight(16);
        viewView.setFitWidth(16);

        Image gender = new Image("/gender.png");
        ImageView genderView = new ImageView(gender);
        genderView.setFitHeight(16);
        genderView.setFitWidth(16);

        Image lecturer = new Image("/speaker-giving-a-lecture-on-a-stand.png");
        ImageView lecturerView = new ImageView(lecturer);
        lecturerView.setFitHeight(16);
        lecturerView.setFitWidth(16);

        Image student = new Image("/student.png");
        ImageView studentView = new ImageView(student);
        studentView.setFitHeight(16);
        studentView.setFitWidth(16);

        Image male = new Image("/male-gender.png");
        ImageView maleView = new ImageView(male);
        maleView.setFitHeight(16);
        maleView.setFitWidth(16);

        Image female = new Image("/femenine.png");
        ImageView femaleView = new ImageView(female);
        femaleView.setFitHeight(16);
        femaleView.setFitWidth(16);

        Image exit = new Image("/4115235_exit_logout_sign out_icon.png");
        ImageView exitView = new ImageView(exit);
        exitView.setFitHeight(16);
        exitView.setFitWidth(16);

        Menu m1 = new Menu("Menu");
        m1.setGraphic(gearView);
        MenuItem m0 = new MenuItem("Exit");
        m0.setOnAction(e -> System.exit(404));
        m0.setGraphic(exitView);

        Menu m11 = new Menu("Viewing Option");
        m11.setGraphic(viewView);
        Menu m111 = new Menu("Roles");
        m111.setGraphic(rolesView);
        Menu m112 = new Menu("Gender");
        m112.setGraphic(genderView);

        m1111 = new RadioMenuItem("Lecturer");
        m1112 = new RadioMenuItem("Student");
        ToggleGroup tg = new ToggleGroup();
        m1111.setToggleGroup(tg);
        m1111.setSelected(true);
        m1112.setToggleGroup(tg);
        m1111.setGraphic(lecturerView);
        m1112.setGraphic(studentView);
        m1111.setOnAction(e -> filter());
        m1112.setOnAction(e -> filter());

        m1121 = new CheckMenuItem("Male");
        m1122 = new CheckMenuItem("Female");
        m1121.setSelected(true);
        m1122.setSelected(true);
        m1121.setGraphic(maleView);
        m1122.setGraphic(femaleView);
        m1121.setOnAction(e -> filter());
        m1122.setOnAction(e -> filter());

        m111.getItems().addAll(m1111, m1112);
        m112.getItems().addAll(m1121, m1122);
        m11.getItems().addAll(m111, m112);
        m1.getItems().addAll(m0, m11);
        mb.getMenus().addAll(m1);

        m0.setAccelerator(KeyCombination.keyCombination("Ctrl+Q"));
        m1111.setAccelerator(KeyCombination.keyCombination("Ctrl+O"));
        m1112.setAccelerator(KeyCombination.keyCombination("Ctrl+Y"));
        m1121.setAccelerator(KeyCombination.keyCombination("Ctrl+M"));
        m1122.setAccelerator(KeyCombination.keyCombination("Ctrl+F"));

        return mb;}

    private TableView<Person> ctv(){
        tv = new TableView<>();
        tv.setMinSize(1280, 720);
        tv.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        ImageView ids = new ImageView(new Image("/8530622_id_card_icon.png"));
        ids.setFitHeight(16);
        ids.setFitWidth(16);

        ImageView names = new ImageView(new Image("/372902_user_name_round_username_linecon_icon.png"));
        names.setFitHeight(16);
        names.setFitWidth(16);

        ImageView gend = new ImageView(new Image("/gender.png"));
        gend.setFitHeight(16);
        gend.setFitWidth(16);

        ImageView roles = new ImageView(new Image("/conference.png"));
        roles.setFitHeight(16);
        roles.setFitWidth(16);

        TableColumn<Person, String> name = new TableColumn<>("Name");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        name.setGraphic(names);

        TableColumn<Person, String> id = new TableColumn<>("ID");
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        id.setGraphic(ids);

        TableColumn<Person, String> gender = new TableColumn<>("Gender");
        gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        gender.setGraphic(gend);

        TableColumn<Person, String> role = new TableColumn<>("Role");
        role.setCellValueFactory(new PropertyValueFactory<>("role"));
        role.setGraphic(roles);

        tv.getColumns().addAll(id, name, gender, role);

        XMLParser.load(data);
        tv.setItems(data);

        return tv;}

    private void filter(){
        fdata.clear();

        boolean showMale = m1121.isSelected();
        boolean showFemale = m1122.isSelected();
        boolean showLecturer = m1111.isSelected();
        boolean showStudent = m1112.isSelected();

        for (Person person : data) {
            boolean matchesGender = (showMale && "Male".equalsIgnoreCase(person.getGender())) ||
                    (showFemale && "Female".equalsIgnoreCase(person.getGender()));

            boolean matchesRole = (showLecturer && "Lecturer".equalsIgnoreCase(person.getRole())) ||
                    (showStudent && "Student".equalsIgnoreCase(person.getRole()));

            if (matchesGender && matchesRole) {
                fdata.add(person);}}

        tv.setItems(fdata);}

    public static void main(String[]a){
        launch(a);}}
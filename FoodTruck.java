import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Arc;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.FontPosture;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.input.KeyCode;

/**
 * CS1331 HW7.
 * @author Tri Le
 * @version 11/14/2022
 */

public class FoodTruck extends Application {
    private TextField hburger = new TextField();
    private TextField hdog = new TextField();
    private TextField ffries = new TextField();
    private TextField pizza = new TextField();
    private TextField subTotal = new TextField();
    private TextField tax = new TextField();
    private TextField calTotal = new TextField();
    private Button btClear = new Button("Clear");
    private Button btPurchase = new Button("Purchase");
    @Override
    public void start(Stage primaryStage) {
        //set the width of the quantity text fields, and set the default value of all item to 0.
        hburger.setPrefWidth(50);
        hburger.setText("0");
        hdog.setPrefWidth(50);
        hdog.setText("0");
        pizza.setPrefWidth(50);
        pizza.setText("0");
        ffries.setPrefWidth(50);
        ffries.setText("0");
        //set the width of the total calculation text fields.
        subTotal.setPrefWidth(90);
        subTotal.setText("$0.00");
        tax.setPrefWidth(90);
        tax.setText("$0.00");
        calTotal.setPrefWidth(90);
        calTotal.setText("$0.00");

        btClear.setStyle("-fx-border-color: red");
        btPurchase.setStyle("-fx-border-color: green");

        //Using GridPane to placing text fields and labels for the food items.
        GridPane gridPaneFood = new GridPane();
        gridPaneFood.setHgap(10);
        gridPaneFood.setVgap(15);
        gridPaneFood.add(hburger, 0, 1);
        gridPaneFood.add(new Label("Hamburger ($8)"), 1, 1);
        gridPaneFood.add(hdog, 0, 2);
        gridPaneFood.add(new Label("Hot Dog ($5)"), 1, 2);
        gridPaneFood.add(pizza, 0, 3);
        gridPaneFood.add(new Label("Pizza ($4)"), 1, 3);
        gridPaneFood.add(ffries, 0, 4);
        gridPaneFood.add(new Label("French Fries ($3)"), 1, 4);
        //Set the alignment.
        gridPaneFood.setAlignment(Pos.CENTER_LEFT);
        hburger.setAlignment(Pos.BOTTOM_RIGHT);
        hdog.setAlignment(Pos.BOTTOM_RIGHT);
        pizza.setAlignment(Pos.BOTTOM_RIGHT);
        ffries.setAlignment(Pos.BOTTOM_RIGHT);

        //Using GridPane to placing text fields and lables for the calculation.
        GridPane gridPaneFoodCal = new GridPane();
        gridPaneFoodCal.setHgap(10);
        gridPaneFoodCal.setVgap(20);
        gridPaneFoodCal.add(new Label("Subtotal: "), 0, 1);
        gridPaneFoodCal.add(subTotal, 1, 1);
        gridPaneFoodCal.add(new Label("Tax (8%): "), 0, 2);
        gridPaneFoodCal.add(tax, 1, 2);
        gridPaneFoodCal.add(new Label("Total order: "), 0, 3);
        gridPaneFoodCal.add(calTotal, 1, 3);
        //Set the alignment.
        subTotal.setAlignment(Pos.BOTTOM_RIGHT);
        tax.setAlignment(Pos.BOTTOM_RIGHT);
        calTotal.setAlignment(Pos.BOTTOM_RIGHT);
        //Not allow the users to insert in this text fields, only shows the calculation.
        subTotal.setEditable(false);
        tax.setEditable(false);
        calTotal.setEditable(false);

        //Create the food items images.
        Rectangle showFoodImages = new Rectangle(60, 190);
        showFoodImages.setFill(Color.rgb(0, 47, 108, 0.5));
        showFoodImages.setArcWidth(20);
        showFoodImages.setArcHeight(20);
        ImageView burgerImage = new ImageView(new Image("burger.png"));
        burgerImage.setFitHeight(40);
        burgerImage.setFitWidth(40);
        ImageView hotdogImage = new ImageView(new Image("hotdog.png"));
        hotdogImage.setFitHeight(40);
        hotdogImage.setFitWidth(40);
        ImageView pizzaImage = new ImageView(new Image("pizza.png"));
        pizzaImage.setFitHeight(40);
        pizzaImage.setFitWidth(40);
        ImageView friesImage = new ImageView(new Image("fries.png"));
        friesImage.setFitHeight(40);
        friesImage.setFitWidth(40);
        //Using gridpane to add the images, also could use VBox.
        GridPane foodsImages = new GridPane();
        foodsImages.setHgap(10);
        foodsImages.setVgap(5);
        foodsImages.add(burgerImage, 1, 0);
        foodsImages.add(hotdogImage, 1, 1);
        foodsImages.add(pizzaImage, 1, 2);
        foodsImages.add(friesImage, 1, 3);
        //Using stackpane to add the background and the items images.
        StackPane foodsImages2 = new StackPane();
        foodsImages2.getChildren().addAll(showFoodImages, foodsImages);

        //Using HBox to placing the two buttons, with the separation between is 440.
        HBox buttons = new HBox(440);
        buttons.getChildren().addAll(btClear, btPurchase);

        //Using GridPane to placing the 1st, food items images, and 2nd gridpanes above.
        GridPane truckDisplay = new GridPane();
        truckDisplay.setHgap(40);
        truckDisplay.setVgap(5);
        truckDisplay.add(gridPaneFood, 1, 1);
        truckDisplay.add(foodsImages2, 2, 1);
        truckDisplay.add(gridPaneFoodCal, 3, 1);

        //Using GridPane to placing the display1 and buttons(HBox).
        GridPane truckDisplay2 = new GridPane();
        truckDisplay2.setHgap(20);
        truckDisplay2.setVgap(20);
        truckDisplay2.add(truckDisplay, 1, 1);
        truckDisplay2.add(buttons, 1, 2);

        //Create the truck title/banner
        Rectangle truckTitle = new Rectangle(0, 0, 590, 70);
        truckTitle.setFill(Color.GOLDENROD);
        Text textTruckName = new Text(145, 40, "CS1331 Food Truck");
        textTruckName.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.REGULAR, 30));
        textTruckName.setFill(Color.NAVY);
        //Using Pane to add the title and name above.
        Pane titlePane = new Pane();
        titlePane.getChildren().addAll(truckTitle, textTruckName);

        //Create the Georgia Tech brand logo at the bottom of the food truck "menu".
        Rectangle bottomLogo = new Rectangle(590, 60);
        bottomLogo.setFill(Color.WHITE);
        ImageView gtlogo = new ImageView(new Image("gtlogo.png"));
        gtlogo.setFitHeight(60);
        gtlogo.setFitWidth(199);
        //Using stackpane to add the background and the logo, using stack pane is easy to
        //placing logo in the middle.
        StackPane logoPane = new StackPane();
        logoPane.getChildren().addAll(bottomLogo, gtlogo);

        //Using VBox to placing the truck title/banner, the truck display2, and the logo.
        VBox truckDisplayFinal = new VBox(10);
        truckDisplayFinal.getChildren().addAll(titlePane, truckDisplay2, logoPane);

        //Color change whenever the users click on different text field.
        hburger.setOnMouseClicked(e -> {
            showFoodImages.setFill(Color.rgb(188, 63, 219, 0.5));
        });
        hdog.setOnMouseClicked(e -> {
            showFoodImages.setFill(Color.rgb(19, 19, 228, 0.5));
        });
        pizza.setOnMouseClicked(e -> {
            showFoodImages.setFill(Color.rgb(8, 97, 249, 0.5));
        });
        ffries.setOnMouseClicked(e -> {
            showFoodImages.setFill(Color.rgb(248, 255, 9, 0.5));
        });

        // create a alert.
        Alert a = new Alert(AlertType.NONE);

        ///////////////////////////////////////
        //Constanly update total cost.
        hburger.setOnKeyPressed(e -> {
            a.setAlertType(AlertType.ERROR);
            if (e.getCode() == KeyCode.MINUS) {
                a.setContentText("Input quantity cannot be a negative value!");
                a.show();
                showFoodImages.setFill(Color.rgb(255, 0, 0, 0.7));
            } else if (!(e.getCode() == KeyCode.BACK_SPACE) && !(e.getCode().isDigitKey())
                && !(e.getCode() == KeyCode.ENTER)) {
                a.setContentText("Input quantity is not a valid value!");
                a.show();
                showFoodImages.setFill(Color.rgb(255, 0, 0, 0.7));
            }
        });
        hburger.setOnKeyReleased(e -> {
            int numBurger = Integer.parseInt(hburger.getText());
            int numHotDog = Integer.parseInt(hdog.getText());
            int numPizza = Integer.parseInt(pizza.getText());
            int numFries = Integer.parseInt(ffries.getText());
            Total totalCost = new Total(numBurger, numHotDog, numPizza, numFries);
            showFoodImages.setFill(Color.rgb(0, 255, 0, 0.5));
            subTotal.setText(String.format("$%.2f", totalCost.getSubTotal()));
            tax.setText(String.format("$%.2f", totalCost.getTax()));
            calTotal.setText(String.format("$%.2f", totalCost.getTotalCost()));
        });

        hdog.setOnKeyPressed(e -> {
            a.setAlertType(AlertType.ERROR);
            if (e.getCode() == KeyCode.MINUS) {
                a.setContentText("Input quantity cannot be a negative value!");
                a.show();
                showFoodImages.setFill(Color.rgb(255, 0, 0, 0.7));
            } else if (!(e.getCode() == KeyCode.BACK_SPACE) && !(e.getCode().isDigitKey())
                && !(e.getCode() == KeyCode.ENTER)) {
                a.setContentText("Input quantity is not a valid value!");
                a.show();
                showFoodImages.setFill(Color.rgb(255, 0, 0, 0.7));
            }
        });
        hdog.setOnKeyReleased(e -> {
            int numBurger = Integer.parseInt(hburger.getText());
            int numHotDog = Integer.parseInt(hdog.getText());
            int numPizza = Integer.parseInt(pizza.getText());
            int numFries = Integer.parseInt(ffries.getText());
            Total totalCost = new Total(numBurger, numHotDog, numPizza, numFries);
            showFoodImages.setFill(Color.rgb(0, 255, 0, 0.5));
            subTotal.setText(String.format("$%.2f", totalCost.getSubTotal()));
            tax.setText(String.format("$%.2f", totalCost.getTax()));
            calTotal.setText(String.format("$%.2f", totalCost.getTotalCost()));
        });

        pizza.setOnKeyPressed(e -> {
            a.setAlertType(AlertType.ERROR);
            if (e.getCode() == KeyCode.MINUS) {
                a.setContentText("Input quantity cannot be a negative value!");
                a.show();
                showFoodImages.setFill(Color.rgb(255, 0, 0, 0.7));
            } else if (!(e.getCode() == KeyCode.BACK_SPACE) && !(e.getCode().isDigitKey())
                && !(e.getCode() == KeyCode.ENTER)) {
                a.setContentText("Input quantity is not a valid value!");
                a.show();
                showFoodImages.setFill(Color.rgb(255, 0, 0, 0.7));
            }
        });
        pizza.setOnKeyReleased(e -> {
            int numBurger = Integer.parseInt(hburger.getText());
            int numHotDog = Integer.parseInt(hdog.getText());
            int numPizza = Integer.parseInt(pizza.getText());
            int numFries = Integer.parseInt(ffries.getText());
            Total totalCost = new Total(numBurger, numHotDog, numPizza, numFries);
            showFoodImages.setFill(Color.rgb(0, 255, 0, 0.5));
            subTotal.setText(String.format("$%.2f", totalCost.getSubTotal()));
            tax.setText(String.format("$%.2f", totalCost.getTax()));
            calTotal.setText(String.format("$%.2f", totalCost.getTotalCost()));
        });

        ffries.setOnKeyPressed(e -> {
            a.setAlertType(AlertType.ERROR);
            if (e.getCode() == KeyCode.MINUS) {
                a.setContentText("Input quantity cannot be a negative value!");
                a.show();
                showFoodImages.setFill(Color.rgb(255, 0, 0, 0.7));
            } else if (!(e.getCode() == KeyCode.BACK_SPACE) && !(e.getCode().isDigitKey())
                && !(e.getCode() == KeyCode.ENTER)) {
                a.setContentText("Input quantity is not a valid value!");
                a.show();
                showFoodImages.setFill(Color.rgb(255, 0, 0, 0.7));
            }
        });
        ffries.setOnKeyReleased(e -> {
            int numBurger = Integer.parseInt(hburger.getText());
            int numHotDog = Integer.parseInt(hdog.getText());
            int numPizza = Integer.parseInt(pizza.getText());
            int numFries = Integer.parseInt(ffries.getText());
            Total totalCost = new Total(numBurger, numHotDog, numPizza, numFries);
            showFoodImages.setFill(Color.rgb(0, 255, 0, 0.5));
            subTotal.setText(String.format("$%.2f", totalCost.getSubTotal()));
            tax.setText(String.format("$%.2f", totalCost.getTax()));
            calTotal.setText(String.format("$%.2f", totalCost.getTotalCost()));
        });
        ////////////////////////////////////////

        // Process events for clear and purchase buttons.
        //use lambda expression.
        btClear.setOnAction(e -> {
            clearCostField();
            showFoodImages.setFill(Color.rgb(0, 47, 108, 0.5));
        });

        //use anonymous inner class an
        btPurchase.setOnAction(new EventHandler<ActionEvent>() {
            @Override // Override the handle method
            public void handle(ActionEvent e) {
                try {
                    a.setAlertType(AlertType.ERROR);
                    if (hburger.getText().matches("[a-zA-Z]+") || hdog.getText().matches("[a-zA-Z]+")
                        || pizza.getText().matches("[a-zA-Z]+") || ffries.getText().matches("[a-zA-Z]+")) {
                        if (hburger.getText().matches("[a-zA-Z]+")) {
                            throw new IllegalQuantityException(hburger.getText());
                        } else if (hdog.getText().matches("[a-zA-Z]+")) {
                            throw new IllegalQuantityException(hdog.getText());
                        } else if (pizza.getText().matches("[a-zA-Z]+")) {
                            throw new IllegalQuantityException(pizza.getText());
                        } else if (ffries.getText().matches("[a-zA-Z]+")) {
                            throw new IllegalQuantityException(ffries.getText());
                        }
                        showFoodImages.setFill(Color.rgb(255, 0, 0, 0.7));
                    }
                    int numBurger = 0;
                    int numHotDog = 0;
                    int numPizza = 0;
                    int numFries = 0;
                    if (hburger.getText() == null || hburger.getText().trim().isEmpty()
                        || hdog.getText() == null || hdog.getText().trim().isEmpty()
                        || pizza.getText() == null || pizza.getText().trim().isEmpty()
                        || ffries.getText() == null || ffries.getText().trim().isEmpty()) {
                        if (hburger.getText() == null || hburger.getText().trim().isEmpty()) {
                            numBurger = 0;
                            hburger.setText("0");
                        } else if (hdog.getText() == null || hdog.getText().trim().isEmpty()) {
                            numHotDog = 0;
                            hdog.setText("0");
                        } else if (pizza.getText() == null || pizza.getText().trim().isEmpty()) {
                            numPizza = 0;
                            pizza.setText("0");
                        } else if (ffries.getText() == null || ffries.getText().trim().isEmpty()) {
                            numFries = 0;
                            ffries.setText("0");
                        }
                    } else {
                        numBurger = Integer.parseInt(hburger.getText());
                        numHotDog = Integer.parseInt(hdog.getText());
                        numPizza = Integer.parseInt(pizza.getText());
                        numFries = Integer.parseInt(ffries.getText());
                    }
                    if (numBurger < 0 || numHotDog < 0 || numPizza < 0 || numFries < 0) {
                        if (numBurger < 0) {
                            throw new NegativeQuantityException(hburger.getText());
                        } else if (numHotDog < 0) {
                            throw new NegativeQuantityException(hdog.getText());
                        } else if (numPizza < 0) {
                            throw new NegativeQuantityException(pizza.getText());
                        } else if (numFries < 0) {
                            throw new NegativeQuantityException(ffries.getText());
                        }
                        showFoodImages.setFill(Color.rgb(255, 0, 0, 0.7));
                    } else {
                        Total totalCost = new Total(numBurger, numHotDog, numPizza, numFries);
                        showFoodImages.setFill(Color.rgb(0, 255, 0, 0.5));

                        // Display cost
                        subTotal.setText(String.format("$%.2f", totalCost.getSubTotal()));
                        tax.setText(String.format("$%.2f", totalCost.getTax()));
                        calTotal.setText(String.format("$%.2f", totalCost.getTotalCost()));

                        a.setAlertType(AlertType.INFORMATION);
                        if (numBurger > 0 || numHotDog > 0 || numPizza > 0 || numFries > 0) {
                            a.setContentText("*** CS1331 Food Truck ***\nReceipt: "
                                + "\n   Subtotal: " + String.format("$%.2f", totalCost.getSubTotal())
                                + "\n   Tax(8%): " + String.format("$%.2f", totalCost.getTax())
                                + "\n   Total order: " + String.format("$%.2f", totalCost.getTotalCost())
                                + "\nThank you!");
                            a.show();
                        } else {
                            a.setContentText("We were unable to process your order. Please try again.");
                            a.show();
                        }

                        //Print receipt
                        try {
                            File outFile = new File("order.txt");
                            PrintWriter outWriter = new PrintWriter(outFile);
                            outWriter.println("     *** CS1331 Food Truck ***");
                            outWriter.println("\n");
                            outWriter.println("Receipt");
                            outWriter.println("_______________________________________");
                            outWriter.println("Quantity:      Item:");
                            if (totalCost.getNumBurger() != 0) {
                                outWriter.println("   " + totalCost.getNumBurger() + "         Hamburger - $8");
                            }
                            if (totalCost.getNumHotDog() != 0) {
                                outWriter.println("   " + totalCost.getNumHotDog() + "         Hot Dog - $5");
                            }
                            if (totalCost.getNumPizza() != 0) {
                                outWriter.println("   " + totalCost.getNumPizza() + "         Pizza - $4");
                            }
                            if (totalCost.getNumFries() != 0) {
                                outWriter.println("   " + totalCost.getNumFries() + "         French Fries - ($3)");
                            }
                            outWriter.println("\n");
                            outWriter.println("_______________________________________");
                            outWriter.println("Subtotal:            "
                                + String.format("$%.2f", totalCost.getSubTotal()));
                            outWriter.println("Tax (8%):            "
                                + String.format("$%.2f", totalCost.getTax()));
                            outWriter.println("Total order:         "
                                + String.format("$%.2f", totalCost.getTotalCost()));
                            outWriter.println("\n");
                            outWriter.println("            Thank You!");
                            outWriter.close();
                        } catch (IOException io) {
                            System.err.println(io.getMessage());
                        }
                    }
                } catch (NegativeQuantityException nv) {
                    a.setContentText(nv.getMessage().toString());
                    a.show();
                } catch (IllegalQuantityException iv) {
                    a.setContentText(iv.getMessage().toString());
                    a.show();
                }
            }
        });

        //Create a scene with the food truck in the scene.
        Scene scene = new Scene(truckDisplayFinal, 590, 395);
        primaryStage.setTitle("Food Truck"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.setResizable(false); //Not allow the user to resize the stage
        primaryStage.show(); // Display the stage
        hburger.requestFocus();

        //////////////////////////////////////////////
        //Graphics Part
        //////////////////////////////////////////////
        //the mid value of the sence with size (540, 340), and the mid in x is 270.
        final int mid = 270;
        //background1.
        Rectangle bgd = new Rectangle(0, 0, 540, 290);
        bgd.setFill(Color.MEDIUMBLUE);

        Text text = new Text(mid + 155, 19, "Lighthouse");
        Text text2 = new Text(mid + 159, 29, "at Midnight.");
        text.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.ITALIC, 15));
        text2.setFont(Font.font("Courier", FontWeight.NORMAL, FontPosture.ITALIC, 12));
        text.setFill(Color.WHITE);
        text2.setFill(Color.WHITE);

        //background2.
        Rectangle sea = new Rectangle(0, 140, 540, 150);  // sea
        sea.setFill(Color.MIDNIGHTBLUE);

        //Moon
        Circle moon = new Circle(33.75, 36.25, 21);  // moon
        moon.setFill(Color.LIGHTYELLOW);

        //Ground
        Circle ground = new Circle(mid, 340, 150);
        ground.setFill(Color.BLACK);

        //The base of the lighthouse.
        Rectangle base = new Rectangle(mid - 30, 180, 60, 20); //x, y, width, height
        base.setFill(Color.DIMGREY);

        //The midbase of the lighthouse.
        Rectangle midBase = new Rectangle(mid - 20, 120, 40, 60);
        midBase.setFill(Color.GREY);

        //The top base of the lighthouse.
        Rectangle topBase = new Rectangle(mid - 25, 115, 50, 5);
        topBase.setFill(Color.FLORALWHITE);

        //The lighthouse/ the very top.
        Rectangle lightHouse = new Rectangle(mid - 15, 85, 30, 30);
        lightHouse.setFill(Color.GREY);

        //The window of the lighthouse.
        Circle window = new Circle(mid, 100, 5);
        window.setFill(Color.BLACK);

        //The roof of the lighthouse.
        Polygon roof = new Polygon(mid, 75, mid - 19, 85, mid + 19, 85);
        roof.setFill(Color.DARKRED);

        //The light path + transparency.
        Polygon lightShadow = new Polygon(mid, 100, mid + 20, 290, 540, 290);
        lightShadow.setFill(Color.rgb(255, 255, 255, 0.3)); //get white and transparency

        //The base of the boat.
        Arc boatBase = new Arc(mid - 135, 130, 20, 10, 190, 160);
        boatBase.setFill(Color.IVORY);

        //The sail of the boat.
        Polygon boatSail = new Polygon(150, 130, 135, 130, 135, 100);
        boatSail.setFill(Color.GOLDENROD);

        //Multiple circle to making a cloud shape.
        Circle cloud1 = new Circle(mid + 140, 72.5, 15);
        Circle cloud2 = new Circle(mid + 160, 70.5, 21);
        Circle cloud3 = new Circle(mid + 180, 74, 12);
        cloud1.setFill(Color.LIGHTSTEELBLUE);
        cloud2.setFill(Color.LIGHTSTEELBLUE);
        cloud3.setFill(Color.LIGHTSTEELBLUE);

        //Create a scene and place it in the stage.
        Pane pane = new Pane();
        pane.getChildren().addAll(bgd, text, text2, sea, moon, ground);
        pane.getChildren().addAll(base, midBase, topBase, lightHouse,
            window, roof, lightShadow);
        pane.getChildren().addAll(boatBase, boatSail);
        pane.getChildren().addAll(cloud1, cloud2, cloud3);

        //Making name and email area.
        Rectangle bgd2 = new Rectangle(0, 0, 150, 50);
        bgd2.setFill(Color.GREY);
        Text textName = new Text(10, 20, "Tri Le");
        Text textEmail = new Text(10, 35, "tcao70@gatech.com");
        textName.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.ITALIC, 19));
        textEmail.setFont(Font.font("Courier", FontWeight.NORMAL, FontPosture.ITALIC, 12));
        textName.setFill(Color.WHITE);
        textEmail.setFill(Color.WHITE);
        //Using Pane to add the above.
        Pane pane2 = new Pane();
        pane2.getChildren().addAll(bgd2, textName, textEmail);

        //Using BorderPane to add the name area on the top and the graphic on the bottom (graphics).
        BorderPane paneGraphics = new BorderPane();
        paneGraphics.setTop(pane2);
        paneGraphics.setBottom(pane);

        //Create a scene with the graphic in the scene.
        Stage stage = new Stage(); // Create a new stage
        stage.setTitle("Graphics Window"); // Set the stage title
        // Set a scene with a button in the stage
        stage.setScene(new Scene(paneGraphics, 540, 340));
        stage.setResizable(false); //to prevent the user from resizing the stage
        stage.show(); // Display the stage
    }
    ///////////////////////////////////////////////////

    /**
     * Making inner class to make a clear cost fields.
     */
    private void clearCostField() {
        Total totalCost2 = new Total(0, 0, 0, 0);
        subTotal.setText(String.format("$%.2f", totalCost2.getSubTotal()));
        tax.setText(String.format("$%.2f", totalCost2.getTax()));
        calTotal.setText(String.format("$%.2f", totalCost2.getTotalCost()));
        //return the value of number of items to zero.
        hburger.setText(String.valueOf(totalCost2.getNumBurger()));
        hdog.setText(String.valueOf(totalCost2.getNumHotDog()));
        pizza.setText(String.valueOf(totalCost2.getNumPizza()));
        ffries.setText(String.valueOf(totalCost2.getNumFries()));
    }

    /**
     * This is the inner class that will calculate the cost.
     */
    public class Total {
        private int numBurger;
        private int numHotDog;
        private int numPizza;
        private int numFries;
        private double tax = 0.08;

        /**
         * This is the constructor of Total, it takes in the user input quantities for hamburger,
         * hot dog, pizza and french fries.
         * @param numBurger the quantity of hamburger.
         * @param numHotDog the quantity of hot dog.
         * @param numPizza the quanity of pizza.
         * @param numFries the quantity of french fries.
         */
        public Total(int numBurger, int numHotDog, int numPizza, int numFries) {
            if (numBurger < 0) {
                this.numBurger = 0;
            } else {
                this.numBurger = numBurger;
            }
            if (numHotDog < 0) {
                this.numHotDog = 0;
            } else {
                this.numHotDog = numHotDog;
            }
            if (numPizza < 0) {
                this.numPizza = 0;
            } else {
                this.numPizza = numPizza;
            }
            if (numFries < 0) {
                this.numFries = 0;
            } else {
                this.numFries = numFries;
            }
        }
        /**
         * The subtotal method that calculate the subtotal of the food order.
         * @return the subtotal.
         */
        public double getSubTotal() {
            double subTotalIs = (this.numBurger * 8) + (this.numHotDog * 5)
                + (this.numPizza * 4) + (this.numFries * 3);
            return subTotalIs;
        }
        /**
         * The tax method that will calculate thhe tax that the customer need to pay. By multiply
         * the subtotal to 0.08 or 8%.
         * @return the tax calculated portion that applied to the order.
         */
        public double getTax() {
            double totalTaxIs = getSubTotal() * tax;
            return totalTaxIs;
        }
        /**
         * The total cost method that calculate the total cost of the order, that include the
         * calculated tax.
         * @return the total cost of the food order.
         */
        public double getTotalCost() {
            double theTotalIs = getSubTotal() + getTax();
            return theTotalIs;
        }

        //getter and setter
        /**
         * A getter method for the quantity of hamburger.
         * @return the quantity of hamburger.
         */
        public int getNumBurger() {
            return this.numBurger;
        }
        /**
         * A setter method for the quantity of hamburger.
         * @param numBurger the quantity of hamburger.
         */
        public void setNumBurger(int numBurger) {
            if (numBurger <= 0) {
                this.numBurger = 0;
            } else {
                this.numBurger = numBurger;
            }
        }
        /**
         * A getter method for the quantity of hot dog.
         * @return the quantity of hot dog.
         */
        public int getNumHotDog() {
            return this.numHotDog;
        }
        /**
         * A setter method for the quantity of hot dog.
         * @param numHotDog the quantity of hot dog.
         */
        public void setNumHotDog(int numHotDog) {
            if (numHotDog <= 0) {
                this.numHotDog = 0;
            } else {
                this.numHotDog = numHotDog;
            }
        }
        /**
         * A getter method for the quantity of pizza.
         * @return the quantity of pizza.
         */
        public int getNumPizza() {
            return this.numPizza;
        }
        /**
         * A setter method for the quantity of pizza.
         * @param numPizza the quantity of pizza.
         */
        public void setNumPizza(int numPizza) {
            if (numPizza <= 0) {
                this.numPizza = 0;
            } else {
                this.numPizza = numPizza;
            }
        }
        /**
         * A getter method for the quantity of french fries.
         * @return the quantity of french fries.
         */
        public int getNumFries() {
            return this.numFries;
        }
        /**
         * A setter method for the quantity of french fries.
         * @param numFries the quantity of french fries.
         */
        public void setNumFries(int numFries) {
            if (numFries <= 0) {
                this.numFries = 0;
            } else {
                this.numFries = numFries;
            }
        }
    }

  /**
   * "The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line."
   * The main method of the FoodTruck.java
   * @param args Command line arguments.
   */
    public static void main(String[] args) {
        launch(args);
    }
}
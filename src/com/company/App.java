package com.company;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Arrays;

public class App extends Application {

    //Размер экрана
    private static final int WIDTH = 1080;
    private static final int HEIGHT = 720;
    //Объекты интерфейса
    private static final int SIZE = 6;
    private Label formulaLabel = new Label("J = ...");
    private Label arrLabel = new Label("Размер массива (1-20)");
    private Label answerLabel = new Label("Ответ: ");
    private TextField sizeArrTextField = new TextField();
    private Label[] arrTextField;
    private Button startBtn = new Button("Go");
    private Line line = new Line(0, 0, WIDTH, 0);
    private Label bufLabel = new Label();
    private Label[] drawLabel;
    //Контейнеры
    private VBox vBox = new VBox();
    private HBox[] hBox = new HBox[SIZE];
    private HBox[] drawHBox;
    private HBox[] drawHBox2;
    private Group mainGroup = new Group();
    //Переменные
    private int sizeArr = 0;
    private String search;
    private char[] symbols = {'f','d','s','r','!','5','c','+','2','3','z','x','|','-','1','9','0',']','^','$',};
    private String answer = "";
    private int start, end, current;

    public static void main(String[] args) {
        Application.launch();
    }

    private void initialization() {

        arrLabel.setFont(Font.font(16));
        arrLabel.setPadding(new Insets(5,0,5,0));
        answerLabel.setFont(Font.font(18));
        formulaLabel.setFont(Font.font(18));
        sizeArrTextField.setPadding(new Insets(5,5,5,5));
        sizeArrTextField.setFont(Font.font(16));
        sizeArrTextField.setPrefWidth(30);
        sizeArrTextField.setAlignment(Pos.CENTER);
        line.setStroke(Color.WHITE);
        for (int i = 0; i < SIZE; i++) {
            hBox[i] = new HBox();
            hBox[i].setPadding(new Insets(5, 3, 3, 8));
            hBox[i].setSpacing(20);
        }
        hBox[0].getChildren().addAll(arrLabel, sizeArrTextField);
        hBox[1].getChildren().add(formulaLabel);
        startBtn.setPadding(new Insets(5, 100, 5, 100));
        startBtn.setFont(new Font(14));
        hBox[2].getChildren().add(startBtn);
        hBox[3].setAlignment(Pos.CENTER);
        hBox[4].getChildren().add(line);
        hBox[4].setPadding(new Insets(0, 0, 0, 0));
        hBox[4].setSpacing(0);
        hBox[5].getChildren().add(answerLabel);
        vBox.setPadding(new Insets(5, 3, 3, 8));
        vBox.getChildren().addAll(
                hBox[4],hBox[0], hBox[1], hBox[5], hBox[2], hBox[3]);

        mainGroup.getChildren().addAll(vBox);
    }

    private void run(String search){

        int counter = 0;
        int counter2 = 0;
        int counter3 = 0;

        for (int i = 0; i < sizeArr; i++) {
            arrTextField[i].setDisable(true);
        }
        start = 0;
        end = sizeArr-1;

        while (start<=end) {

            current = start + (int)Math.floor((end-start)/2);

            if(arrTextField[current].getText().charAt(0) > search.charAt(0)) {
                end = current - 1;
                drawLabel= new Label[end-start+3];

                for (int i = 0; i < end-start+3; i++) {
                    drawLabel[i] = new Label();
                    drawLabel[i].setPadding(new Insets(5, 5, 5, 5));
                    drawLabel[i].setFont(Font.font(16));
                    drawLabel[i].setPrefWidth(30);
                    drawLabel[i].setStyle("-fx-font-weight: bold");
                    drawLabel[i].setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
                    drawLabel[i].setAlignment(Pos.CENTER);
                }
                drawLabel[end-start+1].setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.NONE, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
                drawLabel[end-start+2].setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.NONE, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
                drawLabel[end-start+1].setPrefWidth(40);
                drawLabel[end-start+2].setPrefWidth(40);
                drawLabel[end-start+1].setStyle("-fx-text-fill: red; -fx-font-size: 24px;");
                drawLabel[end-start+2].setStyle("-fx-text-fill: red; -fx-font-size: 24px;");
                drawLabel[end-start+1].setText("0");
                drawLabel[end-start+2].setText("\uD83E\uDC14");
                drawHBox2[counter3].getChildren().addAll(
                        drawLabel[end-start+1],
                        drawLabel[end-start+2]
                );
                for (int i = start; i <= end; i++) {
                    drawLabel[counter2].setText(arrTextField[i].getText());
                    drawHBox2[counter3+1].getChildren().add(drawLabel[counter2]);
                    counter2++;
                }
                vBox.getChildren().add(drawHBox[counter]);
                answer += "0";
                counter2 = 0;
            }
            else if(arrTextField[current].getText().charAt(0) < search.charAt(0)){
                start = current + 1;

                drawLabel= new Label[end-start+3];
                for (int i = 0; i < end-start+3; i++) {
                    drawLabel[i] = new Label();
                    drawLabel[i].setPadding(new Insets(5, 5, 5, 5));
                    drawLabel[i].setFont(Font.font(16));
                    drawLabel[i].setPrefWidth(30);
                    drawLabel[i].setStyle("-fx-font-weight: bold");
                    drawLabel[i].setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
                    drawLabel[i].setAlignment(Pos.CENTER);
                }
                drawLabel[end-start+1].setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.NONE, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
                drawLabel[end-start+2].setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.NONE, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
                drawLabel[end-start+1].setPrefWidth(40);
                drawLabel[end-start+2].setPrefWidth(40);
                drawLabel[end-start+1].setStyle("-fx-text-fill: red; -fx-font-size: 24px;");
                drawLabel[end-start+2].setStyle("-fx-text-fill: red; -fx-font-size: 24px;");
                drawLabel[end-start+1].setText("1");
                drawLabel[end-start+2].setText("\uD83E\uDC16");
                for (int i = start; i <= end; i++) {
                    drawLabel[counter2].setText(arrTextField[i].getText());
                    drawHBox2[counter3+1].getChildren().add(drawLabel[counter2]);
                    counter2++;
                }
                drawHBox2[counter3].getChildren().addAll(
                        drawLabel[end-start+1],
                        drawLabel[end-start+2]
                );
                vBox.getChildren().add(drawHBox[counter]);
                answer += "1";
                counter2 = 0;
            }
            else if(arrTextField[current].getText().charAt(0) == search.charAt(0)){

                if(end - start != 0) {
                    drawLabel = new Label[3];
                    drawLabel[0] = new Label();
                    drawLabel[1] = new Label();
                    drawLabel[2] = new Label();
                    drawLabel[0].setPadding(new Insets(5, 5, 5, 5));
                    drawLabel[0].setFont(Font.font(16));
                    drawLabel[0].setPrefWidth(30);
                    drawLabel[0].setStyle("-fx-font-weight: bold");
                    drawLabel[0].setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
                    drawLabel[0].setAlignment(Pos.CENTER);
                    drawLabel[1].setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.NONE, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
                    drawLabel[2].setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.NONE, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
                    drawLabel[1].setPrefWidth(40);
                    drawLabel[2].setPrefWidth(40);
                    drawLabel[1].setStyle("-fx-text-fill: red; -fx-font-size: 24px;");
                    drawLabel[2].setStyle("-fx-text-fill: red; -fx-font-size: 24px;");
                    if(end - start == 3){
                    drawLabel[1].setText("1");
                    drawLabel[2].setText("\uD83E\uDC16");answer += "1";
                    }
                    else if(end - start == 2){
                        drawLabel[1].setText("1");
                        drawLabel[2].setText("\uD83E\uDC16");
                        answer += "1";
                    }
                    else{
                        drawLabel[1].setText("0");
                        drawLabel[2].setText("\uD83E\uDC14");answer += "0";
                    }
                    drawHBox2[counter3].getChildren().addAll(
                            drawLabel[1],
                            drawLabel[2]
                    );
                    drawLabel[counter2].setText(arrTextField[current].getText());
                    drawHBox2[counter3 + 1].getChildren().add(drawLabel[counter2]);
                    vBox.getChildren().add(drawHBox[counter]);
                }
                if(counter == 0){
                    answer = "0";
                }
                answerLabel.setText("Ответ: " + answer);
                break;
            }
            counter ++;
            counter3 += 2;
        }
    }

    @Override
    public void start(Stage stage) {
        initialization();
        sizeArrTextField.lengthProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.intValue() > oldValue.intValue()) {
                if (sizeArrTextField.getText().length() >= 2) {
                    sizeArrTextField.setText(sizeArrTextField.getText().substring(0, 2));
                }
            }
        });
        startBtn.setOnAction(event -> {
            if(drawHBox != null) {
                for (HBox box : drawHBox) {
                    box.getChildren().removeAll(box.getChildren());
                    box.getChildren().removeAll();
                    vBox.getChildren().removeAll(box);
                }
                answer = "";
            }
            answerLabel.setText("Ответ:");
            try {
                Integer.parseInt(sizeArrTextField.getText());
            } catch (NumberFormatException nfe) {
                System.out.println("Error");
                sizeArrTextField.setText("");
                return;
            }
            if (Integer.parseInt(sizeArrTextField.getText()) > 0 && Integer.parseInt(sizeArrTextField.getText()) < 21) {
                hBox[3].getChildren().removeAll(hBox[3].getChildren());
                sizeArr = Integer.parseInt(sizeArrTextField.getText());
                arrTextField = new Label[sizeArr];
                Arrays.sort(symbols);
                for (int i = 0; i < sizeArr; i++) {
                    arrTextField[i] = new Label();
                    arrTextField[i].setPadding(new Insets(5, 5, 5, 5));
                    arrTextField[i].setFont(Font.font(16));
                    arrTextField[i].setPrefWidth(30);
                    arrTextField[i].setStyle("-fx-font-weight: bold");
                    arrTextField[i].setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
                    arrTextField[i].setAlignment(Pos.CENTER);
                    arrTextField[i].setText(String.valueOf(symbols[i]));
                    arrTextField[i].addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
                        bufLabel = (Label) mouseEvent.getSource(); search = bufLabel.getText();
                        run(search);
                    });

                    hBox[3].getChildren().add(arrTextField[i]);
                }
                formulaLabel.setText("J = " + (int) Math.ceil(Math.log(sizeArr) / Math.log(2)));
                drawHBox = new HBox[(int) Math.ceil(Math.log(sizeArr) / Math.log(2))];
                drawHBox2 = new HBox[((int) Math.ceil(Math.log(sizeArr) / Math.log(2)))*2];
                for (int i = 0; i < ((int) Math.ceil(Math.log(sizeArr) / Math.log(2)))*2; i++) {
                    drawHBox2[i] = new HBox();
                    drawHBox2[i].setSpacing(20);
                    drawHBox2[i].setAlignment(Pos.CENTER);
                }
                int counter4 = 0;
                for (int i = 0; i < (int) Math.ceil(Math.log(sizeArr) / Math.log(2)); i++) {
                    drawHBox[i] = new HBox();
                    drawHBox[i].setSpacing(20);
                    drawHBox[i].setAlignment(Pos.CENTER);
                    drawHBox[i].getChildren().addAll(drawHBox2[counter4++], drawHBox2[counter4++]);
                }
            } else {
                sizeArrTextField.setText("");
            }

        });
        Scene scene = new Scene(mainGroup, WIDTH, HEIGHT);
        stage.setScene(scene);
        stage.setTitle("Lab3");
        stage.show();
    }
}

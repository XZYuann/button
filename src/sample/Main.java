package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        //设置按钮
        Button bt1=new Button("改变窗体背景色");
        Button bt2=new Button("改变按钮背景色");
        Button bt3=new Button("退出");
        bt1.setStyle("-fx-background-color: greenyellow");
        bt2.setStyle("-fx-background-color: greenyellow");
        bt3.setStyle("-fx-background-color: greenyellow");
        bt2.setPrefHeight(40);
        bt2.setPrefWidth(140);
        bt3.setPrefWidth(100);
        Image btnImg=new Image("/sample/bt2image.png");
        ImageView imageView=new ImageView(btnImg);
        bt2.setGraphic(imageView);

        //bt1.setAlignment(Pos.TOP_LEFT);
       // bt2.setAlignment(Pos.TOP_CENTER);
        //bt3.setAlignment(Pos.CENTER_RIGHT);
        //此处bt被父类管理，对齐方式不管用
        //场景上部分
        HBox hbox1=new HBox();
        hbox1.setSpacing(10);
        hbox1.setMargin(bt1,new  Insets(10));
        hbox1.setMargin(bt3,new  Insets(10));
        hbox1.setPadding(new Insets(10,10,10,10));
        hbox1.getChildren().addAll(bt1,bt2,bt3);
      //  hbox1.setAlignment(Pos.BOTTOM_CENTER);
        //此处受父类管理，继续不管用

        //场景中间部分
        TextArea area= new TextArea();
        area.setPrefSize(200,250);
        area.setWrapText(true);
        area.setPrefRowCount(11);
        //Vbox布局
        VBox vbox=new VBox();
        vbox.getChildren().addAll(hbox1,area);

        //设置Flow布局
        FlowPane pane=new FlowPane();
        pane.getChildren().add(vbox);
        pane.setStyle("-fx-background-color: orangered");
        pane.setAlignment(Pos.TOP_CENTER);

        //添加场景
        Scene scene=new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("按钮举例");
        primaryStage.setWidth(600);
        primaryStage.setHeight(400);
        primaryStage.show();

        //添加事件
        bt1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            pane.setStyle("-fx-background-color: aqua");
            area.appendText(new SimpleDateFormat("yyyy:hh:mm:ss").format(new Date())+"改变窗体颜色\n");
            }
        });

       bt2.setOnMouseClicked(new EventHandler<MouseEvent>() {
           @Override
           public void handle(MouseEvent event) {
               if(event.getButton().equals(MouseButton.PRIMARY))
               {
                   if(event.getClickCount()==1){
                       bt1.setStyle("-fx-background-color: blue");
                       bt2.setStyle("-fx-background-color: blue");
                       bt3.setStyle("-fx-background-color: blue");
                       area.appendText(new SimpleDateFormat("yyyy:hh:mm:ss").format(new Date())+"改变按钮背景色"+"\n");
                   }  if(event.getClickCount()==2){
                       bt1.setStyle("-fx-background-color: purple");
                       bt2.setStyle("-fx-background-color: purple");
                       bt3.setStyle("-fx-background-color: purple");
                   area.appendText(new SimpleDateFormat("yyyy:hh:mm:ss").format(new Date())+"改变按钮背景色"+"\n");
                   }  if(event.getClickCount()==3){
                       bt1.setStyle("-fx-background-color: greenyellow");
                       bt2.setStyle("-fx-background-color: greenyellow");
                       bt3.setStyle("-fx-background-color: greenyellow");
                   area.appendText(new SimpleDateFormat("yyyy:hh:mm:ss").format(new Date())+"改变按钮背景色"+"\n");
                   }
               }
           }

       });

        bt3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.close();
            }
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}

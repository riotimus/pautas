/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pautas;
import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
//from  w  ww  . j  a  v a  2s  .co  m
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextArea;
/**
 *
 * @author JOHNJAIRO
 */
public class NewClass {
   
  public static void main(String... args) {
    JFileChooser fc = new JFileChooser();
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JTextArea tarea = new JTextArea(10, 10);

    JButton readButton = new JButton("OPEN FILE");
    readButton.addActionListener(ev -> {
      int returnVal = fc.showOpenDialog(frame);
      if (returnVal == JFileChooser.APPROVE_OPTION) {
        File file = fc.getSelectedFile();
        
        try {
          BufferedReader input = new BufferedReader(new InputStreamReader(
              new FileInputStream("l0_1.txt")));
          tarea.read(input, "READING FILE :-)");
        } catch (Exception e) {
          e.printStackTrace();
        }
      } else {
        System.out.println("Operation is CANCELLED :(");
      }
    });

    frame.getContentPane().add(tarea, BorderLayout.CENTER);
    frame.getContentPane().add(readButton, BorderLayout.PAGE_END);
    frame.pack();
    frame.setVisible(true);
  }
}
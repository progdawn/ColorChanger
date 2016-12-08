/*
 * Dawn Myers
 * ITDEV 140 Mequon 2016
 * Week 11, Activity 5
 */
package colorchanger;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.lang.reflect.Field;

/**
 *
 * @author Dawn
 */
public class ColorChangeFrame extends JFrame {
    
   private static final int FRAME_WIDTH = 300;
   private static final int FRAME_HEIGHT = 400;
   private JPanel colorPanel;
   private JButton redButton;
   private JButton greenButton;
   private JButton blueButton;    
   
   public ColorChangeFrame()
   {
       colorPanel = new JPanel();
       
       add(colorPanel, BorderLayout.CENTER);
       createControlPanel();
       //setSampleColor();
       setSize(FRAME_WIDTH, FRAME_HEIGHT);
       
   }
   
   class ColorListener implements ActionListener
   {
       public void actionPerformed(ActionEvent event)
       {
           String colorString = event.getActionCommand();
           colorPanel.setBackground(stringToColor(colorString));          
       }
   }
   
   public void createControlPanel()
   {
       ActionListener listener = new ColorListener();
       
       redButton = new JButton("Red");
       redButton.addActionListener(listener);
       redButton.setActionCommand("red");
       
       greenButton = new JButton("Green");
       greenButton.addActionListener(listener);
       greenButton.setActionCommand("green");
       
       blueButton = new JButton("Blue");
       blueButton.addActionListener(listener);   
       blueButton.setActionCommand("blue");
       
       JPanel controlPanel = new JPanel();
       
       controlPanel.add(redButton);
       controlPanel.add(greenButton);
       controlPanel.add(blueButton);
       
       add(controlPanel, BorderLayout.SOUTH);
   }
   
    public static Color stringToColor(final String value) {
    if (value == null) {
      return Color.black;
    }
    try {
      return Color.decode(value);
    } catch (NumberFormatException nfe) {
      try {
        final Field f = Color.class.getField(value);

        return (Color) f.get(null);
      } catch (Exception ce) {
        return Color.black;
      }
    }
  }
    
}

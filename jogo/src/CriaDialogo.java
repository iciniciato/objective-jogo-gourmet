import javax.swing.*;
import java.util.ArrayList;

public class CriaDialogo {
   public static void main(String[] args) {
       ScreenBuilder screenBuilder = new ScreenBuilder();

       JFrame itIsLasagnaScreen = screenBuilder.itIsLasagnaScreen(screenBuilder.imRightAgain(), null);
       JFrame itIsPastaScreen = screenBuilder.itIsPastaScreen(itIsLasagnaScreen, null);

       JFrame thinkInAPlateFrame = screenBuilder.thinkInAPlateScreen(itIsPastaScreen);

       thinkInAPlateFrame.setVisible(true);
  }

}

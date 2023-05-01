import javax.swing.*;

public class CriaDialogo {

   public static void main(String[] args) {
       ScreenBuilder screenBuilder = new ScreenBuilder();

       JFrame imRightAgainScreen = screenBuilder.imRightAgain();

       JFrame whatDoYouThoughtScreen = screenBuilder.whatDoYouThought();
       JFrame itIsChocolateCakeScreen = screenBuilder.doYouThoughtInThisPlate(imRightAgainScreen, whatDoYouThoughtScreen);
       JFrame itIsLasagnaScreen = screenBuilder.itIsLasagnaScreen(imRightAgainScreen, whatDoYouThoughtScreen);
       JFrame itIsPastaScreen = screenBuilder.itIsPastaScreen(itIsLasagnaScreen, itIsChocolateCakeScreen);

       JFrame thinkInAPlateFrame = screenBuilder.thinkInAPlateScreen(itIsPastaScreen);

       thinkInAPlateFrame.setVisible(true);
  }

}


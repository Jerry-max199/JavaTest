import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.security.Key;


public class AutoBoom {
    public static void main(String [] args){
        try {
            String sentence="你好";//定义要发送的内容
            Robot robot=new Robot();//创建Robot对象
           robot.delay(3000);//延迟三秒，为打开窗口预留时间
            Clipboard clipboard=Toolkit.getDefaultToolkit().getSystemClipboard();
            String[] authors=sentence.split("[,]");//字符串分割
            for (int j=0;j<50;j++) {//循环此时
                for (int i = 0; i<authors.length; i++) {
                  //  String sentencet = authors[i];
                    Transferable transferable=new StringSelection(sentence);
                    clipboard.setContents(transferable,null);
                    //按下control，完成粘贴功能
                    robot.keyPress(KeyEvent.VK_CONTROL);
                    robot.keyPress(KeyEvent.VK_V);
                    robot.keyRelease(KeyEvent.VK_CONTROL);
                    robot.delay(500);//延迟一秒发送
                    robot.keyPress(KeyEvent.VK_ENTER);
                }
            }
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}



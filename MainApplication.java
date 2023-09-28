import javax.swing.JFrame;

class MainApplication{
    public static void main(String[] args) {
        JFrame frame = new JFrame("First Look To Java Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        PannelControll panel = new PannelControll();
        frame.setPreferredSize(panel.getPreferredSize());
        frame.setSize(panel.getPreferredSize());
        frame.add(panel);
        frame.setResizable(true);
        frame.setVisible(true);
        panel.startGameThread();
    }
}
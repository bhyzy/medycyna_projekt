/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package heartdoctor.gui_controllers;

import heartdoctor.GUI.DiagnosisPanel;
import heartdoctor.GUI.LeftPanel;
import heartdoctor.GUI.MainFrame;
import heartdoctor.GUI.MainPanel;
import heartdoctor.GUI.StatusPanel;
import javax.swing.JPanel;

/**
 * klasa dostarczajaca strategie dla widokow gui
 * @author Qba
 */
public class DoctorGuiController extends GuiController {


    public DoctorGuiController(MainFrame frame) {
        this.frame = frame;
    }

    @Override
    public void setStartingView() {
        mainPanel = new MainPanel();
        frame.remove(frame.getPanel());
        prepareLeftPanel();
        
        mainPanel.setContentPanel(new DiagnosisPanel(this));
        
        mainPanel.setBounds(0, 0, MainFrame.WINDOW_WIDTH, MainFrame.WINDOW_HEIGHT - StatusPanel.PANEL_HEIGHT);

        frame.add(mainPanel);
        frame.repaint();
    }

    @Override
    public void prepareLeftPanel() {
        lp = new LeftPanel(this);
        lp.getSearchPatientButton().setEnabled(true);
        lp.learnButton.setEnabled(false);
        lp.statisticsButton.setEnabled(false);
        lp.validateButton.setEnabled(true);
        mainPanel.setLeftPanel(lp);

    }
}

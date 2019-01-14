/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class WindowEventSample extends JFrame implements WindowListener, WindowFocusListener, WindowStateListener {

    WindowEventSample() {
        setSize(300, 300);
        setVisible(true);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(this);
        addWindowFocusListener(this);
        addWindowStateListener(this);
    }

    public static void main(String[] args) {
        new WindowEventSample();
    }

    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("Window opened");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("Window closing...");
        if(JOptionPane.showConfirmDialog(rootPane,"Confirm", "Are you sure to close?", JOptionPane.OK_CANCEL_OPTION)==0)
        dispose();
    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.out.println("Window closed");
    }

    @Override
    public void windowIconified(WindowEvent e) {
        System.out.println("Window iconified");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        System.out.println("Window deiconified");
    }

    @Override
    public void windowActivated(WindowEvent e) {
        System.out.println("Window activated");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        System.out.println("Window deactivated");
    }

    @Override
    public void windowGainedFocus(WindowEvent e) {
        System.out.println("Window gained focus");
    }

    @Override
    public void windowLostFocus(WindowEvent e) {
        System.out.println("Window lost focus");
    }

    @Override
    public void windowStateChanged(WindowEvent e) {
        System.out.println("Window state changed");
    }
}

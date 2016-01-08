package com.studiohartman.jamepad;

public class Main {
    public static void main (String[] args) throws Exception {
        ControllerManager manager = new ControllerManager();
        manager.initSDLGamepad("gamecontrollerdb.txt");

        System.out.println("SDL JNI Test (Number of connected controllers): " + manager.getNumControllers());

        Controller p1 = manager.getControllers()[0];
        System.out.println(p1 + "\n");

        while (true) {
            Thread.sleep(1000);

            for(ControllerButton button: ControllerButton.values()) {
                System.out.println(button.toString() + " pressed? " + (p1.getButtonState(button) ? "YES" : "NO"));
            }
            for(ControllerAxis axis: ControllerAxis.values()) {
                System.out.println(axis.toString() + " state: ? " + p1.getAxisState(axis));
            }
            System.out.println();
        }
    }
}
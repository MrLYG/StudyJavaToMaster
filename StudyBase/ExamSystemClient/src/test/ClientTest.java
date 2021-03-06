package test;

import client.ClientInitClose;
import client.ClientView;

import java.io.IOException;

public class ClientTest {
    public static void main(String[] args) {
        ClientInitClose cic = null;
        ClientView cv = null;
        try {
            cic = new ClientInitClose();
            cic.clientInit();

            cv = new ClientView(cic);
            cv.clientMainPage();



        } catch (IOException | InterruptedException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                cic.clientClose();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

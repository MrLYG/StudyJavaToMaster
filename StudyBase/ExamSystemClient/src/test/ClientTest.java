package test;

import client.ClientInitClose;
import client.ClientView;

import java.io.IOException;

public class ClientTest {
    public static void main(String[] args) {
        ClientInitClose cis = null;
        ClientView cv = null;
        try {
            cis = new ClientInitClose();
            cis.clientInit();

            cv = new ClientView();
            cv.clientMainPage();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                cis.clientClose();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

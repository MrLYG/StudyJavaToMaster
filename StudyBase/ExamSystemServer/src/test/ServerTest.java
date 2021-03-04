package test;

import server.ServerInitClose;

import java.io.IOException;

public class ServerTest {
    public static void main(String[] args) {
        ServerInitClose sic = null;
        try {
            sic = new ServerInitClose();
            sic.serverInit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                sic.serverClose();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

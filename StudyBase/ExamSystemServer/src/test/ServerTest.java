package test;

import server.ServerDao;
import server.ServerInitClose;
import server.ServerView;

import java.io.IOException;

public class ServerTest {
    public static void main(String[] args) {
        ServerInitClose sic = null;
        ServerDao sd = null;
        try {
            sic = new ServerInitClose();
            sic.serverInit();

            sd = new ServerDao();

            ServerView sv = new ServerView(sic,sd);
            sv.serverReceive();
        } catch (IOException | ClassNotFoundException e) {
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

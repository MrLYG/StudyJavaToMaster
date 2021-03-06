package test;

import dao.QuestionDao;
import dao.ServerDao;
import server.ServerInitClose;
import server.ServerView;

import java.io.IOException;

public class ServerTest {
    public static void main(String[] args) {
        ServerInitClose sic = null;
        ServerDao sd = null;
        QuestionDao qd;
        try {
            sic = new ServerInitClose();
            sic.serverInit();

            sd = new ServerDao();
            qd = new QuestionDao();
            ServerView sv = new ServerView(sic,sd,qd);
            sv.serverReceive();



        } catch (IOException | ClassNotFoundException | InterruptedException e) {
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

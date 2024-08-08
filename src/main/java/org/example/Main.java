package org.example;
import org.example.db.DataBase;
import org.example.views.Authorization;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        DataBase main = new DataBase();
        Authorization authorization = new Authorization();
        authorization.authorization(main);

    }
}

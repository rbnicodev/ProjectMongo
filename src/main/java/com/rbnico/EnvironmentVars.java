package com.rbnico;

import com.mongodb.ConnectionString;

public class EnvironmentVars
{
    public static ConnectionString url = new ConnectionString("mongodb://localhost:27017");
    public static String stringDb = "acceso_a_datos";
}

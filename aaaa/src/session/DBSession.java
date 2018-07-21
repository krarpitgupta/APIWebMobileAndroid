package session;

import database.DBConnection;

public class DBSession {

	private static DBConnection connection = null;

	public static void setDBSession(DBConnection con) {
		connection = con;
	}

	public static DBConnection getLastDBSession() {
		return connection;
	}
}

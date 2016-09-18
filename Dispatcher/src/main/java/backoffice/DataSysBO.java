package backoffice;

import middleware.grupo01.datasys.DataSysPersistor;

public class DataSysBO {

	public void receive(String message) {
		System.out.println("Realizando comunicacion con DataSys...");
		DataSysPersistor pers = new DataSysPersistor();
		pers.persistOrder(message);
	}
	
	
}

package backoffice;

public class DataSysBO {

	private String prueba;

	public String getPrueba() {
		return prueba;
	}

	public void setPrueba(String prueba) {
		this.prueba = prueba;
	}
	

	public void onMessage(String message) {
		//try {
			//@SuppressWarnings(value="unused")
			//TextMessage msg = (TextMessage) message;
			System.out.println("DataSysBO Consumed message: " );
		/*} catch (JMSException e) {
			e.printStackTrace();
		}*/
	}
	
	
}

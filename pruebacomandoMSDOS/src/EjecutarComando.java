import java.io.IOException;

public class EjecutarComando {

	public static void main(String[] args) throws IOException, InterruptedException {

		// Coger un archivo .sql(backup) y convertirlo en una BBDD

		String dbUserName = "root";
		String dbPassword = "";
		String source = "C:/backups/UF1466_2.sql";
		String[] restoreCmd = new String[] { "mysql ", "--user=" + dbUserName, "--password=" + dbPassword, "-e",
				"source " + source };

		Process runProcess = Runtime.getRuntime().exec(restoreCmd);
		int processComplete = runProcess.waitFor();

		if (processComplete == 0) {
			System.out.println("Todo correcto");
		} else {
			System.out.println("Ha habido algún error");
		}
	}

}

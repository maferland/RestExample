package maferland.rest;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws Exception {
		ResourceConfig config = new ResourceConfig();
		config.packages("maferland.rest");
		ServletHolder servlet = new ServletHolder(new ServletContainer(config));

		Server server = new Server(8080);
		ServletContextHandler context = new ServletContextHandler(server, "/*");
		context.addServlet(servlet, "/*");

		try {
			server.start();
			server.join();
		} finally

		{
			server.destroy();
		}
	}
}

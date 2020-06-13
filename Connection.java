package chat;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

public class Connection extends Thread {

	ObjectInputStream in;
	ObjectOutputStream out ;
	Socket clientSocket;
	boolean closed = false;
	static ArrayList<Connection> connections = new ArrayList<Connection>();
	static ArrayList<String> members = new ArrayList<String>();
	static ArrayList<requests> requests = new ArrayList<requests>();
	String client = "";
	String name = "";
	String line = "";
	boolean bool;

	public Connection(Socket clientSocket, ArrayList<Connection> connections) {

		this.clientSocket = clientSocket;
		this.connections = connections;

	}

	public void copy(String url, String z) throws IOException {
		switch (url) {
		case "C:/Users/nadeen/Desktop/docroot/text1.txt":
			Path source = Paths
					.get("C:/Users/nadeen/Desktop/docroot/text1.txt");
			File newPath = new File(z + "/TurkeyRecipe");
			newPath.mkdirs();
			Path targetDir = newPath.toPath();

			Files.copy(source, targetDir, StandardCopyOption.REPLACE_EXISTING);

			;
			break;
		case "C:/Users/nadeen/Desktop/docroot/text2.txt":
			source = Paths.get("C:/Users/nadeen/Desktop/docroot/text2.txt");
			newPath = new File(z + "/BrowniesRecipe");
			newPath.mkdirs();
			targetDir = newPath.toPath();

			Files.copy(source, targetDir, StandardCopyOption.REPLACE_EXISTING);
			;
			break;
		case "C:/Users/nadeen/Desktop/docroot/text3.txt":
			source = Paths.get("C:/Users/nadeen/Desktop/docroot/text3.txt");
			newPath = new File(z + "/PastaRecipe");
			newPath.mkdirs();
			targetDir = newPath.toPath();

			Files.copy(source, targetDir, StandardCopyOption.REPLACE_EXISTING);
			;
			break;
		case "C:/Users/nadeen/Desktop/docroot/text4.txt":
			source = Paths.get("C:/Users/nadeen/Desktop/docroot/text4.txt");
			newPath = new File(z + "/CheesCakeRecipe");
			newPath.mkdirs();
			targetDir = newPath.toPath();

			Files.copy(source, targetDir, StandardCopyOption.REPLACE_EXISTING);
			;
			break;
		case "C:/Users/nadeen/Desktop/docroot/png1.png":
			source = Paths.get("C:/Users/nadeen/Desktop/docroot/png1.png");
			newPath = new File(z + "/SullySticker");
			newPath.mkdirs();
			targetDir = newPath.toPath();

			Files.copy(source, targetDir, StandardCopyOption.REPLACE_EXISTING);

			;
			break;
		case "C:/Users/nadeen/Desktop/docroot/png2.png":
			source = Paths.get("C:/Users/nadeen/Desktop/docroot/png2.png");
			newPath = new File(z + "/MonstersSticker");
			newPath.mkdirs();
			targetDir = newPath.toPath();

			Files.copy(source, targetDir, StandardCopyOption.REPLACE_EXISTING);
			;
			break;
		case "C:/Users/nadeen/Desktop/docroot/wall1.jpg":
			source = Paths.get("C:/Users/nadeen/Desktop/docroot/wall1.jpg");
			newPath = new File(z + "/WallPaper");
			newPath.mkdirs();
			targetDir = newPath.toPath();

			Files.copy(source, targetDir, StandardCopyOption.REPLACE_EXISTING);
			;
			break;
		case "C:/Users/nadeen/Desktop/docroot/wall2.jpg":
			source = Paths.get("C:/Users/nadeen/Desktop/docroot/wall2.jpg");
			newPath = new File(z + "/WallPaper2");
			newPath.mkdirs();
			targetDir = newPath.toPath();

			Files.copy(source, targetDir, StandardCopyOption.REPLACE_EXISTING);
			;
			break;
		case "C:/Users/nadeen/Desktop/docroot/mp4One.mp4":
			source = Paths.get("C:/Users/nadeen/Desktop/docroot/mp4One.mp4");
			newPath = new File(z + "/Tutorial1");
			newPath.mkdirs();
			targetDir = newPath.toPath();

			Files.copy(source, targetDir, StandardCopyOption.REPLACE_EXISTING);
			;
			;
			break;
		case "C:/Users/nadeen/Desktop/docroot/mp4Two.mp4":
			source = Paths.get("C:/Users/nadeen/Desktop/docroot/mp4Two.mp4");
			newPath = new File(z + "/Tutorial2");
			newPath.mkdirs();
			targetDir = newPath.toPath();

			Files.copy(source, targetDir, StandardCopyOption.REPLACE_EXISTING);
			;

			;
			break;

		}

	}

	public void response(String url, String z) throws IOException {

		switch (url) {
		case "C:/Users/nadeen/Desktop/docroot/text1.txt":
			HTTPRes response = new HTTPRes("200 OK", "HTTP 1.1", "txt",
					"Keep alive");
			String v = z + "/TurkeyRecipeHTTPResponse.txt";
			PrintWriter writer = new PrintWriter(v, "UTF-8");
			writer.println("Status " + response.Status + " Version "
					+ response.Version);
			writer.println("Timestamp " + response.Timestamp);
			writer.println("Format " + response.Format);
			writer.println("Connection " + response.Connection);
			writer.close();
			// send response to client through socket 
			out = new ObjectOutputStream(clientSocket.getOutputStream());
			out.flush();
			out.writeObject(response);
			;
			break;
		case "C:/Users/nadeen/Desktop/docroot/text2.txt":
			response = new HTTPRes("200 OK", "HTTP 1.1", "txt", "Keep alive");
			v = z + "/BrowniesRecipeHTTPResponse.txt";
			writer = new PrintWriter(v, "UTF-8");
			writer.println("Status " + response.Status + " Version "
					+ response.Version);
			writer.println("Timestamp " + response.Timestamp);
			writer.println("Format " + response.Format);
			writer.println("Connection " + response.Connection);
			writer.close();
			// send response to client through socket 
			out = new ObjectOutputStream(clientSocket.getOutputStream());
			out.flush();
			out.writeObject(response);
			;
			break;
		case "C:/Users/nadeen/Desktop/docroot/text3.txt":
			response = new HTTPRes("200 OK", "HTTP 1.1", "txt", "Keep alive");
			v = z + "/PastaRecipeHTTPResponse.txt";
			writer = new PrintWriter(v, "UTF-8");
			writer.println("Status " + response.Status + " Version "
					+ response.Version);
			writer.println("Timestamp " + response.Timestamp);
			writer.println("Format " + response.Format);
			writer.println("Connection " + response.Connection);
			writer.close();
			// send response to client through socket 
			out = new ObjectOutputStream(clientSocket.getOutputStream());
			out.flush();
			out.writeObject(response);
			;
			break;
		case "C:/Users/nadeen/Desktop/docroot/text4.txt":
			response = new HTTPRes("200 OK", "HTTP 1.1", "txt", "Keep alive");
			v = z + "/CheeseCakeHTTPResponse.txt";
			writer = new PrintWriter(v, "UTF-8");
			writer.println("Status " + response.Status + " Version "
					+ response.Version);
			writer.println("Timestamp " + response.Timestamp);
			writer.println("Format " + response.Format);
			writer.println("Connection " + response.Connection);
			writer.close();
			// send response to client through socket 
			out = new ObjectOutputStream(clientSocket.getOutputStream());
			out.flush();
			out.writeObject(response);
			
			;
			break;
		case "C:/Users/nadeen/Desktop/docroot/png1.png":

			response = new HTTPRes("200 OK", "HTTP 1.1", "png", "Keep alive");
			v = z + "/MobstersInc1HTTPResponse.txt";
			writer = new PrintWriter(v, "UTF-8");
			writer.println("Status " + response.Status + " Version "
					+ response.Version);
			writer.println("Timestamp " + response.Timestamp);
			writer.println("Format " + response.Format);
			writer.println("Connection " + response.Connection);
			writer.close();
			// send response to client through socket 
			out = new ObjectOutputStream(clientSocket.getOutputStream());
			out.flush();
			out.writeObject(response);
			;
			break;
		case "C:/Users/nadeen/Desktop/docroot/png2.png":
			response = new HTTPRes("200 OK", "HTTP 1.1", "png", "Keep alive");
			v = z + "/MobstersInc2HTTPResponse.txt";
			writer = new PrintWriter(v, "UTF-8");
			writer.println("Status " + response.Status + " Version "
					+ response.Version);
			writer.println("Timestamp " + response.Timestamp);
			writer.println("Format " + response.Format);
			writer.println("Connection " + response.Connection);
			writer.close();
			
			// send response to client through socket 
			out = new ObjectOutputStream(clientSocket.getOutputStream());
			out.flush();
			out.writeObject(response);
			;
			
			break;
		case "C:/Users/nadeen/Desktop/docroot/wall1.jpg":
			response = new HTTPRes("200 OK", "HTTP 1.1", "jpg", "Keep alive");
			v = z + "/WallPaper1HTTPResponse.txt";
			writer = new PrintWriter(v, "UTF-8");
			writer.println("Status " + response.Status + " Version "
					+ response.Version);
			writer.println("Timestamp " + response.Timestamp);
			writer.println("Format " + response.Format);
			writer.println("Connection " + response.Connection);
			writer.close();
			// send response to client through socket 
			out = new ObjectOutputStream(clientSocket.getOutputStream());
			out.flush();
			out.writeObject(response);
			;
			break;
		case "C:/Users/nadeen/Desktop/docroot/wall2.jpg":
			response = new HTTPRes("200 OK", "HTTP 1.1", "jpg", "Keep alive");
			v = z + "/WallPaper2HTTPResponse.txt";
			writer = new PrintWriter(v, "UTF-8");
			writer.println("Status " + response.Status + " Version "
					+ response.Version);
			writer.println("Timestamp " + response.Timestamp);
			writer.println("Format " + response.Format);
			writer.println("Connection " + response.Connection);
			writer.close();
			// send response to client through socket 
			out = new ObjectOutputStream(clientSocket.getOutputStream());
			out.flush();
			out.writeObject(response);
			;
			break;
		case "C:/Users/nadeen/Desktop/docroot/mp4One.mp4":
			response = new HTTPRes("200 OK", "HTTP 1.1", "mp4", "Keep alive");
			v = z + "/mp4OneHTTPResponse.txt";
			writer = new PrintWriter(v, "UTF-8");
			writer.println("Status " + response.Status + " Version "
					+ response.Version);
			writer.println("Timestamp " + response.Timestamp);
			writer.println("Format " + response.Format);
			writer.println("Connection " + response.Connection);
			writer.close();
			
			// send response to client through socket 
			out = new ObjectOutputStream(clientSocket.getOutputStream());
			out.flush();
			out.writeObject(response);
			;
			break;
		case "C:/Users/nadeen/Desktop/docroot/mp4Two.mp4":
			response = new HTTPRes("200 OK", "HTTP 1.1", "mp4", "Keep alive");
			v = z + "/mp4TwoHTTPResponse.txt";
			writer = new PrintWriter(v, "UTF-8");
			writer.println("Status " + response.Status + " Version "
					+ response.Version);
			writer.println("Timestamp " + response.Timestamp);
			writer.println("Format " + response.Format);
			writer.println("Connection " + response.Connection);
			writer.close();
			// send response to client through socket 
			out = new ObjectOutputStream(clientSocket.getOutputStream());
			out.flush();
			out.writeObject(response);
			;
			break;
		default : response = new HTTPRes("404 not found ", "HTTP 1.1", " jpg,png,txt,mp4", "Keep alive");
		v = z + "/404NotFound.txt";
		writer = new PrintWriter(v, "UTF-8");
		writer.println("Status " + response.Status + " Version "
				+ response.Version);
		writer.println("Timestamp " + response.Timestamp);
		writer.println("Format " + response.Format);
		writer.println("Connection " + response.Connection);
		writer.close();
		// send response to client through socket 
		out = new ObjectOutputStream(clientSocket.getOutputStream());
		out.flush();
		out.writeObject(response);

			;

		}

	}

	public void run() {

		try {
			
		out = new ObjectOutputStream(clientSocket.getOutputStream());
		Object n2 = "naadeen";
		out.writeObject(n2);

			members.add("Client" + members.size());
			int s = 0;

			while (!closed) {
				in = new ObjectInputStream(clientSocket.getInputStream());
				// user requests to close window
				// terminating thread
				
				HTTPReq n = (HTTPReq) in.readObject();
				
				String name = "Client ";
				for (int i = 0; i < connections.size(); i++) {
					if (connections.get(i) != null
							&& connections.get(i) == this) {
						name += i;
						s = i;
					}
				}
				name += " : ";

				requests m = new requests(name, n);
				requests.add(m);
				System.out.println(name + "\n");
				n.printReq();
				System.out.println("\n");
				// System.out.println("number of request in queue "
				// + requests.size());
				System.out.println("\n");
				String a = "Client" + s;
				String z = "C:/Users/nadeen/Desktop/" + a;
				File directory = new File(z);
				String url = n.URL;
				if (!directory.exists()) {
					directory.mkdir();
					copy(url, z);
					response(url, z);
					//remove request from queue
				} else {
					copy(url, z);
					response(url, z);
// remove request from queue
				}
				}
				
			
				

		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getClient() {
		return client;
	}

}
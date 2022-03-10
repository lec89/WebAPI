package ar.com.webapi.java.web.server.socket;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.OutputStream;

/**
 * Servidor TCP/IP
 */
public class Server{
	public static void main(String... args){
		System.out.println("Iniciando Servidor...");
		String mensaje="<h1>Servidor de Lucas!</h1>";
		mensaje=    "HTTP/1.1 200 OK\n"+
                    "Content-Length: "+mensaje.length()+"\n\n"
                    +mensaje;
		try ( ServerSocket ss=new ServerSocket(8081);){
			while(true){
				System.out.println("Esperando conexión de cliente");
				try( 	Socket so=ss.accept(); 
						OutputStream out=so.getOutputStream();
				){
					System.out.println("Se conecto: "+so.getInetAddress());
					out.write(mensaje.getBytes());
				} catch(Exception e){
					System.out.println(e);
				}
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
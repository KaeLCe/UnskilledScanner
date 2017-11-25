package unskilledscanner.ui;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Scanner;

import unskilledscanner.scanner.UnskilledScanner;

public class Interface {

	private Scanner reader;
	private UnskilledScanner scanner;
	
	public Interface(){
		this.reader = new Scanner(System.in);
		this.scanner = new UnskilledScanner();
	}
	
   /******************
	**     MENU     **
	******************/
	public void start() {
		System.out.println("**************************");
		System.out.println("**  Unskilled Scanner   **");
		System.out.println("**************************");
		System.out.println("MENU, select return liked");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("  Scann Local Network  #  Open Ports List  #  Port Streaming  #  TCP Try Out");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("|          1           |         2         |         3        |        4       |");
		System.out.println();
		System.out.print("Select you choice: ");
		int choice = Integer.parseInt(reader.nextLine());
		
		if(choice == 1) {
			scanLocalNetwork();
		}
		
		if(choice == 2) {
			openPortsList();
		}
		
	}
	
	
	public void scanLocalNetwork() {
		Boolean ipFormat = true;
		String address = "";
		while(ipFormat) {
			System.out.print("IP address target: ");
			address = reader.nextLine();
			ipFormat = checkIPFormat(address);
		}
		this.scanner.scanLocalNetwork(address);
	}
	
   /********************************
	**  Liste les ports ouverts   **
	**  sur la machine cibl�e     **
	********************************/
	public void openPortsList() {
		Boolean ipFormat = true;
		while(ipFormat) {
			System.out.print("IP address target: ");
			String address = reader.nextLine();
			ipFormat = checkIPFormat(address);
		}
		String address = reader.nextLine();
		System.out.print("Begin at port: ");
		int portDeb = Integer.parseInt(reader.nextLine());
		System.out.print("End at port: ");
		int portFin = Integer.parseInt(reader.nextLine());
		this.scanner.scanPorts(address, portDeb, portFin);
	}
	
	
   /**************************
	**  V�rifie le format   **
	**  de l'adresse IP     **
	**************************/
    public Boolean checkIPFormat(String iproot) {
    	String nipTemp = iproot.replace('.', '-');
        String[] nip = nipTemp.split("-");		
        if (nip.length != 4) {
            System.out.println("Base Ip incorrecte !!! exemple 192.168.1.1");
            return true;
        }else {
        	return false;
        }
    }
	
}

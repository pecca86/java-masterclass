package networking;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UdpServer {

    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(5000);

            while (true) {
                byte[] buffer = new byte[50];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                System.out.println("Text received is: \"" + new String(buffer, 0, packet.getLength()) + "\"");

                String returnMsg = "server says: " +  new String(buffer, 0, packet.getLength());
                byte[] buf = returnMsg.getBytes();
                InetAddress returnAddress = packet.getAddress();
                int returnPort = packet.getPort();
                packet = new DatagramPacket(buf, buf.length, returnAddress, returnPort);
                socket.send(packet);
            }

        } catch (SocketException ex) {
            System.out.println("Socket is shit: " + ex.getMessage());
        } catch (IOException e) {
            System.out.println("IO is shit: " + e.getMessage());
        }
    }

}

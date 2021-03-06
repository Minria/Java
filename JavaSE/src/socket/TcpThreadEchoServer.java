package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpThreadEchoServer {
    private ServerSocket socket=null;
    public TcpThreadEchoServer(int num) throws IOException {
        socket=new ServerSocket(num);
    }
    public void start() throws IOException {
        while (true){
            Socket clientSocket=socket.accept();
            Thread t=new Thread(){
                @Override
                public void run() {
                    processConnection(clientSocket);
                }
            };
            t.start();
        }
    }
    public void processConnection(Socket clientSocket){
        System.out.printf("[%s:%d] 客户端上线\n", clientSocket.getInetAddress().toString(),
                clientSocket.getPort());
        try(BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
        ) {
            while(true){
                String request=bufferedReader.readLine();
                String response=process(request);
                bufferedWriter.write(response+"\n");
                bufferedWriter.flush();
                System.out.printf("[%s:%d] req: %s; resp: %s\n", clientSocket.getInetAddress().toString(),
                        clientSocket.getPort(), request, response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String process(String request){
        return request;
    }

    public static void main(String[] args) throws IOException {
        TcpThreadEchoServer tcpThreadEchoServer=new TcpThreadEchoServer(1234);
        tcpThreadEchoServer.start();
    }
}

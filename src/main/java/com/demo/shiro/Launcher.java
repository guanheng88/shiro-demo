package com.demo.shiro;

import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

import com.demo.shiro.common.utils.Configuration;
import com.demo.shiro.common.utils.PropertiesNames;

public class Launcher {

    private static final String START_COMMAND = "start";
    private static final String STOP_COMMAND = "stop";

    public static void main(String[] args) {
        String command;
        if (args.length > 0) {
            command = args[0].toLowerCase();
        }
        else {
            command = START_COMMAND;
        }
        if (command.equals(START_COMMAND)) {
            start();
        }
        else if (command.equals(STOP_COMMAND)) {
            stop();
        }
        else {
            System.err.println("Unknown command: " + command);
            return;
        }
    }

    public static void start() {
        System.out.println("The server is starting ...");
        try {
            Configuration.loadLog4j("./conf/log4j.xml");
            Configuration.loadProperties("./conf/jetty.properties");
        }
        catch (Exception e) {
            e.printStackTrace();
            return;
        }

        startJetty();
    }

    public static void stop() {
        System.out.println("The server is stopping ...");
        try {
            Configuration.loadLog4j("./conf/log4j.xml");
            Configuration.loadProperties("./conf/jetty.properties");
            int stopPort = Configuration.getInteger(PropertiesNames.SERVER_PORT_STOP);
            Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), stopPort);
            OutputStream out = socket.getOutputStream();
            out.write("\r\n".getBytes());
            out.flush();
            socket.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    private static void startJetty() {
        int httpPort = Configuration.getInteger(PropertiesNames.SERVER_PORT_HTTP);
        int stopPort = Configuration.getInteger(PropertiesNames.SERVER_PORT_STOP);

        JettyServer server = new JettyServer(httpPort, stopPort);

        try {
            int minThreads = Configuration.getInteger(PropertiesNames.SERVER_THREADS_MIN);
            server.setMinThreads(minThreads);

            int maxThreads = Configuration.getInteger(PropertiesNames.SERVER_THREADS_MAX);
            server.setMaxThreads(maxThreads);

            int acceptQueueSize = Configuration.getInteger(PropertiesNames.SERVER_ACCEPT_QUEUE_SIZE);
            server.setAcceptQueueSize(acceptQueueSize);

            int acceptors = Configuration.getInteger(PropertiesNames.SERVER_ACCEPTORS);
            server.setAcceptors(acceptors);

            int maxIdleTime = Configuration.getInteger(PropertiesNames.SERVER_MAX_IDLE_TIME);
            server.setMaxIdleTime(maxIdleTime);
        }
        catch (Exception e) {
        }

        server.start();
    }
}

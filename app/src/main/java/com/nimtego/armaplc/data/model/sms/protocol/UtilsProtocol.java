package com.nimtego.armaplc.data.model.sms.protocol;

import java.util.ArrayList;
import java.util.List;

//todo This from old project need refactoring
public class UtilsProtocol {
    public static String decryptedMessage(String string) {
        return null;
    }

    public static String CRC16(String s) {
        CRC16 crc = new CRC16();
        crc.update(Integer.parseInt(s, 16));
        System.out.println(Integer.toHexString((int) crc.getValue()));
        return Integer.toHexString((int) crc.getValue());
    }

    public static int[] hex2Byte(String str) {
        int[] bytes = new int[(str.length() / 2)];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = Integer.parseInt(str.substring(i * 2, (i * 2) + 2), 16);
        }
        return bytes;
    }

    public static String byteArrayToString(int[] array) {
        StringBuilder builder = new StringBuilder();
        for (int valueOf : array) {
            builder.append(String.valueOf(valueOf));
        }
        return builder.toString();
    }

    public static String byte2hex(byte[] b) {
        String hs = "";
        String stmp = "";
        for (byte b1 : b) {
            stmp = Integer.toHexString(b1 & 255);
            StringBuilder sb = new StringBuilder(hs);
            if (stmp.length() == 1) {
                sb.append("0").append(stmp);
            } else {
                sb.append(stmp);
            }
            hs = sb.toString();
//            if (n < b.length - 1) {
//                hs = new StringBuilder(hs).toString();
//            }
        }
        return hs;
    }

    public static String HexToBinary(String Hex) {
        try {
            return Integer.toBinaryString(Integer.parseInt(Hex, 16));
        } catch (RuntimeException ex) {
            ex.printStackTrace();
            return "";
        }
    }

    public static List<Short> getErrorIndicatior(String statusIndicator) {
        List<Short> list = new ArrayList();
        char[] array = statusIndicator.toCharArray();
        for (short i = (short) 0; i < array.length - 1; i = (short) (i + 1)) {
            if (array[i] == '0') {
                list.add(new Short(i));
            }
        }
        return list;
    }
}

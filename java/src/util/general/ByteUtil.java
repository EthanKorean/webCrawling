package util.general;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ByteUtil {

	public static byte[] toByte(int integer){
        ByteBuffer buffer = ByteBuffer.allocate(Integer.BYTES);
        buffer.putInt(integer);
        buffer.order(ByteOrder.BIG_ENDIAN);
        return buffer.array();
    }//byteArrayToInt

    public static byte[] toByte(float fl){
        ByteBuffer buffer = ByteBuffer.allocate(Float.BYTES);
        buffer.putFloat(fl);
        buffer.order(ByteOrder.BIG_ENDIAN);
        return buffer.array();
    }//byteArrayToInt
    
    public static byte[] toByte(double dble){
        ByteBuffer buffer = ByteBuffer.allocate(Double.BYTES);
        buffer.putDouble(dble);
        buffer.order(ByteOrder.BIG_ENDIAN);
        return buffer.array();
    }//byteArrayToInt
    
    public static byte[] toByte(char ch){
        ByteBuffer buffer = ByteBuffer.allocate(Character.BYTES);
        buffer.putChar(ch);
        buffer.order(ByteOrder.BIG_ENDIAN);
        return buffer.array();
    }//byteArrayToInt

    public static int byteArrayToInt(byte[] bytes, ByteOrder order){
        int size = Integer.BYTES;
        byte[] newBytes = new byte[size];
        change(size,newBytes,bytes);
        ByteBuffer buff=ByteBuffer.wrap(newBytes);
        buff.order(order);
        return buff.getInt();
    }//byteArrayToInt

    public static float byteArrayToFloat(byte[] bytes, ByteOrder order){
        int size = Float.BYTES;
        byte[] newBytes = new byte[size];
        change(size,newBytes,bytes);
        ByteBuffer buff=ByteBuffer.wrap(newBytes);
        buff.order(order);
        return buff.getFloat();
    }//byteArrayToFloat
    
    public static float byteArrayToDouble(byte[] bytes, ByteOrder order){
        int size = Double.BYTES;
        byte[] newBytes = new byte[size];
        change(size,newBytes,bytes);
        ByteBuffer buff=ByteBuffer.wrap(newBytes);
        buff.order(order);
        return buff.getFloat();
    }//byteArrayToFloat


    public static char byteArrayToChar(byte[] bytes, ByteOrder order){
        int size = Character.BYTES;
        byte[] newBytes = new byte[size];
        change(size,newBytes,bytes);
        ByteBuffer buff=ByteBuffer.wrap(newBytes);
        buff.order(order);
        return buff.getChar();
    }//byteArrayToChar
    
    public static short byteArrayToShort(byte[] bytes, ByteOrder order){
        int size = Character.BYTES;
        byte[] newBytes = new byte[size];
        change(size,newBytes,bytes);
        ByteBuffer buff=ByteBuffer.wrap(newBytes);
        buff.order(order);
        return buff.getShort();
    }//byteArrayToShort
    
    private static void change(int size,byte[] newBytes,byte[] bytes) {
    	for(int i =0 ; i <size;i++){
            if(i + bytes.length < size ){
                newBytes[i] = (byte) 0x00;
            } else {
                newBytes[i] = bytes[i + bytes.length - size];
            }//end else
        }//end for
    }//change

}//class

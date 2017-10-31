/**
 * Created by Chiru on Jan 22, 2017
 */
package extra;

import java.io.*;

public class ObjSerialization implements Serializable {

    public class Box implements Serializable {

        private int width;
        private int height;

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

    }

    public static void main(String[] args) {

        FileOutputStream fileOutputStream = null;
        FileInputStream fileInputStream = null;

        ObjectOutputStream objectOutputStream;
        ObjectInputStream objectInputStream;

        Box myBox1 = new ObjSerialization().new Box();
        myBox1.setHeight(20);
        myBox1.setWidth(10);

        Box myBox2 = new ObjSerialization().new Box();
        myBox2.setHeight(40);
        myBox2.setWidth(50);

        // ----Serialization---- //

        try {
            fileOutputStream = new FileOutputStream("mySerialized.ser");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(myBox1);
            objectOutputStream.writeObject(myBox2);

            objectOutputStream.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // ----Deserialization---- //

        try {
            fileInputStream = new FileInputStream("mySerialized.ser");
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }

        try {
            objectInputStream = new ObjectInputStream(fileInputStream);
            Object one = objectInputStream.readObject();
            Object two = objectInputStream.readObject();

            // casting the objects
            Box box1 = (Box) one;
            Box box2 = (Box) two;

            // printing deserialized values
            System.out.println("Box 1 values: " + box1.getHeight() + " , " + box1.getWidth());
            System.out.println("Box 2 values: " + box2.getHeight() + " , " + box2.getWidth());

        } catch (Exception e) {

            e.printStackTrace();
        }

    }

}

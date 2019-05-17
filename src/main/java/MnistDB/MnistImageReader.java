package MnistDB;

import MnistDB.Model.RepositoryMnist;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class MnistImageReader implements Iterator {

  private int magicNumber;
  private int qntyOfData;
  private int qntyRows;
  private int qntyColumns;
  private String fileName;
  private ArrayList<Integer> mnistData;
  private ListIterator imagesIterator;

  public MnistImageReader(RepositoryMnist db, String fileName) {
    this.fileName = fileName;
    this.mnistData = new ArrayList<Integer>();
    ReadFile();
    imagesIterator = mnistData.listIterator();
  }

  private void ReadFile(){
    try(FileInputStream fin=new FileInputStream(fileName)){
      byte[] b = new byte[4];
      fin.read(b);
      magicNumber= toInt(b);
      fin.read(b);
      qntyOfData = toInt(b);
      fin.read(b);
      qntyRows = toInt(b);
      fin.read(b);
      qntyColumns = toInt(b);
      int count = 0;
      int i = -1;
     while ((i=fin.read())!=-1){
       mnistData.add(i= i & 0xff);
     }
    }
    catch (IOException ex){
      System.out.println(ex.getMessage());
    }
  }


  private int toInt(byte[] b)
  {
    int value= 0;
    for (byte b1 : b) value = (value << 8) | b1;
    if (value<1) {value*=10;}
    return value;

  }

  public void getDataValues(){
    System.out.println("Magic number: "+magicNumber);
    System.out.println("Rows: "+qntyRows);
    System.out.println("Columns: "+qntyColumns);
    System.out.println("Quantity: " + qntyOfData);
  }

  @Override
  public boolean hasNext() {
    return imagesIterator.hasNext();
  }

  @Override
  public Object next() {
    int [] values = new int [784];
      for (int i = 0; i < 784; i++) {values[i] = (Integer) imagesIterator.next();}
    return values;
   }
}

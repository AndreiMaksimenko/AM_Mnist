package MnistDB.Model;

import java.util.ArrayList;
import java.util.Iterator;

public class RepositoryMnist implements Iterator {
  ArrayList<MnistItem> data;
  Iterator dataIterator;

  public RepositoryMnist() {
    data = new ArrayList<>();
    dataIterator = data.listIterator();
  }

  public void newItemWithValue(int value) {
    MnistItem item = new MnistItem();
    item.setValue(value);
    data.add(item);
  }

  public void newItemWithImage(int[] value) {
    MnistItem item = new MnistItem();
    item.setImage(value);
    data.add(item);
  }

  public void addValue(int itemNumber, int value) {
    try {
      data.get(itemNumber).setValue(value);
    } catch (Exception ex) {
      System.out.println("No element: " + itemNumber);
    }
  }

  public void addImage(int itemNumber, int[] image) {
    try {
      data.get(itemNumber).setImage(image);
    } catch (Exception ex) {
      System.out.println("No element: " + itemNumber);
    }
  }

  public int[] getImage(int itemNumber) {
    try {
      return data.get(itemNumber).getImage();
    } catch (Exception ex) {
      System.out.println("No element: " + itemNumber);
      return null;
    }
  }

  public int getValue(int itemNumber) {
    try {
      return data.get(itemNumber).getValue();
    } catch (Exception ex) {
      System.out.println("No element: " + itemNumber);
      return 0;
    }
  }

  public void printImage(int number) {
    int [] values = getImage(number);
    int counter = 0;
    for (int i = 0; i < 28; i++) {
      StringBuilder str = new StringBuilder();
      String simbl;
      for (int j = 0; j < 28; j++) {
        {
          int value = values[counter];
          if (value == 0) {
            simbl = " ";
          } else if (value > 200) {
            simbl = "E";
          } else if (value > 100) {
            simbl = "I";
          } else {
            simbl = "|";
          }
          str.append(simbl).append(" ");
          counter++;
        }
      }
      System.out.println(str);
    }
    System.out.print("\n");

    System.out.println("Label: " + getValue(number));
  }

  public int getSize(){
    return data.size();
  }

  public MnistItem getItem(int index){
      return data.get(index);
  }

  @Override
  public boolean hasNext() {
    return dataIterator.hasNext();
  }

  @Override
  public Object next() {
    return dataIterator.next();
  }
}

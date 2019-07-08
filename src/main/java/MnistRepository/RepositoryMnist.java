package MnistRepository;

import java.util.ArrayList;
import java.util.Iterator;

public class RepositoryMnist implements Iterator {
  private ArrayList<MnistItem> data;
  private Iterator dataIterator;
  private MnistLabelReader labelReader;
  private MnistImageReader imageReader;

  public RepositoryMnist (String images, String labels){
    data = new ArrayList<>();
    dataIterator = data.listIterator();
    ReadImages(images);
    ReadLabels(labels);
  }


  private void ReadLabels(String labels){
    labelReader = new MnistLabelReader(labels);
    int counter = 0;
    while (labelReader.hasNext()){
      int value = (int) labelReader.next();
      try {
        data.get(counter).setValue(value);
      } catch (Exception ex) {
        System.out.println("No element: " + counter);
      }
      counter++;
    }}


  private void ReadImages(String images) {
    imageReader = new MnistImageReader(images);
    while (imageReader.hasNext()){
      double [] image = (double[])imageReader.next();
      MnistItem item = new MnistItem();
      item.setImage(image);
      data.add(item);
        }
     }


  public double[] getImage(int itemNumber) {
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
    double [] values = getImage(number);
    int counter = 0;
    for (int i = 0; i < 28; i++) {
      StringBuilder str = new StringBuilder();
      String simbl;
      for (int j = 0; j < 28; j++) {
        {
          double value = values[counter];
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

  public void getLabelsData()
  {
    labelReader.getDataValues();
  }
  public void getImagesData(){imageReader.getDataValues();}
  public int getSizeOfImage(){return imageReader.GetImageSize();}

  @Override
  public boolean hasNext() {
    return dataIterator.hasNext();
  }

  @Override
  public Object next() {
    return dataIterator.next();
  }
}

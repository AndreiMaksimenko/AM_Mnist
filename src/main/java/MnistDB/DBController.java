package MnistDB;

import MnistDB.Model.RepositoryMnist;

public class DBController {

  public static void addImages(RepositoryMnist db, MnistImageReader reader) {
    while (reader.hasNext()){
    int[] image = (int[]) reader.next();
    db.newItemWithImage(image);}
  }

  public static void addLabels(RepositoryMnist db, MnistLabelReader reader){
    int counter = 0;
    while (reader.hasNext()){
      int value = (int) reader.next();
      db.addValue(counter ,value);
      counter++;
    }
  }




}

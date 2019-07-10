package KNNmethods;

import MnistRepository.RepositoryMnist;
import MnistRepository.MnistItem;
import java.util.*;

public class KnnFinder {
  private int ImageRecogniser(RepositoryMnist db, int imageIndex, int qntyNeibors, int method) {

    Map<Double, Integer> resultsOfKnn = new TreeMap<Double, Integer>();
    for (int i = 0; i < db.getSize(); i++) {
      MnistItem item2 = db.getItem(i);
      switch (method) {
        case 2:
          resultsOfKnn.put(MetricsMethods.CityDistrictDistance(db,imageIndex, i), db.getValue(i));
          break;
        case 3:
          resultsOfKnn.put(MetricsMethods.VectorsAngleDistance(db,imageIndex, i), db.getValue(i));
          break;
        default:
          resultsOfKnn.put(MetricsMethods.EuqlidDistance(db,imageIndex, i), db.getValue(i));
      }
    }
    ArrayList<Integer> result = new ArrayList<>(resultsOfKnn.values());
    result.subList(0, qntyNeibors);
    Integer maxFrqElement = 0;
    int maxFrq = 0;
    for (Integer label : result) {
      int frq = 0;
      for (int i = 0; i < result.size(); i++) {
        if (label == result.get(i)) {
          frq++;
        }
      }
      if (frq > maxFrq) {
        maxFrq = frq;
        maxFrqElement = label;
      }
    }
    return maxFrqElement;
  }

  public void knnFind(RepositoryMnist db, int howMany, int qntyNeibors, int method){
    int summ = 0;
    double y = 0;
    for (int i = 0; i<howMany; i++)
    {
      int x = ImageRecogniser(db,i,qntyNeibors,method);
      if (x ==db.getValue(i)) {summ++;}
      y = i;
      int z = (int)(100*(y/howMany));
      System.out.print("\rComplited "+z+"%");

    }
    System.out.print("\rComplited 100%");
    System.out.println("\n" + summ + " wright answers");
    System.out.println((howMany-summ) + " errors");
    System.out.println("In the end we have: " + (int)(((y=summ)/howMany)*100) + "% of accuracy");
  }


}

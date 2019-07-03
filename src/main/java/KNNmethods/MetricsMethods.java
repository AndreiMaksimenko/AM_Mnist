package KNNmethods;
import MnistRepository.RepositoryMnist;

final class MetricsMethods {

  static double EuqlidDistance(RepositoryMnist db, int index1, int index2) {
    double distance = 0;
    for (int i = 0; i < db.getImage(index1).length; i++) {
      distance += Math.pow(db.getImage(index1)[i] - db.getImage(index2)[i], 2);
      distance = Math.sqrt(distance);
    }
    return distance;
  }

  static double CityDistrictDistance(RepositoryMnist db, int index1, int index2) {
    double distance = 0;
    for (int i = 0; i < db.getImage(index1).length; i++) {
      distance += Math.abs(db.getImage(index1)[i] - db.getImage(index2)[i]);
    }
    return distance;
  }

  static double VectorsAngleDistance(RepositoryMnist db, int index1, int index2) {
    double multiplySclar = 0;
    double modulItem1 = 0;
    double modulItem2 = 0;
    double distance = 0;

    for (int i = 0; i < db.getImage(index1).length; i++) {
      multiplySclar += db.getImage(index1)[i] * db.getImage(index2)[i];
      modulItem1 += db.getImage(index1)[i] * db.getImage(index1)[i];
      modulItem2 += db.getImage(index2)[i] * db.getImage(index2)[i];
    }
    distance = Math.acos(multiplySclar / Math.sqrt(modulItem1 * modulItem2));
    return distance;
  }










}



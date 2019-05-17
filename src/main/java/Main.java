
import KNNmethods.KnnFinder;
import MnistDB.*;
import MnistDB.Model.RepositoryMnist;




public class Main {


  public static void main(String[] args) {
    RepositoryMnist db = new RepositoryMnist();
    MnistImageReader MyNistImages = new MnistImageReader(db,"f:\\JAVA\\AM_Mnist\\src\\main\\resources\\t10k-images.idx3-ubyte");
    MnistLabelReader MyNistLabels = new MnistLabelReader(db, "f:\\JAVA\\AM_Mnist\\src\\main\\resources\\t10k-labels.idx1-ubyte");
//    MyNistLabels.getDataValues();   //получить размерности из магического номера лэйблов
//    MyNistImages.getDataValues();   //получить размерности из магического номера имиджей

    DBController.addImages(db,MyNistImages);
    DBController.addLabels(db,MyNistLabels);
//    db.printImage(0);  //напечатает картинку по индексу

KnnFinder finder = new KnnFinder();
finder.knnFind(db,db.getSize(),6,1);






  }

}

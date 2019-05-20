
import KNNmethods.KnnFinder;
import MnistRepository.RepositoryMnist;




public class Main {


  public static void main(String[] args) {
    String imageFile = "f:\\JAVA\\AM_Mnist\\src\\main\\resources\\t10k-images.idx3-ubyte";
    String labelFile = "f:\\JAVA\\AM_Mnist\\src\\main\\resources\\t10k-labels.idx1-ubyte";
    RepositoryMnist db = new RepositoryMnist(imageFile,labelFile);
    db.getImagesData();
    db.getLabelsData();
    KnnFinder finder = new KnnFinder();
    finder.knnFind(db,db.getSize(),6,1);






  }

}

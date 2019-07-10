import KNNmethods.KnnFinder;
import MnistRepository.RepositoryMnist;
import NeuralNetwork.NeuralNetwork;


public class Main {


  public static void main(String[] args) {

    String imageFile = "f:\\JAVA\\AM_Mnist\\src\\main\\resources\\t10k-images.idx3-ubyte";
    String labelFile = "f:\\JAVA\\AM_Mnist\\src\\main\\resources\\t10k-labels.idx1-ubyte";
//    String imageFile = "f:\\JAVA\\AM_Mnist\\src\\main\\resources\\train-images.idx3-ubyte";
//    String labelFile = "f:\\JAVA\\AM_Mnist\\src\\main\\resources\\train-labels.idx1-ubyte";
    System.out.print("Data loading...");
    RepositoryMnist db = new RepositoryMnist(imageFile,labelFile);
    System.out.print("Complite" + "\n");

      db.getImagesData();
      db.getLabelsData();
//    db.printImage(13);
//    KnnFinder finder = new KnnFinder();
//    finder.knnFind(db,500,5,3);

    int[] neurons = {151,73};
    NeuralNetwork nn = new NeuralNetwork(0.07, neurons);
    nn.trainNetwork(db,5);


//    imageFile = "f:\\JAVA\\AM_Mnist\\src\\main\\resources\\train-images.idx3-ubyte";
//    labelFile = "f:\\JAVA\\AM_Mnist\\src\\main\\resources\\train-labels.idx1-ubyte";
//
//    System.out.print("\nData loading...");
//    db = new RepositoryMnist(imageFile,labelFile);
//    System.out.println("Complite");
//    db.getImagesData();
//    db.getLabelsData();

      nn.testNetwork(db);






  }

}

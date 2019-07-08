import KNNmethods.KnnFinder;
import MnistRepository.RepositoryMnist;
import NeuralNetwork.NeuralNetwork;


public class Main {


  public static void main(String[] args) {

    String imageFile = "f:\\JAVA\\AM_Mnist\\src\\main\\resources\\t10k-images.idx3-ubyte";
    String labelFile = "f:\\JAVA\\AM_Mnist\\src\\main\\resources\\t10k-labels.idx1-ubyte";
    System.out.print("Data loading...");
    RepositoryMnist db = new RepositoryMnist(imageFile,labelFile);
    System.out.print("Complite");

    db.getImagesData();
    db.getLabelsData();
    db.printImage(13);

//    KnnFinder finder = new KnnFinder();
//    finder.knnFind(db,500,5,3);
//
    int[] neurons = {15,7,6};
    NeuralNetwork nn = new NeuralNetwork(0.1, neurons);
    nn.trainNetwork(db,2);







  }

}

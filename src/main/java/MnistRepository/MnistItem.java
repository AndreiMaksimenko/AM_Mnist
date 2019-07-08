package MnistRepository;

public class MnistItem {

  private int value;
  private double[] image = new double[784];

  MnistItem() {
  }

  int getValue() {
    return value;
  }

  double[] getImage() {
    return image;
  }

  void setValue(int value) {
    this.value = value;
  }

  void setImage(double[] image) {
    this.image = image;
  }

}

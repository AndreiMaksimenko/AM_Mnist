package MnistRepository;

public class MnistItem {

  private int value;
  private int calculation;
  private int[] image = new int[784];

  MnistItem() {
  }

  int getValue() {
    return value;
  }

  int[] getImage() {
    return image;
  }

  void setValue(int value) {
    this.value = value;
  }

  void setImage(int[] image) {
    this.image = image;
  }

}

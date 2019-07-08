package NeuralNetwork;


class OutputLayer implements NNLayer {

  private int label;
  private double[] inputSignals; //Входящие сигналы по поличеству нейронов на предыдущем слое
  private double[] errors; //ошибки выходов
  private double[] answers; //массив правильного ответа


  /**
   * Задать ответ в label в виде инта
   * И создет матрицу ответов answers для корректировки ошибок слоя
   **/



  void setLabel(int label) {
    this.label = label;
    answers = new double[10];
    for (int i = 0; i<answers.length; i++) {
      answers[i] = i == label ?  1 : 0;
    }
  }


  /**
   * Возвращает правильный ответ
   **/
  public int getLabel() {
    return label;
  }


  /**
   * Пересчитывает ошибки в этом слое изходя из матрицы правильного ответа answers
   * Возвращает ошибки для предыдущего слоя
   **/
  @Override
  public double[] GetPropagationErrors() {
    for (int i = 0; i<inputSignals.length; i++){
    errors[i] = answers[i]-inputSignals[i];
    }
    return errors;
  }


  /**
   * Возвращает сигналы которые получились на выходе сети
   **/

  @Override
  public double[] GetOutputSignals() {
    return inputSignals;
  }



  /**
   * Возвращает количество нейронов в слое
   **/

  @Override
  public int GetLength() {
    return inputSignals.length;
  }


  /**
   * Задает входящие сигналы с предыдущего нейронного слоя
   * Можно получить методом GetOutputSignals() от предыдущего нейронного слоя
   **/

  @Override
  public void setSignals(double[] signals) {
    this.inputSignals = signals;
  }







  //ХЛАААМММ!!!!!!!!!!!!!


  /**
   * Артефактный метод
   * разберись и  удали !!!
   **/

  @Override
  public void setForwardLayer(NNLayer forwardLayer) {

  }
}

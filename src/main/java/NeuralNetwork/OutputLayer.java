package NeuralNetwork;


class OutputLayer implements NNLayer {

  private int label;
  private double[] inputSignals =new double[10]; //Входящие сигналы по поличеству нейронов на предыдущем слое
  private double[] errors = new double[10]; //ошибки выходов
  private double[] answers = new double[10]; //массив правильного ответа


  /**
   * Задать ответ в label в виде инта
   * И создет матрицу ответов answers для корректировки ошибок слоя
   **/


  void setLabel(int label) {
    this.label = label;
    // answers = new double[10];
    for (int i = 0; i < answers.length; i++) {
      answers[i] = i == label ? 1 : 0;
    }

  }


  /**
   * Возвращает правильный ответ
   **/
  int getLabel() {
    return label;
  }


  /**
   * Пересчитывает ошибки в этом слое изходя из матрицы правильного ответа answers
   **/
  private void ReCalcPropagationErrors() {
    for (int i = 0; i < inputSignals.length; i++) {
      this.errors[i] = NetCalc.EndNeuronError(answers[i], inputSignals[i]);
    }

//    for (int i = 0; i < inputSignals.length; i++) {
//      errors[i] = (answers[i] - inputSignals[i]) * ((1 - inputSignals[i]) * inputSignals[i]);
//    }
    //return errors;
  }


  /**
   * Возвращает ошибки для предыдущего слоя
   **/

  @Override
  public double[] GetErrors() {
    ReCalcPropagationErrors();
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


  int getResult() {
    double max = inputSignals[0];
    int maxIndx = 0;
    for (int i = 0; i < inputSignals.length; i++) {
      if (inputSignals[i] > max) {
        max = inputSignals[i];
        maxIndx = i;
      }
    }

    return maxIndx;
  }

  public String toString() {
    StringBuilder x = new StringBuilder();
    for (int i = 0; i < inputSignals.length; i++) {
      x.append("Index: ").append(i).append(": ").append(inputSignals[i]).append("; ");
    }
    return x.toString();
  }

  String MSEPrint() {
    StringBuilder sb = new StringBuilder();
    double errorMSE = 0;
    for (int i = 0; i < answers.length; i++) {
      errorMSE += (answers[i] - inputSignals[i]) * (answers[i] - inputSignals[i]);
    }
    errorMSE = errorMSE / answers.length;
    sb.append(errorMSE);
    return sb.toString();
  }

}

package NeuralNetwork;


class HiddenLayer implements NNLayer {
  private double[] inputSignals; //Входящие сигналы по поличеству нейронов на предыдущем слое
  private double[][] weights; //Веса на все входящие ребра
  private int neurons; // количество нейронов этого слоя
  private double[] errors; //ошибки этого слоя
  private NNLayer forwardLayer;
  private NNLayer backLayer;
  private double learningRate;

  /**
   * Конструктор - создает слой первый раз для тренировки, передать: количество нейронов в слое, ссылку на предыдущий слой, и Learning rate
   **/
  HiddenLayer(int neurons, NNLayer backLayer, double learningRate) {
    this.neurons = neurons;
    this.backLayer = backLayer;
    this.learningRate = learningRate;
    SetWeightsForFistTime();
  }


  /**
   * Задает рандомно веса при первом создании слоя
   **/
  private void SetWeightsForFistTime() {
    int strokes = backLayer.GetLength();
    this.weights = new double[strokes][this.neurons];
    for (int i = 0; i < weights.length; i++) {
      for (int j = 0; j < weights[i].length; j++) {
        weights[i][j] = Math.random();
      }
    }
  }




  /**
   * Задать ссылку на следующий слой, октуда мы возьмем ошибки этого слоя
   **/
  @Override
  public void setForwardLayer(NNLayer forwardLayer) {
    this.forwardLayer = forwardLayer;
  }





  /**
   * Задает входящие сигналы с предыдущего нейронного слоя
   * Можно получить методом GetOutputSignals() от предыдущего нейронного слоя
   **/
  @Override
  public void setSignals(double[] signals) {
    this.inputSignals = signals;
  }





  /**
   * Возвращает выходной сигнал после функции активации(сигмоида) для каждого нейрона
   * Выходной сигнал используется следующим слоем
   **/
  @Override
  public double[] GetOutputSignals() {
    double[] outputSignals = new double[neurons];
    for (int i = 0; i < neurons; i++) {
      double summOfSignalsToNeuron = 0;
      for (int j = 0; j < neurons; j++) {
        summOfSignalsToNeuron += inputSignals[j] * weights[i][j];  // Сумма входяхих сигналов умноженная на их вес
      }
      outputSignals[i] = NetCalc.Sigmoid(summOfSignalsToNeuron); // Сигмоид от суммы входящих сигналов умноженных на вес
    }
    return outputSignals;
  }


  /**
   * Возвращает количество нейронов в слое
   **/
  @Override
  public int GetLength() {
    return neurons;
  }





  /**
   * Возвращает ошибки для предыдущего слоя
   **/
  @Override
  public double[] GetPropagationErrors() {
    //this.SetLayerErrors();
    double[] propogationErrors = new double[inputSignals.length];
    for (int i = 0; i < propogationErrors.length; i++) {
      for (int j = 0; j < neurons; j++) {
        propogationErrors[i] += weights[i][j] * errors[j];
      }
    }
    return propogationErrors;
  }



  /**
   * Получить ощибки со следующего слоя и задаст в этом слое
   **/
  void SetLayerErrors() {
    this.errors = forwardLayer.GetPropagationErrors();
  }




  /**
   * Пересчитать веса в этом слое
   * Делается только после коррекции ошибок
   **/

  void ChangeWeights() //Изменит веса
  {
    double[] signals = this.GetOutputSignals();
    for (int i = 0; i < inputSignals.length; i++) {
      for (int j = 0; j < neurons; j++) {
        weights[i][j] = weights[i][j] + errors[j] * signals[i] * (1 - signals[j]) * inputSignals[i] * learningRate;
      }
    }
  }


}

package NeuralNetwork;


import static NeuralNetwork.NetCalc.NewWeights;

class HiddenLayer implements NNLayer {
  private double[] inputSignals; //Входящие сигналы по поличеству нейронов на предыдущем слое
  private double[][] inputWeights; //Веса на все входящие ребра
  private int neurons; // количество нейронов этого слоя
  private double[] errors; //ошибки этого слоя
  private double[] errorsForBackLayer; //ошибки для предыдущего слоя
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
   * от -1 до 1
   **/
  private void SetWeightsForFistTime() {
    this.inputWeights = new double[backLayer.GetLength()][this.GetLength()];
    for (int i = 0; i < inputWeights.length; i++) {
      for (int j = 0; j < inputWeights[i].length; j++) {
        inputWeights[i][j] = ((Math.random() * 2) - 1);
      }
    }
  }


  /**
   * Задать ссылку на следующий слой, октуда мы возьмем ошибки этого слоя
   **/
  void setForwardLayer(NNLayer forwardLayer) {
    this.forwardLayer = forwardLayer;
    this.errors = new double[forwardLayer.GetLength()];
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
    double[] outputSignals = new double[this.GetLength()];
    for (int i = 0; i < outputSignals.length; i++) {
      double summOfSignalsToNeuron = 0;
      for (int j = 0; j < inputSignals.length; j++) {
        summOfSignalsToNeuron += inputSignals[j] * inputWeights[j][i];  // Сумма входяхих сигналов умноженная на их вес
      }
      //outputSignals[i] = 1/( 1 + Math.pow(Math.E,(-1*summOfSignalsToNeuron))); //сигмоид
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
   * Пересчитывает ошибки для предыдущего слоя
   **/

  private void ReCalcPropagationErrors() {
    this.errorsForBackLayer = new double[backLayer.GetLength()];
    for (int output = 0; output < backLayer.GetLength(); output++) {
      errorsForBackLayer[output] = NetCalc.HiddenNeuronError(errors, inputWeights[output], inputSignals[output]);
    }
//this.ChangeErrorsAndWeights();
//    for (int i = 0; i < propagationErrors.length; i++) {
//      for (int j = 0; j < neurons; j++) {
//        propagationErrors[i] += inputWeights[i][j] * errors[j];
//      }
//      propagationErrors[i] = propagationErrors[i] * (1-inputSignals[i])*inputSignals[i];
//    }
//return propagationErrors;
// this.errors = propagationErrors;

  }

  /**
   * Вызывает пересчёт ошибок и возвращает их для предыдущего слоя
   **/
  @Override
  public double[] GetErrorsForBackLayer() {
    ReCalcPropagationErrors();
    return errorsForBackLayer;
  }


  /**
   * Получить ощибки со следующего слоя и задаст в этом слое
   **/
  void ChangeErrorsAndWeights() {
    this.errors = forwardLayer.GetErrorsForBackLayer();
    this.inputWeights= NewWeights(inputWeights, errors, inputSignals, learningRate);
  }


//  /**
//   * Пересчитать веса в этом слое
//   * Делается только после коррекции ошибок
//   **/

//  void ChangeWeights() //Изменит веса
//  {
//    this.inputWeights= NewWeights(inputWeights, errors, inputSignals, learningRate);
//
//
//    ////    double[] signals = this.GetOutputSignals();
////
////    for (int i = 0; i < inputSignals.length; i++) {
////      for (int j = 0; j < neurons; j++) {
////        inputWeights[i][j] = inputWeights[i][j] + errors[j] * inputSignals[i] * learningRate; //ошибка
////      }
////    }
//  }


}
